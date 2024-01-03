package com.wakedt.visual.domain.user.account.passwordupdate;

import com.wakedata.common.core.exception.BizException;
import com.wakedt.visual.domain.user.account.Account;
import com.wakedt.visual.domain.user.account.AccountRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * 修改用户密码-指令处理器
 *
 * @author zhuxueliang
 */
@Component
public class AccountPasswordUpdateCmdHandler {

    @Resource
    private AccountRepository repository;

    public void handle(AccountPasswordUpdateCmd updateCmd) {

        Account account = repository.find(updateCmd.getId());
        if (Objects.isNull(account)) {
            throw new BizException("获取不到账号信息");
        }

        // 校验密码是否正确
        account.updateAccountPass(updateCmd);
        repository.update(account);

//        DomainEventPublisher.getInstance().postAfterCommit(new AccountPasswordUpdateCmdEvent(updateCmd));
    }
}