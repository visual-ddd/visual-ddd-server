package com.wakedt.visual.client.organization.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 更新团队信息
 *
 * @author zhuxueliang
 */
@Data
@ApiModel(value = "更新团队信息")
public class TeamUpdateDTO {

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "团队名称")
    private String name;

    @ApiModelProperty(value = "描述信息")
    private String description;

    @ApiModelProperty(value = "团队管理员ID")
    private Long teamManagerId;
}