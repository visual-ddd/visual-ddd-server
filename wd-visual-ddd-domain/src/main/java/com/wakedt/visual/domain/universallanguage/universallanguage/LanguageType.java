package com.wakedt.visual.domain.universallanguage.universallanguage;

import com.wakedata.common.core.base.BaseEnum;
import lombok.AllArgsConstructor;

/**
 * 统一语言类型-枚举
 *
 * @author zhuxueliang
 */
@AllArgsConstructor
public enum LanguageType implements BaseEnum {

    /**
     * 组织统一语言
     */
    ORGANIZATION_LANGUAGE(1, "组织统一语言"),

    /**
     * 团队统一语言
     */
    TEAM_LANGUAGE(2, "团队统一语言"),

    /**
     * 业务域统一语言
     */
    DOMAIN_LANGUAGE(3, "业务域统一语言"),
    ;

    private final Integer value;
    private final String desc;

    @Override
    public Integer getValue() {
        return this.value;
    }

    @Override
    public String getDesc() {
        return this.desc;
    }
}

