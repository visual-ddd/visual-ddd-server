package com.wakedt.visual.domain.universallanguage.universallanguage;

import com.wakedt.visual.domain.DomainEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 统一语言-聚合根
 *
 * @author zhuxueliang
 */
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class AbstractUniversalLanguage extends DomainEntity {

    /** 概念 */
    private String conception;

    /** 英文名 */
    private String englishName;

    /** 定义 */
    private String definition;

    /** 统一语言类型 */
    private LanguageType languageType;

    /** 约束 */
    private String restraint;

    /** 所属唯一标识(组织/团队的主键id) */
    private Long identity;

    private String example;

}