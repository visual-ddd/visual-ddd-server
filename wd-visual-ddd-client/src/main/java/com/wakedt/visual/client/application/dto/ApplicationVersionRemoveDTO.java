package com.wakedt.visual.client.application.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 删除应用版本
 *
 * @author zhuxueliang
 */
@Data
@ApiModel(value = "删除应用版本")
public class ApplicationVersionRemoveDTO {

    @ApiModelProperty(value = "主键")
    private Long id;
}