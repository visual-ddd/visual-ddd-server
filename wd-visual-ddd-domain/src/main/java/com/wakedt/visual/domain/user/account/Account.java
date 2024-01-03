package com.wakedt.visual.domain.user.account;

import cn.hutool.core.util.ObjectUtil;
import com.wakedata.common.core.exception.BizException;
import com.wakedt.visual.domain.user.account.password.reset.AccountPasswordResetCmd;
import com.wakedt.visual.domain.user.account.passwordupdate.AccountPasswordUpdateCmd;
import com.wakedt.visual.domain.user.account.update.AccountUpdateCmd;

import java.util.Objects;

/**
 * 账号-聚合根-能力
 *
 * @author zhuxueliang
 */
public class Account extends AbstractAccount {

    @Override
    public Boolean checkLoginPass(String password){
        return ObjectUtil.equals(this.getPassword(), password);
    }

    @Override
    public void checkUuidPass(String uuid){
        if (ObjectUtil.notEqual(this.getUuid(), uuid)){
            throw new BizException("重置密码唯一标识不正确");
        }
    }

    @Override
    public void checkSystemAdmin() {
        // 目前系统管理员需要手动在数据库进行初始化，且id=1
        if (Objects.equals(this.getId(), 1L)){
            throw new BizException("该账号为系统管理员，不允许删除");
        }
    }

    public void updateAccountInfo(AccountUpdateCmd updateCmd) {
        this.setId(updateCmd.getId());
        this.setUserName(updateCmd.getUserName());
        this.setDescription(updateCmd.getDescription());
        this.setIcon(updateCmd.getIcon());
        this.setPassword(updateCmd.getNewPassword());
    }

    public void accountPassReset(AccountPasswordResetCmd updateCmd) {
        this.checkUuidPass(updateCmd.getUuid());
        this.setAccountNo(updateCmd.getAccountNo());
        this.setPassword(updateCmd.getNewPassword());
    }

    public void updateAccountPass(AccountPasswordUpdateCmd updateCmd) {
        if (Boolean.FALSE.equals(this.checkLoginPass(updateCmd.getOldPassword()))) {
            throw new BizException("旧密码不正确");
        }
        this.setId(updateCmd.getId());
        this.setPassword(updateCmd.getNewPassword());
    }

    public void updateAccountRetPass(String uuid) {
        this.setUuid(uuid);
    }
}