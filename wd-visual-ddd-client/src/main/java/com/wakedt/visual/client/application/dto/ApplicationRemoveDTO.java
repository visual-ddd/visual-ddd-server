package com.wakedt.visual.client.application.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 删除应用
 *
 * @author zhuxueliang
 */
@Data
@ApiModel(value = "删除应用")
public class ApplicationRemoveDTO {

    @ApiModelProperty(value = "主键")
    private Long id;
}