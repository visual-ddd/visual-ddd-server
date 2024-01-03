package com.wakedt.visual.domain.user.verifycode;

import com.wakedt.visual.domain.user.verifycode.update.AccountVerificationUpdateCmd;

/**
 * author Wangchensheng@wakedata.com
 * date 2023年02月13日 11:15:33
 */
public class AccountVerification extends AbstractAccountVerification {

    public void updateAccountVerification(AccountVerificationUpdateCmd updateCmd) {
        this.setId(updateCmd.getId());
        this.setCode(updateCmd.getCode());
    }

}
