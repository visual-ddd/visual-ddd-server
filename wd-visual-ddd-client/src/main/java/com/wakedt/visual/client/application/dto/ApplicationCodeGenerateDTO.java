package com.wakedt.visual.client.application.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 生成应用代码
 *
 * @author zhuxueliang
 */
@Data
@ApiModel(value = "生成应用代码")
public class ApplicationCodeGenerateDTO {

    @ApiModelProperty(value = "主键")
    private Long id;
}