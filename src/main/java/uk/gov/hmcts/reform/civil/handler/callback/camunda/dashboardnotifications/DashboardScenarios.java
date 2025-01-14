package uk.gov.hmcts.reform.civil.handler.callback.camunda.dashboardnotifications;

import lombok.Getter;

@Getter
public enum DashboardScenarios {

    SCENARIO_AAA6_CLAIM_ISSUE_CLAIM_SUBMIT_REQUIRED("Scenario.AAA6.ClaimIssue.ClaimSubmit.Required"),
    SCENARIO_AAA6_CLAIM_ISSUE_CLAIM_FEE_REQUIRED("Scenario.AAA6.ClaimIssue.ClaimFee.Required"),
    SCENARIO_AAA6_CLAIM_ISSUE_RESPONSE_AWAIT("Scenario.AAA6.ClaimIssue.Response.Await"),
    SCENARIO_AAA6_CLAIM_ISSUE_RESPONSE_REQUIRED("Scenario.AAA6.ClaimIssue.Response.Required"),
    SCENARIO_AAA6_CLAIMANT_INTENT_GO_TO_HEARING("Scenario.AAA6.ClaimantIntent.GoToHearing.Claimant"),
    SCENARIO_AAA6_CLAIMANT_INTENT_CLAIM_SETTLED_CLAIMANT("Scenario.AAA6.ClaimantIntent.ClaimSettled.Claimant"),
    SCENARIO_AAA6_CLAIMANT_INTENT_PART_ADMIT_DEFENDANT("Scenario.AAA6.ClaimantIntent.PartAdmit.Defendant"),
    SCENARIO_AAA6_CLAIMANT_INTENT_CLAIM_SETTLED_DEFENDANT("Scenario.AAA6.ClaimantIntent.ClaimSettled.Defendant"),
    SCENARIO_AAA6_CLAIMANT_INTENT_CLAIM_SETTLED_COURT_AGREE_DEFENDANT_DEFENDANT(
        "Scenario.AAA6.ClaimantIntent.SettlementAgreement.ClaimantRejectsPlan.CourtAgreesWithDefendant.Defendant"),
    SCENARIO_AAA6_CLAIM_ISSUE_HWF_REQUESTED("Scenario.AAA6.ClaimIssue.HWF.Requested"),
    SCENARIO_AAA6_CLAIM_ISSUE_HWF_INVALID_REF("Scenario.AAA6.ClaimIssue.HWF.InvalidRef"),
    SCENARIO_AAA6_CLAIM_ISSUE_HWF_INFO_REQUIRED("Scenario.AAA6.ClaimIssue.HWF.InfoRequired"),
    SCENARIO_AAA6_CLAIMANT_INTENT_CCJ_REQUESTED_DEFENDANT("Scenario.AAA6.ClaimantIntent.CCJ.Requested.Defendant"),
    SCENARIO_AAA6_CLAIM_PART_ADMIT_CLAIMANT("Scenario.AAA6.ClaimantIntent.PartAdmit.Claimant"),
    SCENARIO_AAA6_CLAIM_ISSUE_HWF_UPDATED("Scenario.AAA6.ClaimIssue.HWF.Updated"),
    SCENARIO_AAA6_CLAIMANT_INTENT_SETTLEMENT_NO_RESPONSE_CLAIMANT("Scenario.AAA6.ClaimantIntent.SettlementNoResponse.Claimant"),
    SCENARIO_AAA6_CLAIMANT_INTENT_FULL_ADMIT_CLAIMANT("Scenario.AAA6.ClaimantIntent.FullAdmit.Claimant"),
    SCENARIO_AAA6_CLAIMANT_MEDIATION("Scenario.AAA6.ClaimantIntent.Mediation.Claimant"),
    SCENARIO_AAA6_CLAIMANT_INTENT_SETTLEMENT_AGREEMENT_CLAIMANT_REJECTS_COURT_AGREES_WITH_CLAIMANT_DEFENDANT(
        "Scenario.AAA6.ClaimantIntent.SettlementAgreement.ClaimantRejectsPlan.CourtAgreesWithClaimant.Defendant"),
    SCENARIO_AAA6_CLAIMANT_INTENT_SETTLEMENT_AGREEMENT_CLAIMANT_ACCEPTS_DEFENDANT("Scenario.AAA6.ClaimantIntent.SettlementAgreement.ClaimantAcceptsPlan.Defendant"),
    SCENARIO_AAA6_CLAIM_ISSUE_HWF_PART_REMISSION("Scenario.AAA6.ClaimIssue.HWF.PartRemission"),
    SCENARIO_AAA6_CLAIM_ISSUE_HWF_NO_REMISSION("Scenario.AAA6.ClaimIssue.HWF.Rejected"),
    SCENARIO_AAA6_CLAIMANT_INTENT_CCJ_REQUESTED_CLAIMANT("Scenario.AAA6.ClaimantIntent.CCJ.Requested.Claimant"),
    SCENARIO_AAA6_SETTLEMENT_AGREEMENT_DEFENDANT_ACCEPTED_DEFENDANT("Scenario.AAA6.ClaimantIntent.SettlementAgreement.DefendantAccepted.Defendant"),
    SCENARIO_AAA6_CLAIMANT_INTENT_SETTLEMENT_DEFENDANT_RESPONSE_ACCEPTS_CLAIMANT(
        "Scenario.AAA6.ClaimantIntent.Settlement.DefendantResponseAccepts.Claimant"),
    SCENARIO_AAA6_SETTLEMENT_AGREEMENT_DEFENDANT_REJECTED_CLAIMANT("Scenario.AAA6.ClaimantIntent.SettlementAgreement.DefendantRejected.Claimant"),
    SCENARIO_AAA6_SETTLEMENT_AGREEMENT_DEFENDANT_REJECTED_DEFENDANT("Scenario.AAA6.ClaimantIntent.SettlementAgreement.DefendantRejected.Defendant"),
    SCENARIO_AAA6_CLAIMANT_INTENT_GO_TO_HEARING_DEFENDANT_PART_ADMIT("Scenario.AAA6.ClaimantIntent.GoToHearing.DefPartAdmit.Defendant"),
    SCENARIO_AAA6_CLAIMANT_INTENT_GO_TO_HEARING_PART_ADMIT_FULL_DEFENCE_STATES_PAID_CLAIMANT_CONFIRMS_DEFENDANT(
        "Scenario.AAA6.ClaimantIntent.GoToHearing.DefPartAdmit.FullDefence.StatesPaid.ClaimantConfirms.Defendant"
    ),
    SCENARIO_AAA6_CLAIMANT_INTENT_REQUEST_CCJ_REJECT_PLAN_COURT_FAVOURS_DEFENDANT(
        "Scenario.AAA6.ClaimantIntent.RequestCCJ.ClaimantRejectsDefPlan.CourtAgreesWithDef.Defendant"
    ),
    SCENARIO_AAA6_CLAIMANT_INTENT_GO_TO_HEARING_DEF_FULL_DEFENCE_CLAIMANT_DISPUTES_DEFENDANT("Scenario.AAA6.ClaimantIntent.GoToHearing.DefFullDefence.ClaimantDisputes.Defendant"),
    SCENARIO_AAA6_CLAIM_ISSUE_HWF_PHONE_PAYMENT("Scenario.AAA6.ClaimIssue.HWF.PhonePayment"),
    SCENARIO_AAA6_CLAIMANT_INTENT_SETTLEMENT_AGREEMENT("Scenario.AAA6.ClaimantIntent.SettlementAgreement.AcceptOrRejectDefPlan.Claimant"),
    SCENARIO_AAA6_DEFENDANT_ADMIT_PAY_IMMEDIATELY_DEFENDANT("Scenario.AAA6.DefResponse.FullOrPartAdmit.PayImmediately.Defendant"),
    SCENARIO_AAA6_DEFENDANT_ADMIT_PAY_INSTALLMENTS_DEFENDANT("Scenario.AAA6.DefResponse.FullOrPartAdmit.PayByInstalments.Defendant"),
    SCENARIO_AAA6_CLAIMANT_REJECTED_NOT_PAID_DEFENDANT("Scenario.AAA6.ClaimantIntent.GoToHearing.DefPartAdmit.FullDefence.StatesPaid.PartOrFull.ClaimantDisputes.Defendant"),
    SCENARIO_AAA6_CLAIM_ISSUE_HWF_FULL_REMISSION("Scenario.AAA6.ClaimIssue.HWF.FullRemission"),
    SCENARIO_AAA6_DEFENDANT_ADMIT_PAY_BY_SET_DATE_DEFENDANT("Scenario.AAA6.DefResponse.FullOrPartAdmit.PayBySetDate.Defendant"),
    SCENARIO_AAA6_DEFENDANT_ALREADY_PAID("Scenario.AAA6.DefResponse.FullDefenceOrPartAdmin.AlreadyPaid.Defendant"),
    SCENARIO_AAA6_DEFENDANT_FULL_OR_PART_ADMIT_PAY_SET_DATE_ORG_DEFENDANT("Scenario.AAA6.DefResponse.OrgOrLtdCompany.FullOrPartAdmit.PayBySetDate.Defendant"),
    SCENARIO_AAA6_CLAIMANT_INTENT_GO_TO_HEARING_DEF_FULL_DEFENSE_CLAIMANT_DISPUTES_NO_MEDIATION_DEFENDANT(
        "Scenario.AAA6.ClaimantIntent.GoToHearing.DefFullDefence.ClaimantDisputes.NoMediation.Defendant"),
    SCENARIO_AAA6_DEFENDANT_ADMIT_PAY_INSTALLMENTS_ORG_COM_CLAIMANT("Scenario.AAA6.DefResponse.OrgOrLtdCompany.FullOrPartAdmit.PayByInstallments.Claimant"),
    SCENARIO_AAA6_DEFENDANT_FULL_ADMIT_PAY_IMMEDIATELY_CLAIMANT("Scenario.AAA6.DefResponse.FullAdmit.PayImmediately.Claimant"),
    SCENARIO_AAA6_CLAIMANT_INTENT_MEDIATION_DEFENDANT("Scenario.AAA6.ClaimantIntent.Mediation.Defendant"),
    SCENARIO_AAA6_CLAIMANT_INTENT_CLAIM_SETTLED_EVENT_CLAIMANT("Scenario.AAA6.ClaimantIntent.ClaimSettledEvent.Claimant"),
    SCENARIO_AAA6_CLAIMANT_COURT_AGREE_WITH_CLAIMANT_CCJ_DEFENDANT("Scenario.AAA6.ClaimantIntent.RequestCCJ.ClaimantRejectsDefPlan.CourtAgreesWithClaimant.Defendant"),
    SCENARIO_AAA6_DEFENDANT_RESPONSE_FULL_DEFENCE_FULL_DISPUTE_DEFENDANT_CARM("Scenario.AAA6.DefResponse.FullDefence.FullDispute.CARM.Defendant"),
    SCENARIO_AAA6_DEFENDANT_RESPONSE_FULL_DEFENCE_FULL_DISPUTE_CLAIMANT_CARM("Scenario.AAA6.DefResponse.FullDefence.FullDispute.CARM.Claimant"),
    SCENARIO_AAA6_DEFENDANT_RESPONSE_FULL_DEFENCE_ALREADY_PAID_CLAIMANT("Scenario.AAA6.DefResponse.FullDefence.AlreadyPaid.Claimant"),
    SCENARIO_AAA6_DEFENDANT_FULL_OR_PART_ADMIT_PAY_SET_DATE_ORG_CLAIMANT("Scenario.AAA6.DefResponse.OrgOrLtdCompany.FullOrPartAdmit.PayBySetDate.Claimant"),
    SCENARIO_AAA6_DEFRESPONSE_MORETIMEREQUESTED_DEFENDANT("Scenario.AAA6.DefResponse.MoreTimeRequested.Defendant"),
    SCENARIO_AAA6_DEFENDANT_ADMIT_AND_PAID_PARTIAL_ALREADY_CLAIMANT("Scenario.AAA6.DefResponse.PartAdmit.AlreadyPaid.Claimant"),
    SCENARIO_AA6_DEFENDANT_RESPONSE_PAY_BY_INSTALLMENTS_CLAIMANT("Scenario.AAA6.DefResponse.FullOrPartAdmit.PayByInstalments.Claimant"),
    SCENARIO_AAA6_DEFENDANT_RESPONSE_MORE_TIME_REQUESTED_CLAIMANT("Scenario.AAA6.DefResponse.MoreTimeRequested.Claimant"),
    SCENARIO_AAA6_DEFENDANT_FULL_OR_PART_ADMIT_PAY_SET_DATE_CLAIMANT("Scenario.AAA6.DefResponse.FullOrPartAdmit.PayBySetDate.Claimant"),
    SCENARIO_AAA6_CLAIMANT_INTENT_CLAIM_SETTLE_EVENT_DEFENDANT("Scenario.AAA6.ClaimantIntent.ClaimSettleEvent.Defendant"),
    SCENARIO_AAA6_CLAIMANT_MEDIATION_SUCCESSFUL("Scenario.AAA6.MediationSuccessful.CARM.Claimant"),
    SCENARIO_AAA6_DEFENDANT_MEDIATION_SUCCESSFUL("Scenario.AAA6.MediationSuccessful.CARM.Defendant"),
    SCENARIO_AAA6_CLAIMANT_MEDIATION_UNSUCCESSFUL_GENERIC("Scenario.AAA6.MediationUnsuccessful.NOTClaimant1NonContactable.CARM.Claimant"),
    SCENARIO_AAA6_DEFENDANT_MEDIATION_UNSUCCESSFUL_GENERIC("Scenario.AAA6.MediationUnsuccessful.NOTDefendant1NonContactable.CARM.Defendant"),
    SCENARIO_AAA6_CLAIMANT_MEDIATION_UNSUCCESSFUL_CLAIMANT_NONATTENDANCE("Scenario.AAA6.MediationUnsuccessful.Claimant1NonAttendance.CARM.Claimant"),
    SCENARIO_AAA6_DEFENDANT_MEDIATION_UNSUCCESSFUL_DEFENDANT_NONATTENDANCE("Scenario.AAA6.MediationUnsuccessful.Defendant1NonAttendance.CARM.Defendant"),
    SCENARIO_AAA6_CLAIMANT_INTENT_REQUESTED_CCJ_CLAIMANT_ACCEPTED_DEFENDANT_PLAN_DEFENDANT(
        "Scenario.AAA6.ClaimantIntent.RequestedCCJ.ClaimantAcceptedDefendantPlan.Defendant"),
    SCENARIO_AAA6_CLAIMANT_INTENT_MEDIATION_CLAIMANT_CARM("Scenario.AAA6.ClaimantIntent.Mediation.CARM.Claimant"),
    SCENARIO_AAA6_CLAIMANT_INTENT_MEDIATION_DEFENDANT_CARM("Scenario.AAA6.ClaimantIntent.Mediation.CARM.Defendant"),
    SCENARIO_AAA6_DEFENDANT_ADMIT_PAY_INSTALMENT_COMPANY_ORGANISATION_DEFENDANT("Scenario.AAA6.DefResponse.OrgOrLtdCompany.FullOrPartAdmit.PayByInstallments.Defendant"),
    SCENARIO_AAA6_DEFENDANT_FULL_DEFENCE_NO_MEDIATION_DEFENDANT("Scenario.AAA6.DefResponse.FullDefence.FullDispute.RefusedMediation.Defendant"),
    SCENARIO_AAA6_DEFENDANT_PART_ADMIT_PAY_IMMEDIATELY_CLAIMANT("Scenario.AAA6.DefResponse.PartAdmit.PayImmediately.Claimant"),
    SCENARIO_AAA6_DEFENDANT_RESPONSE_DEADLINE_PASSED_CLAIMANT("Scenario.AAA6.DefResponse.ResponseTimeElapsed.Claimant"),
    SCENARIO_AAA6_DEFENDANT_RESPONSE_DEADLINE_PASSED_DEFENDANT("Scenario.AAA6.DefResponse.ResponseTimeElapsed.Defendant"),
    SCENARIO_AAA6_DEFENDANT_FULL_DEFENCE_FULL_DISPUTE_MEDIATION("Scenario.AAA6.DefResponse.FullDefence.FullDispute.SuggestedMediation.Defendant"),
    SCENARIO_AAA6_DEF_RESPONSE_FULL_DEFENCE_FULL_DISPUTE_REFUSED_MEDIATION_CLAIMANT("Scenario.AAA6.DefResponse.FullDefence.FullDispute.RefusedMediation.Claimant"),
    SCENARIO_AAA6_CCJ_CLAIMANT_ACCEPT_OR_REJECT_PLAN_SETTLEMENT_REQUESTED_DEF_PAYMENT_MISSED_DEFENDANT(
        "Scenario.AAA6.ClaimantIntent.RequestCCJ.ClaimantAcceptOrRejectPlan.SettlementRequested.DefPaymentMissed.Defendant"),
    SCENARIO_AAA6_CLAIMANT_INTENT_MEDIATION_SUCCESSFUL_DEFENDANT(
        "Scenario.AAA6.ClaimantIntent.MediationSuccessful.Defendant"),
    SCENARIO_AAA6_CLAIMANT_INTENT_REQUEST_CCJ_CLAIMANT_REJECTS_DEF_PLAN_CLAIMANT_DISAGREES_COURT_PLAN_DEFENDANT(
        "Scenario.AAA6.ClaimantIntent.RequestCCJ.ClaimantRejectsDefPlan.ClaimantDisagreesCourtPlan.Defendant"),
    SCENARIO_AAA6_DEFENDANT_RESPONSE_FULL_DEFENCE_FULL_DISPUTE_MEDIATION_CLAIMANT("Scenario.AAA6.DefResponse.FullDefence.FullDispute.SuggestedMediation.Claimant"),
    SCENARIO_AAA6_CLAIMANT_INTENT_REJECT_REPAYMENT_ORG_LTD_CO_CLAIMANT("Scenario.AAA6.ClaimantIntent.Defendant.OrgLtdCo.Claimant"),
    SCENARIO_AAA6_CP_HEARING_SCHEDULED_CLAIMANT("Scenario.AAA6.CP.Hearing.Scheduled.Claimant"),
    SCENARIO_AAA6_CP_HEARING_SCHEDULED_DEFENDANT("Scenario.AAA6.CP.Hearing.Scheduled.Defendant"),
    SCENARIO_AAA6_CLAIMANT_INTENT_REJECT_REPAYMENT_ORG_DEFENDANT("Scenario.AAA6.ClaimantIntent.Defendant.OrgLtdCo.Claimant"),
    SCENARIO_AAA6_DEFENDANT_RESPONSE_FULLDISPUTE_FAST_TRACK_CLAIMANT("Scenario.AAA6.DefResponse.FullDefence.FullDispute.FastTrack.Claimant"),
    SCENARIO_AAA6_DEFENDANT_RESPONSE_FULL_DEFENCE_FULL_DISPUTE_FAST_TRACK_DEFENDANT("Scenario.AAA6.DefResponse.FullDefence.FullDispute.FastTrack.Defendant"),
    SCENARIO_AAA6_CP_HEARING_DOCUMENTS_UPLOAD_CLAIMANT("Scenario.AAA6.CP.HearingDocuments.Upload.Claimant"),
    SCENARIO_AAA6_CP_HEARING_DOCUMENTS_UPLOAD_DEFENDANT("Scenario.AAA6.CP.HearingDocuments.Upload.Defendant"),
    SCENARIO_AAA6_HEARING_FEE_UNPAID_CLAIMANT("Scenario.AAA6.CP.StrikeOut.HearingFeeUnpaid.Claimant"),
    SCENARIO_AAA6_HEARING_FEE_UNPAID_DEFENDANT("Scenario.AAA6.CP.StrikeOut.HearingFeeUnpaid.Defendant"),
    SCENARIO_AAA6_HEARING_FEE_UNPAID_TRIAL_READY_CLAIMANT("Scenario.AAA6.CP.StrikeOut.HearingFeeUnpaid.TrialReady.Claimant"),
    SCENARIO_AAA6_HEARING_FEE_UNPAID_TRIAL_READY_DEFENDANT("Scenario.AAA6.CP.StrikeOut.HearingFeeUnpaid.TrialReady.Defendant"),
    SCENARIO_AAA6_CP_ORDER_MADE_CLAIMANT("Scenario.AAA6.CP.OrderMade.Claimant"),
    SCENARIO_AAA6_CP_ORDER_MADE_DEFENDANT("Scenario.AAA6.CP.OrderMade.Defendant"),
    SCENARIO_AAA6_CP_TRIAL_ARRANGEMENTS_NOTIFY_OTHER_PARTY_CLAIMANT("Scenario.AAA6.CP.Trial.Arrangements.Finalised.NotifyOtherParty.Claimant"),
    SCENARIO_AAA6_CP_TRIAL_ARRANGEMENTS_NOTIFY_OTHER_PARTY_DEFENDANT("Scenario.AAA6.CP.Trial.Arrangements.Finalised.NotifyOtherParty.Defendant"),
    SCENARIO_AAA6_CCJ_CLAIMANT_ACCEPT_OR_REJECT_PLAN_SETTLEMENT_REQUESTED_NO_DEF_RESPONSE_DEFENDANT(
        "Scenario.AAA6.ClaimantIntent.RequestCCJ.ClaimantAcceptOrRejectPlan.SettlementRequested.NoDefResponse.Defendant"),
    SCENARIO_AAA6_CLAIMANT_INTENT_REQUESTED_CCJ_CLAIMANT("Scenario.AAA6.ClaimantIntent.RequestedCCJ.Claimant"),
    SCENARIO_AAA6_CLAIMANT_INTENT_REQUEST_JUDGE_PLAN_REQUESTED_CCJ_CLAIMANT(
        "Scenario.AAA6.ClaimantIntent.RequestJudgePlan.RequestedCCJ.Claimant"),
    SCENARIO_AAA6_CLAIMANT_INTENT_REJECT_REPAYMENT_ORG_LTD_CO_DEFENDANT("Scenario.AAA6.ClaimantIntent.ClaimantRejectsPlan.DefendantOrgLtdCo.Defendant"),
    SCENARIO_AAA6_CLAIMANT_INTENT_MEDIATION_SUCCESSFUL_CLAIMANT("Scenario.AAA6.ClaimantIntent.MediationSuccessful.Claimant"),
    SCENARIO_AAA6_CLAIMANT_INTENT_MEDIATION_UNSUCCESSFUL_CLAIMANT("Scenario.AAA6.ClaimantIntent.MediationUnsuccessful.Claimant"),
    SCENARIO_AAA6_CLAIMANT_INTENT_MEDIATION_UNSUCCESSFUL_DEFENDANT("Scenario.AAA6.ClaimantIntent.MediationUnsuccessful.Defendant"),
    SCENARIO_AAA6_CP_TRIAL_ARRANGEMENTS_REQUIRED_CLAIMANT("Scenario.AAA6.CP.Trial.Arrangements.Required.Claimant"),
    SCENARIO_AAA6_CP_TRIAL_ARRANGEMENTS_REQUIRED_DEFENDANT("Scenario.AAA6.CP.Trial.Arrangements.Required.Defendant"),
    SCENARIO_AAA6_CP_HEARING_FEE_REQUIRED_CLAIMANT("Scenario.AAA6.CP.HearingFee.Required.Claimant"),
    SCENARIO_AAA6_BUNDLE_CREATED_CLAIMANT("Scenario.AAA6.CP.Bundle.Ready.Claimant"),
    SCENARIO_AAA6_BUNDLE_CREATED_DEFENDANT("Scenario.AAA6.CP.Bundle.Ready.Defendant"),
    SCENARIO_AAA6_MEDIATION_UNSUCCESSFUL_TRACK_CHANGE_CLAIMANT_CARM("Scenario.AAA6.MediationUnsuccessful.TrackChange.CARM.Claimant"),
    SCENARIO_AAA6_MEDIATION_UNSUCCESSFUL_TRACK_CHANGE_DEFENDANT_CARM("Scenario.AAA6.MediationUnsuccessful.TrackChange.CARM.Defendant"),
    SCENARIO_AAA6_HEARING_FEE_PAID_CLAIMANT("Scenario.AAA6.CP.HearingFee.Paid.Claimant"),
    SCENARIO_AAA6_HEARING_FEE_HWF_INVALID_REF("Scenario.AAA6.CP.HearingFee.HWF.InvalidRef"),
    SCENARIO_AAA6_HEARING_FEE_HWF_INFO_REQUIRED("Scenario.AAA6.CP.HearingFee.HWF.InfoRequired"),
    SCENARIO_AAA6_HEARING_FEE_HWF_UPDATED("Scenario.AAA6.CP.HearingFee.HWF.Updated"),
    SCENARIO_AAA6_HEARING_FEE_HWF_PART_REMISSION("Scenario.AAA6.CP.HearingFee.HWF.PartRemission"),
    SCENARIO_AAA6_HEARING_FEE_HWF_NO_REMISSION("Scenario.AAA6.CP.HearingFee.HWF.Rejected"),
    SCENARIO_AAA6_HEARING_FEE_HWF_FULL_REMISSION("Scenario.AAA6.CP.HearingFee.HWF.FullRemission"),
    SCENARIO_AAA6_BUNDLE_CREATED_TRIAL_READY_CLAIMANT("Scenario.AAA6.CP.Bundle.Ready.TrialReady.Claimant"),
    SCENARIO_AAA6_BUNDLE_CREATED_TRIAL_READY_DEFENDANT("Scenario.AAA6.CP.Bundle.Ready.TrialReady.Defendant"),
    SCENARIO_AAA6_CP_HEARING_FEE_HELP_WITH_FEE_APPLIED_CLAIMANT("Scenario.AAA6.CP.HearingFee.HWF.AppliedFor.Claimant"),
    SCENARIO_AAA6_CP_CLAIM_ISSUE_FAST_TRACK_CLAIMANT("Scenario.AAA6.ClaimIssue.Claimant.FastTrack"),
    SCENARIO_AAA6_CP_CLAIM_ISSUE_FAST_TRACK_DEFENDANT("Scenario.AAA6.ClaimIssue.Defendant.FastTrack"),
    SCENARIO_AAA6_CLAIMANT_MEDIATION_WHEN_DEFENDANT_NOT_CONTACTABLE("Scenario.AAA6.MediationUnsuccessful.WhenDefendantNotContactable.CARM.Claimant"),
    SCENARIO_AAA6_DEFENDANT_MEDIATION_WHEN_CLAIMANT_NOT_CONTACTABLE("Scenario.AAA6.MediationUnsuccessful.WhenClaimantNotContactable.CARM.Defendant"),
    SCENARIO_AAA6_CLAIMANT_SDO_DRAWN_PRE_CASE_PROGRESSION("Scenario.AAA6.ClaimantIntent.SDODrawn.PreCaseProgression.Claimant"),
    SCENARIO_AAA6_DEFENDANT_SDO_DRAWN_PRE_CASE_PROGRESSION("Scenario.AAA6.ClaimantIntent.SDODrawn.PreCaseProgression.Defendant"),
    SCENARIO_AAA6_DEFENDANT_RESPONSE_BILINGUAL_CLAIMANT("Scenario.AAA6.DefResponse.BilingualFlagSet.Claimant"),
    SCENARIO_AAA6_CASE_PROCEED_IN_CASE_MAN_CLAIMANT("Scenario.AAA6.CaseProceedsInCaseman.Claimant"),
    SCENARIO_AAA6_CASE_PROCEED_IN_CASE_MAN_DEFENDANT("Scenario.AAA6.CaseProceedsInCaseman.Defendant"),
    SCENARIO_AAA6_CP_HEARING_DOCUMENTS_UPLOADED_CLAIMANT("Scenario.AAA6.CP.HearingDocuments.Uploaded.Claimant"),
    SCENARIO_AAA6_CP_HEARING_DOCUMENTS_NOT_UPLOADED_CLAIMANT("Scenario.AAA6.CP.HearingDocuments.NotUploaded.Claimant"),
    SCENARIO_AAA6_CP_HEARING_DOCUMENTS_UPLOADED_DEFENDANT("Scenario.AAA6.CP.HearingDocuments.Uploaded.Defendant"),
    SCENARIO_AAA6_CP_HEARING_DOCUMENTS_NOT_UPLOADED_DEFENDANT("Scenario.AAA6.CP.HearingDocuments.NotUploaded.Defendant"),
    SCENARIO_AAA6_JUDGEMENTS_ONLINE_DEFAULT_JUDGEMENT_ISSUED_DEFENDANT("Scenario.AAA6.JudgmentsOnline.DefaultJudgmentIssued.Defendant"),
    SCENARIO_AAA6_JUDGEMENTS_ONLINE_SET_ASIDE_ERROR_CLAIMANT("Scenario.AAA6.JudgmentsOnline.SetAsideError.Claimant"),
    SCENARIO_AAA6_UPLOAD_MEDIATION_DOCUMENT_DEFENDANT_CARM("Scenario.AAA6.MediationUploadDocuments.CARM.Defendant"),
    SCENARIO_AAA6_UPLOAD_MEDIATION_DOCUMENT_CLAIMANT_CARM("Scenario.AAA6.MediationUploadDocuments.CARM.Claimant"),
    SCENARIO_AAA6_UPLOAD_MEDIATION_DOCUMENT_DEFENDANT_CHANGE_VIEW_MEDIATION_AVAILABLE_CARM("Scenario.AAA6.MediationUploadDocuments.ViewMediationAvailable.CARM.Defendant"),
    SCENARIO_AAA6_UPLOAD_MEDIATION_DOCUMENT_CLAIMANT_CHANGE_VIEW_MEDIATION_AVAILABLE_CARM("Scenario.AAA6.MediationUploadDocuments.ViewMediationAvailable.CARM.Claimant"),
    SCENARIO_AAA6_JUDGEMENTS_ONLINE_DEFAULT_JUDGEMENT_ISSUED_CLAIMANT("Scenario.AAA6.JudgmentsOnline.DefaultJudgmentIssued.Claimant"),
    SCENARIO_AAA6_JUDGEMENTS_ONLINE_SET_ASIDE_ERROR_DEFENDANT("Scenario.AAA6.JudgmentsOnline.SetAsideError.Defendant");

    private final String scenario;

    DashboardScenarios(String scenario) {
        this.scenario = scenario;
    }

    public String getScenario() {
        return scenario;
    }
}
