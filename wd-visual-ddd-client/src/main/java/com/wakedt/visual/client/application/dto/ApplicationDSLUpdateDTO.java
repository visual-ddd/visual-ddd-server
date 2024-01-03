package com.wakedt.visual.client.application.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 更新应用DSL
 *
 * @author zhuxueliang
 */
@Data
@ApiModel(value = "更新应用DSL")
public class ApplicationDSLUpdateDTO {

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "应用DSL")
    private String dsl;
}