package com.wakedt.visual.domain.user.account.email.send;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 发送重置密码邮件-指令
 *
 * @author zhuxueliang
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "发送重置密码邮件指令")
public class AccountEmailSendCmd {

    /** 账号 */
    private String accountNo;

}