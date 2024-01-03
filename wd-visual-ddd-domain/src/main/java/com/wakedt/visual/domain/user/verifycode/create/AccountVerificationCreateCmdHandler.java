package com.wakedt.visual.domain.user.verifycode.create;

import com.wakedt.visual.domain.user.account.AccountRepository;
import com.wakedt.visual.domain.user.verifycode.AccountVerification;
import com.wakedt.visual.domain.user.verifycode.AccountVerificationFactory;
import com.wakedt.visual.domain.user.verifycode.AccountVerificationRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * author Wangchensheng@wakedata.com
 * date 2023年02月13日 11:16:36
 */
@Component
public class AccountVerificationCreateCmdHandler {

    @Resource
    private AccountVerificationRepository accountVerificationRepository;

    @Resource
    private AccountRepository accountRepository;

    @Resource
    private AccountVerificationFactory factory;

    public void handle(AccountVerificationCreateCmd createCmd) {
        AccountVerification verification = factory.getInstance(createCmd);

        // 校验账号是否已被注册
        accountRepository.isAccountExistsOrError(createCmd.getAccountNo());
        accountVerificationRepository.save(verification);
    }

}
