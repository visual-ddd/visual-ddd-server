package com.wakedt.visual.client.universallanguage.dto;

import com.wakedata.common.core.base.BaseDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 统一语言信息
 *
 * @author zhuxueliang
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "统一语言信息")
public class UniversalLanguageDTO extends BaseDTO {

    @ApiModelProperty(value = "主键id")
    private Long id;

    @ApiModelProperty(value = "概念")
    private String conception;

    @ApiModelProperty(value = "英文名")
    private String englishName;

    @ApiModelProperty(value = "定义")
    private String definition;

    @ApiModelProperty(value = "约束")
    private String restraint;

    @ApiModelProperty(value = "统一语言类型：1-组织统一语言，2-团队统一语言，3-业务域统一语言")
    private Integer languageType;

    @ApiModelProperty(value = "所属唯一标识(组织/团队的主键id)")
    private Long identity;

    @ApiModelProperty("举例")
    private String example;
}