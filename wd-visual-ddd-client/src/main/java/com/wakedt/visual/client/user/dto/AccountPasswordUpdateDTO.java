package com.wakedt.visual.client.user.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 修改用户密码
 *
 * @author zhuxueliang
 */
@Data
@ApiModel(value = "修改用户密码")
public class AccountPasswordUpdateDTO {

    @ApiModelProperty(value = "主键")
    @NotNull(message = "主键不能为空")
    private Long id;

    @ApiModelProperty(value = "旧密码")
    @NotBlank(message = "旧密码不能为空")
    private String oldPassword;

    @ApiModelProperty(value = "新密码")
    @NotBlank(message = "新密码不能为空")
    private String newPassword;

    @ApiModelProperty(value = "是否为系统管理员")
    private Boolean isAdmin;

    @ApiModelProperty(value = "当前用户id")
    private Long currentUserId;

}