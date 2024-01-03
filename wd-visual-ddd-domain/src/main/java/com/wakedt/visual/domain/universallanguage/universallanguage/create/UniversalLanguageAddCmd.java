package com.wakedt.visual.domain.universallanguage.universallanguage.create;

import com.wakedt.visual.domain.universallanguage.universallanguage.LanguageType;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 新增统一语言-指令
 *
 * @author zhuxueliang
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "新增统一语言指令")
public class UniversalLanguageAddCmd {

    /** 概念 */
    private String conception;

    /** 英文名 */
    private String englishName;

    /** 定义 */
    private String definition;

    /** 约束 */
    private String restraint;

    /** 统一语言类型 */
    private LanguageType languageType;

    /** 所属唯一标识(组织/团队的主键id) */
    private Long identity;

    private String example;

}