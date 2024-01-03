package com.wakedt.visual.infrastructure.prompt.repository.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.wakedt.visual.infrastructure.BaseJpaAggregate;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;

/**
 * ChatGpt提示词的领域实体类
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("wd_prompt")
@Entity
@Table(name = "wd_prompt")
public class PromptDO extends BaseJpaAggregate {

    /** 提示词 ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @TableId(type = IdType.AUTO)
    private Long id;

    /** 名称 */
    private String name;

    /** 描述 */
    private String description;

    /** 介绍，markdown 格式 */
    private String introduction;

    /** 系统 prompt */
    private String systemPrompt;

    /** 贡献者 */
    private String author;

    /** 提交日期 */
    private Date date;

    /** 模型文档，默认是 0.7 */
    private Float temperature;

    /** 最大上下文消息数 */
    private Long maxContextLength;

    /** 分类 */
    private String category;
}