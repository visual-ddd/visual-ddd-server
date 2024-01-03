package com.wakedt.visual.infrastructure.aiusagestatistics.repository.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.wakedt.visual.infrastructure.BaseJpaAggregate;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

/**
 * AI 使用统计实体类
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("wd_ai_usage_statistics")
@Entity
@Table(name = "wd_ai_usage_statistics")
public class AiUsageStatisticsDO extends BaseJpaAggregate {

    /** AI 使用统计 ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @TableId(type = IdType.AUTO)
    private Long id;

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