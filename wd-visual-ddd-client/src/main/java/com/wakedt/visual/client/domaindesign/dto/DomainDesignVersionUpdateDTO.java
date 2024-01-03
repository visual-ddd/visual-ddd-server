package com.wakedt.visual.client.domaindesign.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 更新业务域版本
 *
 * @author zhuxueliang
 */
@Data
@ApiModel(value = "更新业务域版本")
public class DomainDesignVersionUpdateDTO {

    @ApiModelProperty(value = "主键")
    @NotNull(message = "主键不能为空")
    private Long id;

    @ApiModelProperty(value = "描述信息")
    private String description;
}