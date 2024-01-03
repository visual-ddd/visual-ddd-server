package com.wakedt.visual.domain.domaindesign.domaindesignversion.remove;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 删除业务域版本-指令
 *
 * @author zhuxueliang
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "删除业务域版本指令")
public class DomainDesignVersionRemoveCmd {

    /** 主键 */
    private Long id;

}