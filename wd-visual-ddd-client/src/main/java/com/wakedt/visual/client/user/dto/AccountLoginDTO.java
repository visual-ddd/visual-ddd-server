package com.wakedt.visual.client.user.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 账号登录
 *
 * @author zhuxueliang
 */
@Data
@ApiModel(value = "账号登录")
public class AccountLoginDTO {

    @ApiModelProperty(value = "账号")
    @NotBlank(message = "账号不能为空")
    private String accountNo;

    @ApiModelProperty(value = "密码")
    @NotBlank(message = "密码不能为空")
    private String password;

}