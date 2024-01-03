package com.wakedt.visual.domain.user.verifycode.create;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * author Wangchensheng@wakedata.com
 * date 2023年02月13日 11:14:43
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "创建验证码基本信息指令")
public class AccountVerificationCreateCmd {

    private String accountNo;

    private String code;

}
