package com.wakedt.visual.client.organization.dto;

import com.wakedata.common.core.base.BaseDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 组织信息
 *
 * @author zhuxueliang
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "组织信息")
public class OrganizationDTO extends BaseDTO {

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "组织管理员ID(账号ID)")
    private Long organizationManagerId;

    @ApiModelProperty(value = "组织管理员名称(账号名称)")
    private String organizationManagerName;

    @ApiModelProperty(value = "组织名称")
    private String name;

    @ApiModelProperty(value = "描述信息")
    private String description;

}