package uk.gov.hmcts.reform.civil.controllers.dashboard.scenarios.claimant;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import uk.gov.hmcts.reform.ccd.client.model.CallbackRequest;
import uk.gov.hmcts.reform.civil.callback.CallbackParams;
import uk.gov.hmcts.reform.civil.callback.CaseEvent;
import uk.gov.hmcts.reform.civil.controllers.DashboardBaseIntegrationTest;
import uk.gov.hmcts.reform.civil.documentmanagement.model.CaseDocument;
import uk.gov.hmcts.reform.civil.documentmanagement.model.Document;
import uk.gov.hmcts.reform.civil.enums.YesOrNo;
import uk.gov.hmcts.reform.civil.handler.callback.camunda.dashboardnotifications.claimant.OrderMadeClaimantNotificationHandler;
import uk.gov.hmcts.reform.civil.model.CaseData;
import uk.gov.hmcts.reform.civil.sampledata.CallbackParamsBuilder;
import uk.gov.hmcts.reform.civil.sampledata.CaseDataBuilder;
import uk.gov.hmcts.reform.civil.utils.ElementUtils;

import java.util.List;
import java.util.Map;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static uk.gov.hmcts.reform.civil.callback.CallbackType.ABOUT_TO_SUBMIT;

public class OrderMadeClaimantScenarioTest extends DashboardBaseIntegrationTest {

    @Autowired
    private OrderMadeClaimantNotificationHandler handler;

    @Test
    void should_create_order_made_claimant_scenario() throws Exception {

        String caseId = "72014545415";

        CaseData caseData = CaseDataBuilder.builder().atStateRespondentPartAdmissionSpec().build()
            .toBuilder()
            .legacyCaseReference("reference")
            .ccdCaseReference(Long.valueOf(caseId))
            .applicant1Represented(YesOrNo.NO)
            .finalOrderDocumentCollection(List.of(ElementUtils.element(
                CaseDocument.builder().documentLink(Document.builder().documentBinaryUrl("url").build()).build())))
            .build();

        handler.handle(callbackParamsTest(caseData));

        //Verify Notification is created
        doGet(BEARER_TOKEN, GET_NOTIFICATIONS_URL, caseId, "CLAIMANT")
            .andExpect(status().isOk())
            .andExpectAll(
                status().is(HttpStatus.OK.value()),
                jsonPath("$[0].titleEn").value("An order has been made"),
                jsonPath("$[0].descriptionEn").value(
                    "<p class=\"govuk-body\">The judge has made an order on your claim. "
                        + "<a href=\"{VIEW_FINAL_ORDER}\" rel=\"noopener noreferrer\" target=\"_blank\""
                        + " class=\"govuk-link\">View the order</a>.</p>"),
                jsonPath("$[0].titleCy").value("An order has been made"),
                jsonPath("$[0].descriptionCy").value(
                    "<p class=\"govuk-body\">The judge has made an order on your claim. "
                        + "<a href=\"{VIEW_FINAL_ORDER}\" rel=\"noopener noreferrer\" target=\"_blank\""
                        + " class=\"govuk-link\">View the order</a>.</p>")
            );
    }

    private static CallbackParams callbackParamsTest(CaseData caseData) {
        return CallbackParamsBuilder.builder()
            .of(ABOUT_TO_SUBMIT, caseData)
            .request(CallbackRequest.builder().eventId(
                CaseEvent.CREATE_DASHBOARD_NOTIFICATION_FINAL_ORDER_CLAIMANT.name()).build())
            .params(Map.of(CallbackParams.Params.BEARER_TOKEN, BEARER_TOKEN))
            .build();
    }

}
