package com.wakedt.visual.client.domaindesign.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 删除业务域
 *
 * @author zhuxueliang
 */
@Data
@ApiModel(value = "删除业务域")
public class DomainDesignRemoveDTO {

    @ApiModelProperty(value = "主键")
    @NotNull(message = "主键不能为空")
    private Long id;
}