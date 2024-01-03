package com.wakedt.visual.domain.user.account;

import com.wakedt.visual.domain.user.account.create.AccountCreateCmd;
import org.springframework.stereotype.Component;

/**
 * 账号-聚合根-工厂
 *
 * @author zhuxueliang
 */
@Component
public class AccountFactory {

    public Account getInstance(AccountCreateCmd createCmd) {
        Account instance = new Account();
        instance.setUserName(createCmd.getUserName());
        instance.setAccountNo(createCmd.getAccountNo());
        instance.setPassword(createCmd.getPassword());
        instance.setIcon(createCmd.getIcon());
        return instance;
    }

}
