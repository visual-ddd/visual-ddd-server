package com.wakedt.visual.client.user.dto;

import com.wakedata.common.core.base.BaseDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 账号信息
 *
 * @author zhuxueliang
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "账号信息")
public class AccountDTO extends BaseDTO {

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "账号(唯一标识)")
    private String accountNo;

    @ApiModelProperty(value = "用户名")
    private String userName;

    @ApiModelProperty(value = "角色：1 系统管理员 2 组织管理员 3 团队管理员")
    private Integer accountRole;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty("用户头像")
    private String icon;

}