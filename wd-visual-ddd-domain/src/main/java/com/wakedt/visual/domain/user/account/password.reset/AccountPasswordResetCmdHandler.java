package com.wakedt.visual.domain.user.account.password.reset;

import com.wakedata.common.core.exception.BizException;
import com.wakedt.visual.domain.user.account.Account;
import com.wakedt.visual.domain.user.account.AccountRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * 重置用户密码-指令处理器
 *
 * @author zhuxueliang
 */
@Component
public class AccountPasswordResetCmdHandler {

    @Resource
    private AccountRepository repository;

    public void handle(AccountPasswordResetCmd updateCmd) {
        Account account = repository.findByAccountNo(updateCmd.getAccountNo());
        if (Objects.isNull(account)){
            throw new BizException("获取不到账号信息");
        }

        account.accountPassReset(updateCmd);
        repository.update(account);

//        DomainEventPublisher.getInstance().postAfterCommit(new AccountPasswordResetCmdEvent(updateCmd));
    }
}