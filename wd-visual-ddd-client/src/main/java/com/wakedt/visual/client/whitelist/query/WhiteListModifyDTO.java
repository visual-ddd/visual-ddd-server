package com.wakedt.visual.client.whitelist.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 编辑白名单
 */
@Data
@ApiModel(value = "编辑白名单")
public class WhiteListModifyDTO {

    @ApiModelProperty(value = "白名单 ID")
    public Long id;

    @ApiModelProperty(value = "账号")
    public String accountNo;

    @ApiModelProperty(value = "描述")
    public String description;

}