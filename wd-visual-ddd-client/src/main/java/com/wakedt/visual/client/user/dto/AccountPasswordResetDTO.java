package com.wakedt.visual.client.user.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 重置用户密码
 *
 * @author zhuxueliang
 */
@Data
@ApiModel(value = "重置用户密码")
public class AccountPasswordResetDTO {

    @ApiModelProperty(value = "账号")
    @NotNull(message = "账号不能为空")
    private String accountNo;

    @ApiModelProperty(value = "重置密码唯一标识")
    @NotBlank(message = "重置密码唯一标识不能为空")
    private String uuid;

    @ApiModelProperty(value = "新密码")
    @NotBlank(message = "新密码不能为空")
    private String newPassword;

}