package uk.gov.hmcts.reform.civil.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PaymentFrequencyLRspec {
    ONCE_ONE_WEEK("Paid every week", "every week"),
    ONCE_TWO_WEEKS("Paid every 2 weeks", "every 2 weeks"),
    ONCE_THREE_WEEKS("Paid every 3 weeks", "every 3 weeks"),
    ONCE_FOUR_WEEKS("Paid every 4 weeks", "every 4 weeks"),
    ONCE_ONE_MONTH("Paid every month", "every month");

    private final String label;
    private final String dashboardLabel;
}
