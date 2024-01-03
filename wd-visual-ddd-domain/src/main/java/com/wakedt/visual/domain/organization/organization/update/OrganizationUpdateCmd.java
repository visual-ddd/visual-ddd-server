package com.wakedt.visual.domain.organization.organization.update;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 更新组织信息-指令
 *
 * @author zhuxueliang
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "更新组织信息指令")
public class OrganizationUpdateCmd {

    /** 主键 */
    private Long id;

    /** 组织名称 */
    private String name;

    /** 描述信息 */
    private String description;

    /** 组织管理员ID */
    private Long organizationManagerId;
}