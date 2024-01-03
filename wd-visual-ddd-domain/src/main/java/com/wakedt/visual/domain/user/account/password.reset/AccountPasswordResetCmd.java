package com.wakedt.visual.domain.user.account.password.reset;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 重置用户密码-指令
 *
 * @author zhuxueliang
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "重置用户密码指令")
public class AccountPasswordResetCmd {

    /** 主键 */
    private String accountNo;

    /** 重置密码唯一标识 */
    private String uuid;

    /** 新密码 */
    private String newPassword;

}