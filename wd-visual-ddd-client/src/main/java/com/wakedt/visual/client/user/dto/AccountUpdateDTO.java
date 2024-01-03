package com.wakedt.visual.client.user.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 更新账号基本信息
 *
 * @author zhuxueliang
 */
@Data
@ApiModel(value = "更新账号基本信息")
public class AccountUpdateDTO {

    @ApiModelProperty(value = "主键")
    @NotNull(message = "主键不能为空")
    private Long id;

    @ApiModelProperty(value = "用户名")
    private String userName;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "用户头像")
    private String icon;

    @ApiModelProperty(value = "新密码(仅超级管理员更改其他人密码时使用)")
    private String newPassword;

    @ApiModelProperty(value = "是否为系统管理员")
    private Boolean isAdmin;

    @ApiModelProperty(value = "当前用户id")
    private Long currentUserId;
}