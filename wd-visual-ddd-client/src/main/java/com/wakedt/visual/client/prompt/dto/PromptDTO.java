package com.wakedt.visual.client.prompt.dto;

import com.wakedata.common.core.base.BaseDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
import java.util.List;

/**
 * 用于提示词的数据传输对象
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "用于提示词的数据传输对象")
public class PromptDTO extends BaseDTO {

    @ApiModelProperty(value = "提示词 ID")
    private Long id;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "介绍，markdown 格式")
    private String introduction;

    @ApiModelProperty(value = "系统 prompt")
    private String system;

    @ApiModelProperty(value = "贡献者")
    private String author;

    @ApiModelProperty(value = "分类")
    private List<String> category;

    @ApiModelProperty(value = "提交日期")
    private Date date;

    @ApiModelProperty(value = "模型文档，默认是 0.7")
    private Float temperature;

    @ApiModelProperty(value = "最大上下文消息数")
    private Long maxContextLength;

}