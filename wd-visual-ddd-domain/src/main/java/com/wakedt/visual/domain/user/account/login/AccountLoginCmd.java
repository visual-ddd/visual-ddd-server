package com.wakedt.visual.domain.user.account.login;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 账号登录-指令
 *
 * @author zhuxueliang
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "账号登录指令")
public class AccountLoginCmd {

    /** 账号 */
    private String accountNo;

    /** 密码 */
    private String password;

}