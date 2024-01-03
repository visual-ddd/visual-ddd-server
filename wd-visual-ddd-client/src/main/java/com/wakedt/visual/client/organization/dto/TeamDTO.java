package com.wakedt.visual.client.organization.dto;

import com.wakedata.common.core.base.BaseDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 团队信息
 *
 * @author zhuxueliang
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "团队信息")
public class TeamDTO extends BaseDTO {

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "所属组织ID")
    private Long organizationId;

    @ApiModelProperty(value = "所属组织信息")
    private OrganizationDTO organizationDTO;

    @ApiModelProperty(value = "团队名称")
    private String name;

    @ApiModelProperty(value = "描述信息")
    private String description;

    @ApiModelProperty(value = "团队管理员ID(账号id)")
    private Long teamManagerId;

    @ApiModelProperty(value = "团队管理员名称")
    private String teamManagerName;

}