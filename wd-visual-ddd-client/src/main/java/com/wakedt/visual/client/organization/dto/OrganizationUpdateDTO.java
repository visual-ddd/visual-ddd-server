package com.wakedt.visual.client.organization.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 更新组织信息
 *
 * @author zhuxueliang
 */
@Data
@ApiModel(value = "更新组织信息")
public class OrganizationUpdateDTO {

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "组织名称")
    private String name;

    @ApiModelProperty(value = "描述信息")
    private String description;

    @ApiModelProperty(value = "组织管理员ID")
    private Long organizationManagerId;

}