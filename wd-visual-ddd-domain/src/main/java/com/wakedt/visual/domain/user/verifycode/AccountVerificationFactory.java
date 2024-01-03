package com.wakedt.visual.domain.user.verifycode;

import com.wakedt.visual.domain.user.verifycode.create.AccountVerificationCreateCmd;
import org.springframework.stereotype.Component;

/**
 * author Wangchensheng@wakedata.com
 * date 2023年02月13日 11:15:20
 */
@Component
public class AccountVerificationFactory {

    public AccountVerification getInstance(AccountVerificationCreateCmd createCmd) {
        AccountVerification instance = new AccountVerification();
        instance.setAccountNo(createCmd.getAccountNo());
        instance.setCode(createCmd.getCode());
        return instance;
    }

}
