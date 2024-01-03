package com.wakedt.visual.domain.prompt.prompt.create;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * 新增提示词-指令
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PromptCreateCmd {

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