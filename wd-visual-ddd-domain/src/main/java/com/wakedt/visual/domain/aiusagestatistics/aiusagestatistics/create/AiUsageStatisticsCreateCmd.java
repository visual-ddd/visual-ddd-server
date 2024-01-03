package com.wakedt.visual.domain.aiusagestatistics.aiusagestatistics.create;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 新增AI 使用统计-指令
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AiUsageStatisticsCreateCmd {

    /** 用户Id */
    private String userId;

    /** account */
    private String account;

    /** 模型 */
    private String model;

    /** 上报来源 */
    private String reportSource;

    /** 请求时间 */
    private String requestTime;

    /** 业务模块 */
    private String businessCode;

    /** 业务描述 */
    private String businessDesc;

    /** 请求tokens */
    private Integer requestTokens;

    /** 响应tokens  */
    private Integer responseTokens;

    /** 当前请求的token消耗数量 */
    private Integer totalTokens;

}