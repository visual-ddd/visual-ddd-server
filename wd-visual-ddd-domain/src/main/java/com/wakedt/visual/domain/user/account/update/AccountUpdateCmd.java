package com.wakedt.visual.domain.user.account.update;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 更新账号基本信息-指令
 *
 * @author zhuxueliang
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "更新账号基本信息指令")
public class AccountUpdateCmd {

    /**
     * 主键
     */
    private Long id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 描述
     */
    private String description;

    /**
     * 用户头像
     */
    private String icon;

    /**
     * 密码
     */
    private String newPassword;

}