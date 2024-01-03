package com.wakedt.visual.client.domaindesign.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 新增业务域版本
 *
 * @author zhuxueliang
 */
@Data
@ApiModel(value = "新增业务域版本")
public class DomainDesignVersionCreateDTO {

    @ApiModelProperty(value = "所属业务域ID")
    @NotNull(message = "所属业务域ID不能为空")
    private Long domainDesignId;

    @ApiModelProperty(value = "起始版本号ID")
    @NotNull(message = "起始版本号ID不能为空")
    private Long startVersionId;

    @ApiModelProperty(value = "当前版本号")
    @NotBlank(message = "当前版本号不能为空")
    private String currentVersion;

    @ApiModelProperty(value = "描述信息")
    private String description;
}