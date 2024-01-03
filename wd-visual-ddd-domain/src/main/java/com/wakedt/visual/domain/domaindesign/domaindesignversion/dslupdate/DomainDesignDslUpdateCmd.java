package com.wakedt.visual.domain.domaindesign.domaindesignversion.dslupdate;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 更新业务域DSL-指令
 *
 * @author zhuxueliang
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "更新业务域DSL指令")
public class DomainDesignDslUpdateCmd {

    /**
     * 主键
     */
    private Long id;

    /**
     * 业务域DSL
     */
    private String domainDesignDsl;

    /**
     * 图形DSL
     */
    private String graphDsl;

}