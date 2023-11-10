package uk.gov.hmcts.reform.civil.handler.callback.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import uk.gov.hmcts.reform.ccd.client.model.AboutToStartOrSubmitCallbackResponse;
import uk.gov.hmcts.reform.civil.callback.CallbackParams;
import uk.gov.hmcts.reform.civil.enums.CaseState;
import uk.gov.hmcts.reform.civil.enums.MediationDecision;
import uk.gov.hmcts.reform.civil.handler.callback.BaseCallbackHandlerTest;
import uk.gov.hmcts.reform.civil.helpers.LocationHelper;
import uk.gov.hmcts.reform.civil.model.CaseData;
import uk.gov.hmcts.reform.civil.model.Party;
import uk.gov.hmcts.reform.civil.model.citizenui.CaseDataLiP;
import uk.gov.hmcts.reform.civil.model.citizenui.ClaimantMediationLip;
import uk.gov.hmcts.reform.civil.model.defaultjudgment.CaseLocationCivil;
import uk.gov.hmcts.reform.civil.model.dq.Applicant1DQ;
import uk.gov.hmcts.reform.civil.model.dq.RequestedCourt;
import uk.gov.hmcts.reform.civil.model.dq.Respondent1DQ;
import uk.gov.hmcts.reform.civil.referencedata.LocationRefDataService;
import uk.gov.hmcts.reform.civil.referencedata.model.LocationRefData;
import uk.gov.hmcts.reform.civil.sampledata.CaseDataBuilder;
import uk.gov.hmcts.reform.civil.service.citizen.UpdateCaseManagementDetailsService;
import uk.gov.hmcts.reform.civil.service.citizenui.ResponseOneVOneShowTagService;
import uk.gov.hmcts.reform.civil.utils.CourtLocationUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static uk.gov.hmcts.reform.civil.callback.CallbackType.ABOUT_TO_START;
import static uk.gov.hmcts.reform.civil.callback.CallbackType.ABOUT_TO_SUBMIT;
import static uk.gov.hmcts.reform.civil.callback.CaseEvent.CLAIMANT_RESPONSE_CUI;
import static uk.gov.hmcts.reform.civil.enums.YesOrNo.NO;
import static uk.gov.hmcts.reform.civil.model.Party.Type.COMPANY;
import static uk.gov.hmcts.reform.civil.model.Party.Type.ORGANISATION;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {
    ClaimantResponseCuiCallbackHandler.class,
    JacksonAutoConfiguration.class,
    ResponseOneVOneShowTagService.class,
    JacksonAutoConfiguration.class,
    CourtLocationUtils.class,
    LocationRefDataService.class,
    LocationHelper.class,
    UpdateCaseManagementDetailsService.class
})
class ClaimantResponseCuiCallbackHandlerTest extends BaseCallbackHandlerTest {

    @Autowired
    private CourtLocationUtils courtLocationUtility;
    @MockBean
    private LocationHelper locationHelper;
    @MockBean
    private LocationRefDataService locationRefDataService;
    @Autowired
    private ClaimantResponseCuiCallbackHandler handler;
    private static final String  courtLocation = "Site 1 - Adr 1 - AAA 111";

    @Autowired
    private final ObjectMapper mapper = new ObjectMapper();

    @MockBean
    private ResponseOneVOneShowTagService responseOneVOneShowTagService;

    @Nested
    class AboutToStartCallback {

        @Test
        void shouldReturnNoError_WhenAboutToStartIsInvoked() {
            CaseData caseData = CaseDataBuilder.builder().atStateClaimIssued().build();
            CallbackParams params = callbackParamsOf(caseData, ABOUT_TO_START);

            var response = (AboutToStartOrSubmitCallbackResponse) handler.handle(params);

            assertThat(response.getErrors()).isNull();
        }
    }

    @Nested
    class AboutToSubmitCallback {

        @BeforeEach
        void before() {
            LocationRefData locationRefData = LocationRefData.builder().siteName("Site 1").courtAddress("Adr 1").postcode("AAA 111")
                .courtName("Court Name").region("Region").regionId("1").courtVenueId("1")
                .courtTypeId("10").courtLocationCode("court1")
                .epimmsId("111").build();
            given(locationRefDataService.getCourtLocationsForDefaultJudgments(any()))
                .willReturn(getSampleCourLocationsRefObject());
            given(locationHelper.updateCaseManagementLocation(any(), any(), any())).willReturn(Optional.ofNullable(locationRefData));
        }

        @Test
        void shouldUpdateBusinessProcess() {
            CaseData caseData = CaseDataBuilder.builder()
                .atStateClaimIssued1v1LiP()
                .caseDataLip(
                    CaseDataLiP.builder()
                        .applicant1ClaimMediationSpecRequiredLip(
                            ClaimantMediationLip.builder()
                                .hasAgreedFreeMediation(MediationDecision.Yes)
                                .build())
                        .build())
                .build();

            CallbackParams params = callbackParamsOf(caseData, ABOUT_TO_SUBMIT);
            var response = (AboutToStartOrSubmitCallbackResponse) handler.handle(params);

            assertThat(response.getData())
                .extracting("businessProcess")
                .extracting("camundaEvent")
                .isEqualTo(CLAIMANT_RESPONSE_CUI.name());
            assertThat(response.getData())
                .extracting("businessProcess")
                .extracting("status")
                .isEqualTo("READY");
        }

        @Test
        void shouldOnlyUpdateClaimStatus_whenPartAdmitNotSettled_NoMediation() {
            Applicant1DQ applicant1DQ =
                Applicant1DQ.builder().applicant1DQRequestedCourt(RequestedCourt.builder()
                                                                      .responseCourtCode("court1")
                                                                      .caseLocation(CaseLocationCivil.builder()
                                                                                        .region(courtLocation)
                                                                                        .baseLocation(courtLocation)
                                                                                        .build())
                                                                      .build()).build();
            Respondent1DQ respondent1DQ =
                Respondent1DQ.builder().respondent1DQRequestedCourt(RequestedCourt.builder()
                                                                        .responseCourtCode("court2")
                                                                        .caseLocation(CaseLocationCivil.builder()
                                                                                          .region(courtLocation)
                                                                                          .baseLocation(courtLocation)
                                                                                          .build())
                                                                        .build()).build();
            CaseData caseData = CaseDataBuilder.builder()
                .atStateClaimIssued()
                .applicant1PartAdmitConfirmAmountPaidSpec(NO)
                .applicant1PartAdmitIntentionToSettleClaimSpec(NO)
                .applicant1DQ(applicant1DQ)
                .respondent1DQ(respondent1DQ)
                .applicant1AcceptAdmitAmountPaidSpec(NO)
                .caseDataLip(CaseDataLiP.builder().applicant1ClaimMediationSpecRequiredLip(ClaimantMediationLip.builder().hasAgreedFreeMediation(
                        MediationDecision.No).build())
                                 .build())
                .build();
            CallbackParams params = callbackParamsOf(caseData, ABOUT_TO_SUBMIT);

            var response = (AboutToStartOrSubmitCallbackResponse) handler.handle(params);

            assertThat(response.getData())
                .extracting("businessProcess")
                .extracting("camundaEvent")
                .isEqualTo(CLAIMANT_RESPONSE_CUI.name());
            assertThat(response.getData())
                .extracting("businessProcess")
                .extracting("status")
                .isEqualTo("READY");

            assertThat(response.getState()).isEqualTo(CaseState.JUDICIAL_REFERRAL.name());
            CaseData data = mapper.convertValue(response.getData(), CaseData.class);
            assertThat(data.getApplicant1DQ().getApplicant1DQRequestedCourt().getResponseCourtCode()).isEqualTo("court1");
            assertThat(data.getCaseNameHmctsInternal()).isEqualTo(data.getApplicant1().getPartyName() + " v " + data.getRespondent1().getPartyName());
        }

        @Test
        void shouldChangeCaseState_whenApplicantRejectClaimSettlementAndAgreeToMediation() {
            CaseData caseData = CaseDataBuilder.builder()
                .atStateClaimIssued()
                .applicant1PartAdmitConfirmAmountPaidSpec(NO)
                .caseDataLip(CaseDataLiP.builder().applicant1ClaimMediationSpecRequiredLip(ClaimantMediationLip.builder().hasAgreedFreeMediation(
                    MediationDecision.Yes).build())
                            .build())
                .build();

            CallbackParams params = callbackParamsOf(caseData, ABOUT_TO_SUBMIT);
            var response = (AboutToStartOrSubmitCallbackResponse) handler.handle(params);

            assertThat(response.getState()).isEqualTo(CaseState.IN_MEDIATION.name());
        }

        protected List<LocationRefData> getSampleCourLocationsRefObject() {
            return new ArrayList<>(List.of(
                LocationRefData.builder()
                    .epimmsId("111").siteName("Site 1").courtAddress("Adr 1").postcode("AAA 111")
                    .courtLocationCode("court1").build(),
                LocationRefData.builder()
                    .epimmsId("222").siteName("Site 2").courtAddress("Adr 2").postcode("BBB 222")
                    .courtLocationCode("court2").build(),
                LocationRefData.builder()
                    .epimmsId("333").siteName("Site 3").courtAddress("Adr 3").postcode("CCC 333")
                    .courtLocationCode("court3").build()
            ));
        }

        @Test
        void shouldChangeCaseState_whenApplicantRejectRepaymentPlanAndIsCompany_toAllFinalOrdersIssued() {
            CaseData caseData = CaseDataBuilder.builder()
                .atStateClaimIssued()
                .applicant1AcceptPartAdmitPaymentPlanSpec(NO)
                .respondent1(Party.builder()
                                   .type(COMPANY)
                                   .companyName("Test Inc")
                                   .build())
                .build();

            CallbackParams params = callbackParamsOf(caseData, ABOUT_TO_SUBMIT);
            var response = (AboutToStartOrSubmitCallbackResponse) handler.handle(params);

            assertThat(response.getState()).isEqualTo(CaseState.PROCEEDS_IN_HERITAGE_SYSTEM.name());
        }

        @Test
        void shouldChangeCaseState_whenApplicantRejectRepaymentPlanAndIsOrganisation_toAllFinalOrdersIssued() {
            CaseData caseData = CaseDataBuilder.builder()
                .atStateClaimIssued()
                .applicant1AcceptPartAdmitPaymentPlanSpec(NO)
                .respondent1(Party.builder()
                                 .type(ORGANISATION)
                                 .companyName("Test Inc")
                                 .build())
                .build();

            CallbackParams params = callbackParamsOf(caseData, ABOUT_TO_SUBMIT);
            var response = (AboutToStartOrSubmitCallbackResponse) handler.handle(params);

            assertThat(response.getState()).isEqualTo(CaseState.PROCEEDS_IN_HERITAGE_SYSTEM.name());
        }
    }

    @Test
    void handleEventsReturnsTheExpectedCallbackEvents() {
        assertThat(handler.handledEvents()).containsOnly(CLAIMANT_RESPONSE_CUI);
    }

}
