package com.wakedt.visual.domain.organization.teammember;

import com.wakedata.common.core.base.BaseEnum;
import lombok.AllArgsConstructor;

/**
 * 成员类型
 *
 * @author zhuxueliang
 */
@AllArgsConstructor
public enum MemberType implements BaseEnum {

    /**
     * 1-产品经理
     */
    PM(1, "productManager"),
    /**
     * 2-架构师
     */
    ARCHITECT(2, "architect"),
    /**
     * 3-开发者
     */
    DEVELOPER(3, "developer");

    private final Integer value;
    private final String desc;

    @Override
    public Integer getValue() {
        return value;
    }

    @Override
    public String getDesc() {
        return this.desc;
    }
}