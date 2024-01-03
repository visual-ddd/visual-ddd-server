package com.wakedt.visual.client.whitelist.query;

import com.wakedata.common.core.base.BaseQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 查询白名单详情
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "查询白名单详情")
public class WhiteListQuery extends BaseQuery {

    @ApiModelProperty(value = "白名单 ID")
    private Long id;

}