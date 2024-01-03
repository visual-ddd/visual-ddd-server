package com.wakedt.visual.client.prompt.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 删除提示词
 */
@Data
@ApiModel(value = "删除提示词")
public class PromptRemoveDTO {

    @ApiModelProperty(value = "提示词 ID")
    public Long id;

}