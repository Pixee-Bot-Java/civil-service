package uk.gov.hmcts.reform.civil.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
public class Respondent2CourtOrderDetails {

    private final String claimNumberText;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private final BigDecimal amountOwed;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private final BigDecimal monthlyInstalmentAmount;


}
