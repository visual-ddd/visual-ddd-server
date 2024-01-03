package com.wakedt.visual.domain.user.account;

import com.wakedata.common.core.base.BaseEnum;

import java.util.Optional;

/**
 * @author WangChenSheng
 * date 2022/12/29 12:08
 */
public enum AccountRoleEnum implements BaseEnum {

    /**
     * 系统管理员
     */
    SYSTEM_ADMINISTRATOR(1, "系统管理员"),
    /**
     * 组织管理员
     */
    ORGANIZATION_ADMINISTRATOR(2, "组织管理员"),
    /**
     * 团队管理员
     */
    TEAM_ADMINISTRATOR(3, "团队管理员");

    private final Integer value;

    private final String desc;

    /**
     * 根据code码获取枚举
     */
    public static Optional<AccountRoleEnum> of(Integer value) {
        for (AccountRoleEnum t : AccountRoleEnum.class.getEnumConstants()) {
            if (t.getValue().intValue() == value.intValue()) {
                return Optional.of(t);
            }
        }
        return Optional.empty();
    }

    AccountRoleEnum(Integer code, String desc) {
        this.value = code;
        this.desc = desc;
    }

    @Override
    public Integer getValue() {
        return this.value;
    }

    @Override
    public String getDesc() {
        return this.desc;
    }


}
