package com.wakedt.visual.client.organization.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 删除团队
 *
 * @author zhuxueliang
 */
@Data
@ApiModel(value = "删除团队")
public class TeamRemoveDTO {

    @ApiModelProperty(value = "主键")
    private Long id;

}