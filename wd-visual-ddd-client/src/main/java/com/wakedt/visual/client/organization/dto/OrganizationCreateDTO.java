package com.wakedt.visual.client.organization.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 创建组织
 *
 * @author zhuxueliang
 */
@Data
@ApiModel(value = "创建组织")
public class OrganizationCreateDTO {

    @ApiModelProperty(value = "组织名称")
    private String name;

    @ApiModelProperty(value = "描述信息")
    private String description;

    @ApiModelProperty(value = "组织管理员ID")
    private Long organizationManagerId;

}