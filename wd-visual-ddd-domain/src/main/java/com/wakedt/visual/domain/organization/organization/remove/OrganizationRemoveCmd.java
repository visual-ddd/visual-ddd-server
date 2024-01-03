package com.wakedt.visual.domain.organization.organization.remove;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 删除组织-指令
 *
 * @author zhuxueliang
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "删除组织指令")
public class OrganizationRemoveCmd {

    /** 主键 */
    private Long id;

}