package com.wakedt.visual.domain.user.account.update;

import com.wakedata.common.core.exception.BizException;
import com.wakedt.visual.domain.user.account.Account;
import com.wakedt.visual.domain.user.account.AccountRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * 更新账号基本信息-指令处理器
 *
 * @author zhuxueliang
 */
@Component
public class AccountUpdateCmdHandler {

    @Resource
    private AccountRepository repository;

    public void handle(AccountUpdateCmd updateCmd) {
        Account account = repository.find(updateCmd.getId());
        if (Objects.isNull(account)){
            throw new BizException("获取不到账号信息");
        }

        account.updateAccountInfo(updateCmd);
        repository.update(account);

//        DomainEventPublisher.getInstance().postAfterCommit(new AccountUpdateCmdEvent(updateCmd));
    }
}