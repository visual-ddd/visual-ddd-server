package com.wakedt.visual.domain.organization.organization.managerbind;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 绑定组织管理员-指令
 *
 * @author zhuxueliang
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "绑定组织管理员指令")
public class OrganizationManagerBindCmd {

    /** 主键 */
    private Long id;

    /** 组织管理员ID */
    private Long organizationManagerId;

}