package uk.gov.hmcts.reform.civil.model.sdo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class SdoR2PermissionToRelyOnExpert {

    private String sdoPermissionToRelyOnExpertTxt;
    private LocalDate sdoPermissionToRelyOnExpertDate;
    private String sdoJointMeetingOfExpertsTxt;
    private LocalDate sdoJointMeetingOfExpertsDate;
    private String sdoUploadedToDigitalPortalTxt;

}
