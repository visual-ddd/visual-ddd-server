package com.wakedt.visual.client.aiusagestatistics.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 新增AI 使用统计
 */
@Data
@ApiModel(description = "新增AI 使用统计")
public class AiUsageStatisticsCreateDTO {

    @NotNull(message = "用户Id不能为空！")
    @ApiModelProperty(value = "用户Id")
    private String userId;

    @NotNull(message = "account不能为空！")
    @ApiModelProperty(value = "account")
    private String account;

    @NotNull(message = "模型不能为空！")
    @ApiModelProperty(value = "模型")
    private String model;

    @NotNull(message = "上报来源不能为空！")
    @ApiModelProperty(value = "上报来源")
    private String reportSource;

    @NotNull(message = "请求时间不能为空！")
    @ApiModelProperty(value = "请求时间")
    private String requestTime;

    @NotNull(message = "业务模块不能为空！")
    @ApiModelProperty(value = "业务模块")
    private String businessCode;

    @NotNull(message = "业务描述不能为空！")
    @ApiModelProperty(value = "业务描述")
    private String businessDesc;

    @NotNull(message = "请求tokens不能为空！")
    @ApiModelProperty(value = "请求tokens")
    private Integer requestTokens;

    @NotNull(message = "响应tokens 不能为空！")
    @ApiModelProperty(value = "响应tokens ")
    private Integer responseTokens;

    @NotNull(message = "当前请求的token消耗数量不能为空！")
    @ApiModelProperty(value = "当前请求的token消耗数量")
    private Integer totalTokens;

}