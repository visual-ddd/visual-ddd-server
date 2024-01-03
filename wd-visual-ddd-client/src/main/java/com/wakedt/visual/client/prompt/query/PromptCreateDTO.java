package com.wakedt.visual.client.prompt.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 新增提示词
 */
@Data
@ApiModel(value = "新增提示词")
public class PromptCreateDTO {

    @ApiModelProperty(value = "名称")
    public String name;

    @ApiModelProperty(value = "描述")
    public String description;

    @ApiModelProperty(value = "介绍，markdown 格式")
    public String introduction;

    @ApiModelProperty(value = "系统 prompt")
    public String system;

    @ApiModelProperty(value = "贡献者")
    public String author;

    @ApiModelProperty(value = "分类")
    public List<String> category;

    @ApiModelProperty(value = "提交日期")
    public Date date;

    @ApiModelProperty(value = "模型文档，默认是 0.7")
    public Float temperature;

    @ApiModelProperty(value = "最大上下文消息数")
    public Long maxContextLength;

}