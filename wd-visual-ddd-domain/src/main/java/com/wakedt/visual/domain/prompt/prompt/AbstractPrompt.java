package com.wakedt.visual.domain.prompt.prompt;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * ChatGpt提示词的领域-聚合根
 */
@Data
public abstract class AbstractPrompt {

    /** 提示词 ID */
    private Long id;

    /** 名称 */
    private String name;

    /** 描述 */
    private String description;

    /** 介绍，markdown 格式 */
    private String introduction;

    /** 系统 prompt */
    private String system;

    /** 贡献者 */
    private String author;

    /** 分类 */
    private List<String> category;

    /** 提交日期 */
    private Date date;

    /** 模型文档，默认是 0.7 */
    private Float temperature;

    /** 最大上下文消息数 */
    private Long maxContextLength;

}