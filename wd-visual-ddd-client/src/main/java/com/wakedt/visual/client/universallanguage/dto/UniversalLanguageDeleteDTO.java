package com.wakedt.visual.client.universallanguage.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 删除统一语言
 *
 * @author zhuxueliang
 */
@Data
@ApiModel(value = "删除统一语言")
public class UniversalLanguageDeleteDTO {

    @ApiModelProperty(value = "主键id")
    @NotNull(message = "主键List不能为空")
    private List<Long> idList;
}