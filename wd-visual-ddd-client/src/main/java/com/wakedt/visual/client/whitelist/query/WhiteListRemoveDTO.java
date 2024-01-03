package com.wakedt.visual.client.whitelist.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 删除白名单
 */
@Data
@ApiModel(value = "删除白名单")
public class WhiteListRemoveDTO {

    @ApiModelProperty(value = "白名单 ID")
    public Long id;

}