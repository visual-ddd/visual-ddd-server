package com.wakedt.visual.client.user.dto;

import com.wakedt.visual.client.organization.dto.OrganizationDTO;
import lombok.Data;

/**
 * @author WangChenSheng
 * date 2022/12/30 11:11
 */
@Data
public class AccountOrganizationInfo {

    private OrganizationDTO organizationDTO;

    private Boolean isOrganizationAdmin;

}
