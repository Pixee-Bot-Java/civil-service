package uk.gov.hmcts.reform.civil.controllers.dashboard.scenarios.claimant;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import uk.gov.hmcts.reform.civil.controllers.DashboardBaseIntegrationTest;
import uk.gov.hmcts.reform.civil.enums.CaseState;
import uk.gov.hmcts.reform.civil.handler.callback.camunda.dashboardnotifications.defendant.ClaimantResponseDefendantNotificationHandler;
import uk.gov.hmcts.reform.civil.model.CaseData;
import uk.gov.hmcts.reform.civil.sampledata.CaseDataBuilder;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static uk.gov.hmcts.reform.civil.enums.YesOrNo.NO;

public class ClaimantResponseDefendantNotificationScenarioTest extends DashboardBaseIntegrationTest {

    @Autowired
    private ClaimantResponseDefendantNotificationHandler handler;

    @Test
    void shouldCreateNotification_forDefendantWhenClaimantProceedsCarm() throws Exception {
        String caseId = String.valueOf(System.currentTimeMillis());
        CaseData caseData = CaseDataBuilder.builder().atStateTrialReadyCheck().build()
            .toBuilder()
            .legacyCaseReference("reference")
            .ccdCaseReference(Long.valueOf(caseId))
            .respondent1Represented(NO)
            .ccdState(CaseState.IN_MEDIATION)
            .build();

        when(featureToggleService.isCarmEnabledForCase(any())).thenReturn(true);

        handler.handle(callbackParams(caseData));

        //Verify Notification is created
        doGet(BEARER_TOKEN, GET_NOTIFICATIONS_URL, caseId, "DEFENDANT")
            .andExpect(status().isOk())
            .andExpectAll(
                status().is(HttpStatus.OK.value()),
                jsonPath("$[0].titleEn").value("Your claim is now going to mediation"),
                jsonPath("$[0].descriptionEn")
                    .value(
                        "<p class=\"govuk-body\">Your claim is now going to mediation."
                            + " You will be contacted within 28 days with details of your appointment. "
                            + "<br> If you do not attend your mediation appointment, the judge may issue a penalty.</p>"),
                jsonPath("$[0].titleCy").value("Your claim is now going to mediation"),
                jsonPath("$[0].descriptionCy")
                    .value(
                        "<p class=\"govuk-body\">Your claim is now going to mediation."
                            + " You will be contacted within 28 days with details of your appointment. "
                            + "<br> If you do not attend your mediation appointment, the judge may issue a penalty.</p>"));
    }

    @Test
    void shouldCreateNotification_forDefendantWhenClaimantProceeds() throws Exception {
        String caseId = String.valueOf(System.currentTimeMillis());
        CaseData caseData = CaseDataBuilder.builder().atStateTrialReadyCheck().build()
            .toBuilder()
            .legacyCaseReference("reference")
            .ccdCaseReference(Long.valueOf(caseId))
            .respondent1Represented(NO)
            .ccdState(CaseState.IN_MEDIATION)
            .build();

        when(featureToggleService.isCarmEnabledForCase(any())).thenReturn(false);

        handler.handle(callbackParams(caseData));

        //Verify Notification is created
        doGet(BEARER_TOKEN, GET_NOTIFICATIONS_URL, caseId, "DEFENDANT")
            .andExpect(status().isOk())
            .andExpectAll(
                status().is(HttpStatus.OK.value()),
                jsonPath("$[0].titleEn").value("Mr. John Rambo rejected your response"),
                jsonPath("$[0].descriptionEn")
                    .value(
                        "<p class=\"govuk-body\">You've both agreed to try mediation. Your mediation appointment will be arranged within 28 days.</p>"
                            + "<p class=\"govuk-body\"><a href=\"{MEDIATION}\" rel=\"noopener noreferrer\" class=\"govuk-link\" target=\"_blank\">Find out more about how mediation works (opens in a new tab).</a><p/>"
                            + "<p class=\"govuk-body\">They've also sent us their hearing requirements. You can "
                            + "<a href=\"{VIEW_CLAIMANT_HEARING_REQS}\" rel=\"noopener noreferrer\" class=\"govuk-link\" target=\"_blank\">view their hearing requirements (PDF, {VIEW_CLAIMANT_HEARING_REQS_SIZE}).</a></p>"),
                jsonPath("$[0].titleCy").value("Mr. John Rambo rejected your response"),
                jsonPath("$[0].descriptionCy")
                    .value(
                        "<p class=\"govuk-body\">You've both agreed to try mediation. Your mediation appointment will be arranged within 28 days.</p>"
                            + "<p class=\"govuk-body\"><a href=\"{MEDIATION}\" rel=\"noopener noreferrer\" class=\"govuk-link\" target=\"_blank\">Find out more about how mediation works (opens in a new tab).</a><p/>"
                            + "<p class=\"govuk-body\">They've also sent us their hearing requirements. You can "
                            + "<a href=\"{VIEW_CLAIMANT_HEARING_REQS}\" rel=\"noopener noreferrer\" class=\"govuk-link\" target=\"_blank\">view their hearing requirements (PDF, {VIEW_CLAIMANT_HEARING_REQS_SIZE}).</a></p>"));
    }
}