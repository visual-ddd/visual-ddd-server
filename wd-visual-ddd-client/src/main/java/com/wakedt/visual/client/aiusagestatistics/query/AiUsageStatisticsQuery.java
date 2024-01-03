package com.wakedt.visual.client.aiusagestatistics.query;

import com.wakedata.common.core.base.BaseQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

/**
 * AI 使用统计详情查询对象
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(description = "AI 使用统计详情查询对象")
public class AiUsageStatisticsQuery extends BaseQuery {

    @NotNull(message = "AI 使用统计 ID不能为空！")
    @ApiModelProperty(value = "AI 使用统计 ID")
    private Long id;

}