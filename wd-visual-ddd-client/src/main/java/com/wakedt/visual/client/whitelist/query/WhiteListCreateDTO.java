package com.wakedt.visual.client.whitelist.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 新增白名单
 */
@Data
@ApiModel(value = "新增白名单")
public class WhiteListCreateDTO {

    @ApiModelProperty(value = "账号")
    public String accountNo;

    @ApiModelProperty(value = "描述")
    public String description;

}