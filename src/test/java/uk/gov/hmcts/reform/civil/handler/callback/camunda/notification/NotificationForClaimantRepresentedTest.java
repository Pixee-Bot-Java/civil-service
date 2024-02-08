package uk.gov.hmcts.reform.civil.handler.callback.camunda.notification;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import uk.gov.hmcts.reform.ccd.client.model.CallbackRequest;
import uk.gov.hmcts.reform.civil.callback.CallbackParams;
import uk.gov.hmcts.reform.civil.enums.YesOrNo;
import uk.gov.hmcts.reform.civil.enums.dq.Language;
import uk.gov.hmcts.reform.civil.handler.callback.BaseCallbackHandlerTest;
import uk.gov.hmcts.reform.civil.model.CaseData;
import uk.gov.hmcts.reform.civil.model.Party;
import uk.gov.hmcts.reform.civil.notify.NotificationService;
import uk.gov.hmcts.reform.civil.notify.NotificationsProperties;
import uk.gov.hmcts.reform.civil.sampledata.CallbackParamsBuilder;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static uk.gov.hmcts.reform.civil.callback.CallbackType.ABOUT_TO_SUBMIT;
import static uk.gov.hmcts.reform.civil.callback.CaseEvent.NOTIFY_CLAIMANT_LIP_AFTER_NOC_APPROVAL;
import static uk.gov.hmcts.reform.civil.callback.CaseEvent.NOTIFY_DEFENDANT_LIP_CLAIMANT_REPRESENTED;

@SpringBootTest(classes = {
    NotificationForClaimantRepresented.class,
    JacksonAutoConfiguration.class,
})
public class NotificationForClaimantRepresentedTest extends BaseCallbackHandlerTest {

    @Autowired
    private NotificationForClaimantRepresented notificationHandler;
    @MockBean
    private NotificationService notificationService;
    @MockBean
    NotificationsProperties notificationsProperties;
    @Captor
    private ArgumentCaptor<String> targetEmail;
    @Captor
    private ArgumentCaptor<String> emailTemplate;
    @Captor
    private ArgumentCaptor<Map<String, String>> notificationDataMap;
    @Captor
    private ArgumentCaptor<String> reference;

    @Nested
    class AboutToSubmitCallback {

        private static final String DEFENDANT_EMAIL_ADDRESS = "defendantmail@hmcts.net";
        private static final String APPLICANT_EMAIL_ADDRESS = "applicantmail@hmcts.net";
        private static final String DEFENDANT_PARTY_NAME = "ABC ABC";
        private static final String REFERENCE_NUMBER = "8372942374";
        private static final String EMAIL_TEMPLATE = "test-notification-id";
        private static final String EMAIL_WELSH_TEMPLATE = "test-notification-welsh-id";
        private static final String CLAIMANT_ORG_NAME = "Org Name";

        @BeforeEach
        void setUp() {
            given(notificationsProperties.getNotifyRespondentLipForClaimantRepresentedTemplate()).willReturn(EMAIL_TEMPLATE);
            given(notificationsProperties.getNotifyClaimantLipForNoLongerAccessTemplate()).willReturn(EMAIL_TEMPLATE);
            given(notificationsProperties.getNotifyClaimantLipForNoLongerAccessWelshTemplate()).willReturn(EMAIL_WELSH_TEMPLATE);
        }

        @Test
        void shouldSendNotificationToDefendantLip_whenEventIsCalledAndDefendantHasEmail() {
            //Given
            CaseData caseData = CaseData.builder()
                .respondent1(Party.builder().type(Party.Type.COMPANY).companyName(DEFENDANT_PARTY_NAME).partyEmail(
                    DEFENDANT_EMAIL_ADDRESS).build())
                .applicant1(Party.builder().type(Party.Type.COMPANY).companyName(CLAIMANT_ORG_NAME).build())
                .legacyCaseReference(REFERENCE_NUMBER)
                .addApplicant2(YesOrNo.NO)
                .addRespondent2(YesOrNo.NO)
                .build();
            CallbackParams params = CallbackParamsBuilder.builder().of(ABOUT_TO_SUBMIT, caseData)
                .request(CallbackRequest.builder().eventId(NOTIFY_DEFENDANT_LIP_CLAIMANT_REPRESENTED.name()).build()).build();
            //When
            notificationHandler.handle(params);
            //Then
            verify(notificationService, times(1)).sendMail(targetEmail.capture(),
                                                           emailTemplate.capture(),
                                                           notificationDataMap.capture(), reference.capture()
            );
            assertThat(targetEmail.getAllValues().get(0)).isEqualTo(DEFENDANT_EMAIL_ADDRESS);
            assertThat(emailTemplate.getAllValues().get(0)).isEqualTo(EMAIL_TEMPLATE);
        }

        @Test
        public void notifyApplicantAfterNocApproval() {

            //Given
            CaseData caseData = CaseData.builder()
                .respondent1(Party.builder().type(Party.Type.COMPANY).companyName(DEFENDANT_PARTY_NAME).partyEmail(
                    DEFENDANT_EMAIL_ADDRESS).build())
                .applicant1(Party.builder().type(Party.Type.COMPANY).companyName(CLAIMANT_ORG_NAME)
                                .partyEmail(APPLICANT_EMAIL_ADDRESS).build())
                .legacyCaseReference(REFERENCE_NUMBER)
                .addApplicant2(YesOrNo.NO)
                .addRespondent2(YesOrNo.NO)
                .claimantBilingualLanguagePreference(Language.ENGLISH.toString())
                .build();
            CallbackParams params = CallbackParamsBuilder.builder().of(ABOUT_TO_SUBMIT, caseData)
                .request(CallbackRequest.builder().eventId(NOTIFY_CLAIMANT_LIP_AFTER_NOC_APPROVAL.name()).build())
                .build();
            //When
            notificationHandler.handle(params);
            //Then
            verify(notificationService, times(1)).sendMail(targetEmail.capture(),
                                                           emailTemplate.capture(),
                                                           notificationDataMap.capture(), reference.capture()
            );
            assertThat(targetEmail.getAllValues().get(0)).isEqualTo(APPLICANT_EMAIL_ADDRESS);
            assertThat(emailTemplate.getAllValues().get(0)).isEqualTo(EMAIL_TEMPLATE);
        }

        @Test
        public void notifyApplicantAfterNocApprovalBilingual() {

            //Given
            CaseData caseData = CaseData.builder()
                .respondent1(Party.builder().type(Party.Type.COMPANY).companyName(DEFENDANT_PARTY_NAME).partyEmail(
                    DEFENDANT_EMAIL_ADDRESS).build())
                .applicant1(Party.builder().type(Party.Type.COMPANY).companyName(CLAIMANT_ORG_NAME)
                                .partyEmail(APPLICANT_EMAIL_ADDRESS).build())
                .legacyCaseReference(REFERENCE_NUMBER)
                .addApplicant2(YesOrNo.NO)
                .addRespondent2(YesOrNo.NO)
                .claimantBilingualLanguagePreference(Language.WELSH.toString())
                .build();
            CallbackParams params = CallbackParamsBuilder.builder().of(ABOUT_TO_SUBMIT, caseData)
                .request(CallbackRequest.builder().eventId(NOTIFY_CLAIMANT_LIP_AFTER_NOC_APPROVAL.name()).build())
                .build();
            //When
            notificationHandler.handle(params);
            //Then
            verify(notificationService, times(1)).sendMail(targetEmail.capture(),
                                                           emailTemplate.capture(),
                                                           notificationDataMap.capture(), reference.capture()
            );
            assertThat(targetEmail.getAllValues().get(0)).isEqualTo(APPLICANT_EMAIL_ADDRESS);
            assertThat(emailTemplate.getAllValues().get(0)).isEqualTo(EMAIL_WELSH_TEMPLATE);
        }
    }
}
