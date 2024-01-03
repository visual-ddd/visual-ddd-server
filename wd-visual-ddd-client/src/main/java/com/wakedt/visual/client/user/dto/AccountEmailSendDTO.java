package com.wakedt.visual.client.user.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 发送重置密码邮件
 *
 * @author zhuxueliang
 */
@Data
@ApiModel(value = "发送重置密码邮件")
public class AccountEmailSendDTO {

    @ApiModelProperty(value = "账号")
    @NotBlank(message = "账号不能为空")
    private String accountNo;

}