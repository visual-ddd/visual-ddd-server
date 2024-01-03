package com.wakedt.visual.client.user.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * 创建账号
 *
 * @author zhuxueliang
 */
@Data
@ApiModel(value = "创建账号")
public class AccountVerificationCreateDTO {

    @ApiModelProperty(value = "账号")
    @NotBlank(message = "账号不能为空")
    @Pattern(regexp = "^[A-Za-z0-9\\u4e00-\\u9fa5]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$"
            , message = "账号格式不正确")
    private String accountNo;

}