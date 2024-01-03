package com.wakedt.visual.client.universallanguage.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 新增统一语言
 *
 * @author zhuxueliang
 */
@Data
@ApiModel(value = "新增统一语言")
public class UniversalLanguageAddDTO {

    @ApiModelProperty(value = "概念")
    private String conception;

    @ApiModelProperty(value = "英文名")
    private String englishName;

    @ApiModelProperty(value = "定义")
    private String definition;

    @ApiModelProperty(value = "约束")
    private String restraint;

    @ApiModelProperty(value = "统一语言类型")
    private Integer languageType;

    @ApiModelProperty(value = "所属唯一标识(组织/团队的主键id)")
    private Long identity;

    @ApiModelProperty("举例")
    private String example;
}