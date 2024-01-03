package com.wakedt.visual.client.application.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 新增应用版本
 *
 * @author zhuxueliang
 */
@Data
@ApiModel(value = "新增应用版本")
public class ApplicationVersionCreateDTO {

    @ApiModelProperty(value = "所属应用ID")
    private Long applicationId;

    @ApiModelProperty(value = "起始版本号ID")
    private Long startVersionId;

    @ApiModelProperty(value = "当前版本号")
    private String currentVersion;

    @ApiModelProperty(value = "描述信息")
    private String description;
}