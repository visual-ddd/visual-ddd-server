package com.wakedt.visual.domain.user.account.delete;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 删除用户账号-指令
 *
 * @author zhuxueliang
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "删除用户账号指令")
public class AccountDeleteCmd {

    /** 主键 */
    private Long id;

}