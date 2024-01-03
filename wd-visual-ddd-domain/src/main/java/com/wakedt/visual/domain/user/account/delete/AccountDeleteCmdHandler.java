package com.wakedt.visual.domain.user.account.delete;

import com.wakedata.common.core.exception.BizException;
import com.wakedt.visual.domain.user.account.Account;
import com.wakedt.visual.domain.user.account.AccountRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * 删除用户账号-指令处理器
 *
 * @author zhuxueliang
 */
@Component
public class AccountDeleteCmdHandler {

    @Resource
    private AccountRepository repository;

    public void handle(AccountDeleteCmd removeCmd) {
        Account account = repository.find(removeCmd.getId());
        if (Objects.isNull(account)){
            throw new BizException("获取不到账号信息");
        }

        account.checkSystemAdmin();
        repository.remove(account);

//        DomainEventPublisher.getInstance().postAfterCommit(new AccountDeleteCmdEvent(removeCmd));
    }
}