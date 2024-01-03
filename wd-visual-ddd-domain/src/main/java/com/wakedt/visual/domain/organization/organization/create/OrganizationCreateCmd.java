package com.wakedt.visual.domain.organization.organization.create;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 创建组织-指令
 *
 * @author zhuxueliang
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "创建组织指令")
public class OrganizationCreateCmd {

    /** 组织名称 */
    private String name;

    /** 描述信息 */
    private String description;

    /** 组织管理员ID */
    private Long organizationManagerId;
}