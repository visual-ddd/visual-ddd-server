package com.wakedt.visual.domain.user.account;

/**
 * 成员类型转换器
 *
 * @author zhuxueliang
 */
public class AccountRoleConverter {

    public Integer convertToDatabaseColumn(AccountRoleEnum accountRoleEnum) {
        return accountRoleEnum.getValue();
    }

    public AccountRoleEnum convertToEntityAttribute(Integer value) {
        return AccountRoleEnum.of(value).orElse(null);
    }

}
