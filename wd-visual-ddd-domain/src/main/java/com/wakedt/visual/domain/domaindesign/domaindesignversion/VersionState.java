package com.wakedt.visual.domain.domaindesign.domaindesignversion;

import com.wakedata.common.core.base.BaseEnum;
import lombok.AllArgsConstructor;

/**
 * 版本状态-枚举
 *
 * @author zhuxueliang
 */
@AllArgsConstructor
public enum VersionState implements BaseEnum {

    /**
     * 未发布
     */
    UN_PUBLISHED(1, "未发布"),

    /**
     * 已发布
     */
    PUBLISHED(2, "已发布"),
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

