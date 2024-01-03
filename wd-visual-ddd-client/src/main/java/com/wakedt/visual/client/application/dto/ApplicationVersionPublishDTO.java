package com.wakedt.visual.client.application.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 发布应用版本
 *
 * @author zhuxueliang
 */
@Data
@ApiModel(value = "发布应用版本")
public class ApplicationVersionPublishDTO {

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "描述信息")
    private String description;
}