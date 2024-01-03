package com.wakedt.visual.client.whitelist.dto;

import com.wakedata.common.core.base.BaseDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用于白名单的数据传输对象
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "用于白名单的数据传输对象")
public class WhiteListDTO extends BaseDTO {

    @ApiModelProperty(value = "白名单 ID")
    private Long id;

    @ApiModelProperty(value = "账号")
    private String accountNo;

    @ApiModelProperty(value = "描述")
    private String description;

}