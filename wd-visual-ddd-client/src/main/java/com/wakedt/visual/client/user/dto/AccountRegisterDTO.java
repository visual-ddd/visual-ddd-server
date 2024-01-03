package com.wakedt.visual.client.user.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;

/**
 * 创建账号
 *
 * @author zhuxueliang
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel(value = "创建账号")
public class AccountRegisterDTO extends AccountCreateDTO {

    @ApiModelProperty(value = "验证码(注册时需要填写)")
    @NotBlank(message = "验证码不能为空")
    private String code;

}