package com.wakedt.visual.client.universallanguage.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 更新统一语言
 *
 * @author zhuxueliang
 */
@Data
@ApiModel(value = "更新统一语言")
public class UniversalLanguageUpdateDTO {

    @ApiModelProperty(value = "主键id")
    @NotNull(message = "主键不能为空")
    private Long id;

    @ApiModelProperty(value = "概念")
    private String conception;

    @ApiModelProperty(value = "英文名")
    private String englishName;

    @ApiModelProperty(value = "定义")
    private String definition;

    @ApiModelProperty(value = "约束")
    private String restraint;

    @ApiModelProperty("举例")
    private String example;
}