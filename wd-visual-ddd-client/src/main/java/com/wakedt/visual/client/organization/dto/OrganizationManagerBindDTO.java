package com.wakedt.visual.client.organization.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 绑定组织管理员
 *
 * @author zhuxueliang
 */
@Data
@ApiModel(value = "绑定组织管理员")
public class OrganizationManagerBindDTO {

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "组织管理员ID")
    private Long organizationManagerId;

}