package com.wakedt.visual.client.organization.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 解绑团队管理员
 *
 * @author zhuxueliang
 */
@Data
@ApiModel(value = "解绑团队管理员")
public class TeamManagerUnbindDTO {

    @ApiModelProperty(value = "主键")
    private Long id;

}