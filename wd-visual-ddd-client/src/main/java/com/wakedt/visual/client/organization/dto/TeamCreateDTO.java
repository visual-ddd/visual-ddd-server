package com.wakedt.visual.client.organization.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 创建团队
 *
 * @author zhuxueliang
 */
@Data
@ApiModel(value = "创建团队")
public class TeamCreateDTO {

    @ApiModelProperty(value = "团队名称")
    private String name;

    @ApiModelProperty(value = "描述信息")
    private String description;

    @ApiModelProperty(value = "所属组织ID")
    private Long organizationId;

    @ApiModelProperty(value = "团队管理员ID")
    private Long teamManagerId;
}