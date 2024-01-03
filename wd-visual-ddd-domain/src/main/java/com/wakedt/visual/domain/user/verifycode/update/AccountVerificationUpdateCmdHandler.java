package com.wakedt.visual.domain.user.verifycode.update;

import com.wakedata.common.core.exception.BizException;
import com.wakedt.visual.domain.user.verifycode.AccountVerification;
import com.wakedt.visual.domain.user.verifycode.AccountVerificationRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * author Wangchensheng@wakedata.com
 * date 2023年02月13日 14:19:10
 */
@Component
public class AccountVerificationUpdateCmdHandler {

    @Resource
    private AccountVerificationRepository repository;

    public void handle(AccountVerificationUpdateCmd updateCmd) {
        AccountVerification accountVerification = repository.find(updateCmd.getId());
        if (Objects.isNull(accountVerification)){
            throw new BizException("获取不到验证码信息");
        }

        accountVerification.updateAccountVerification(updateCmd);
        repository.update(accountVerification);
    }
}
