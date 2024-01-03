package com.wakedt.visual.domain.organization.organization.managerunbind;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 解绑组织管理员-指令
 *
 * @author zhuxueliang
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "解绑组织管理员指令")
public class OrganizationManagerUnbindCmd {

    /** 主键 */
    private Long id;

}