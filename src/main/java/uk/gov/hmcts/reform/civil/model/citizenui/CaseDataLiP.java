package uk.gov.hmcts.reform.civil.model.citizenui;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CaseDataLiP {

    @JsonProperty("respondent1LiPResponse")
    private RespondentLiPResponse respondent1LiPResponse;
    private TranslatedDocument translatedDocument;
    @JsonProperty("applicant1ClaimMediationSpecRequiredLip")
    private ClaimantMediationLip applicant1ClaimMediationSpecRequiredLip;

    @JsonIgnore
    public boolean hasClaimantAgreedToFreeMediation() {
        return applicant1ClaimMediationSpecRequiredLip != null
            && applicant1ClaimMediationSpecRequiredLip.hasClaimantAgreedToFreeMediation();
    }

    @JsonIgnore
    public boolean hasClaimantNotAgreedToFreeMediation() {
        return applicant1ClaimMediationSpecRequiredLip != null
            && applicant1ClaimMediationSpecRequiredLip.hasClaimantNotAgreedToFreeMediation();
    }

    @JsonIgnore
    public String getEvidenceComment() {
        return Optional.ofNullable(respondent1LiPResponse)
            .map(RespondentLiPResponse::getEvidenceComment)
            .orElse("");
    }

    @JsonIgnore
    public String getTimeLineComment() {
        return Optional.ofNullable(respondent1LiPResponse)
            .map(RespondentLiPResponse::getTimelineComment)
            .orElse("");
    }
}
