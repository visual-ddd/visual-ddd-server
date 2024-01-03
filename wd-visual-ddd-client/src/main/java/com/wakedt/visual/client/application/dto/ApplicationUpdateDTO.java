package com.wakedt.visual.client.application.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 更新应用
 *
 * @author zhuxueliang
 */
@Data
@ApiModel(value = "更新应用")
public class ApplicationUpdateDTO {

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "包名")
    private String packageName;

    @ApiModelProperty(value = "描述信息")
    private String description;
}