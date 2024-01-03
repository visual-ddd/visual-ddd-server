package com.wakedt.visual.domain.user.verifycode.update;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * author Wangchensheng@wakedata.com
 * date 2023年02月13日 14:19:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "更新验证码基本信息指令")
public class AccountVerificationUpdateCmd {

    /** 主键id */
    private Long id;

    /** 验证码 */
    private String code;

}
