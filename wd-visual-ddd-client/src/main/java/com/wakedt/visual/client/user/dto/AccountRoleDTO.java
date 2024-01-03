package com.wakedt.visual.client.user.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author WangChenSheng
 * date 2022/12/30 11:11
 */
@Data
public class AccountRoleDTO {

    @ApiModelProperty("当前账号id")
    private Long id;

    @ApiModelProperty("是否系统管理员")
    private Boolean isSysAdmin;

    @ApiModelProperty("所属团队信息列表")
    private List<AccountTeamInfo> accountTeamInfoList;

    @ApiModelProperty("所属组织信息列表")
    private List<AccountOrganizationInfo> accountOrganizationInfoList;

}
