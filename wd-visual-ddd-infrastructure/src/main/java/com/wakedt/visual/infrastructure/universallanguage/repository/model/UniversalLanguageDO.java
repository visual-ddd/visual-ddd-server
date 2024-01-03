package com.wakedt.visual.infrastructure.universallanguage.repository.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.wakedt.visual.infrastructure.BaseJpaAggregate;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 统一语言实体类
 *
 * @author zhuxueliang
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "wd_universal_language")
@TableName("wd_universal_language")
public class UniversalLanguageDO extends BaseJpaAggregate {

    /** 概念 */
    private String conception;

    /** 英文名 */
    private String englishName;

    /** 定义 */
    private String definition;

    /** 统一语言类型 */
    private Integer languageType;

    /** 约束 */
    private String restraint;

    /** 所属唯一标识(组织/团队的主键id) */
    private Long identity;

    /** 举例 */
    private String example;
}