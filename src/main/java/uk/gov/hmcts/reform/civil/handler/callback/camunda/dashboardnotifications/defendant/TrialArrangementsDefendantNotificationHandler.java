package uk.gov.hmcts.reform.civil.handler.callback.camunda.dashboardnotifications.defendant;

import org.springframework.stereotype.Service;

import uk.gov.hmcts.reform.civil.callback.DashboardCallbackHandler;
import uk.gov.hmcts.reform.civil.callback.CallbackParams;
import uk.gov.hmcts.reform.civil.callback.CaseEvent;
import uk.gov.hmcts.reform.civil.client.DashboardApiClient;
import uk.gov.hmcts.reform.civil.helpers.sdo.SdoHelper;
import uk.gov.hmcts.reform.civil.model.CaseData;
import uk.gov.hmcts.reform.civil.service.DashboardNotificationsParamsMapper;
import uk.gov.hmcts.reform.civil.service.FeatureToggleService;
import java.util.List;

import static uk.gov.hmcts.reform.civil.callback.CaseEvent.CREATE_DASHBOARD_NOTIFICATION_CP_TRIAL_ARRANGEMENTS_DEFENDANT;
import static uk.gov.hmcts.reform.civil.handler.callback.camunda.dashboardnotifications.DashboardScenarios.SCENARIO_AAA6_CP_TRIAL_ARRANGEMENTS_REQUIRED_DEFENDANT;

@Service
public class TrialArrangementsDefendantNotificationHandler extends DashboardCallbackHandler {

    private static final List<CaseEvent> EVENTS = List.of(CREATE_DASHBOARD_NOTIFICATION_CP_TRIAL_ARRANGEMENTS_DEFENDANT);
    public static final String TASK_ID = "GenerateDashboardDefendantNotificationTrialArrangements";

    public TrialArrangementsDefendantNotificationHandler(DashboardApiClient dashboardApiClient,
                                                         DashboardNotificationsParamsMapper mapper,
                                                         FeatureToggleService featureToggleService) {
        super(dashboardApiClient, mapper, featureToggleService);
    }

    @Override
    public String camundaActivityId(CallbackParams callbackParams) {
        return TASK_ID;
    }

    @Override
    public List<CaseEvent> handledEvents() {
        return EVENTS;
    }

    @Override
    public String getScenario(CaseData caseData) {
        return SCENARIO_AAA6_CP_TRIAL_ARRANGEMENTS_REQUIRED_DEFENDANT.getScenario();
    }

    @Override
    public boolean shouldRecordScenario(CaseData caseData) {
        return caseData.isRespondent1NotRepresented() && SdoHelper.isFastTrack(caseData);
    }
}
