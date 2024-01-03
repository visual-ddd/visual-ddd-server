package com.wakedt.visual.client.domaindesign.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 更新业务域DSL
 *
 * @author zhuxueliang
 */
@Data
@ApiModel(value = "更新业务域DSL")
public class DomainDesignDSLUpdateDTO {

    @ApiModelProperty(value = "主键")
    @NotNull(message = "主键不能为空")
    private Long id;

    @ApiModelProperty(value = "业务域DSL")
    @NotNull(message = "业务域DSL不能为空")
    private String domainDesignDsl;

    @ApiModelProperty(value = "图形DSL")
    @NotNull(message = "图形DSL不能为空")
    private String graphDsl;
}