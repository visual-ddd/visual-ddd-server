package com.wakedt.visual.domain.businessscene.businesssceneversion;

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
    UN_PUBLISHED(1, "unpublished"),

    /**
     * 已发布
     */
    PUBLISHED(2, "published"),
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

