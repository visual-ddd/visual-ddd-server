package com.wakedt.visual.domain.user.account.login;

import com.wakedata.common.core.exception.BizException;
import com.wakedt.visual.domain.user.account.Account;
import com.wakedt.visual.domain.user.account.AccountRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * 账号登录-指令处理器
 *
 * @author zhuxueliang
 */
@Component
public class AccountLoginCmdHandler {

    @Resource
    private AccountRepository repository;

    public Long handle(AccountLoginCmd cmd) {

        Account account = repository.findByAccountNo(cmd.getAccountNo());
        if (Objects.isNull(account)){
            throw new BizException("账号或密码输入错误");
        }

        if (Boolean.FALSE.equals(account.checkLoginPass(cmd.getPassword()))) {
            throw new BizException("账号名或密码不正确,操作失败");
        }
        return account.getId();
    }
}