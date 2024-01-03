package com.wakedt.visual.client.aiusagestatistics.query;

import com.wakedata.common.core.dto.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

/**
 * AI 使用统计分页查询对象
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(description = "AI 使用统计分页查询对象")
public class AiUsageStatisticsPageQuery extends PageQuery {

    @NotNull(message = "账号不能为空！")
    @ApiModelProperty(value = "账号")
    private String account;

    @NotNull(message = "开始时间不能为空！")
    @ApiModelProperty(value = "开始时间")
    private String startTime;

    @NotNull(message = "结束时间不能为空！")
    @ApiModelProperty(value = "结束时间")
    private String endTime;

}