package com.wakedt.visual.domain.domaindesign.domaindesignversion.update;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 更新业务域版本-指令
 *
 * @author zhuxueliang
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "更新业务域版本指令")
public class DomainDesignVersionUpdateCmd {

    /** 主键 */
    private Long id;

    /** 描述信息 */
    private String description;

}