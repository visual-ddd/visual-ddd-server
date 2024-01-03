package com.wakedt.visual.domain.domaindesign.domaindesign.remove;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 删除业务域-指令
 *
 * @author zhuxueliang
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "删除业务域指令")
public class DomainDesignRemoveCmd {

    /** 主键 */
    private Long id;

}