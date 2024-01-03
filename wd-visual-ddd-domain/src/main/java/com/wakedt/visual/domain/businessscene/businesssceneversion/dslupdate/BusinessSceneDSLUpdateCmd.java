package com.wakedt.visual.domain.businessscene.businesssceneversion.dslupdate;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 更新业务场景DSL-指令
 *
 * @author zhuxueliang
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "更新业务场景DSL指令")
public class BusinessSceneDSLUpdateCmd {

    /** 主键 */
    private Long id;

    /** 业务场景DSL */
    private String dsl;

    /** 图形DSL */
    private String graphDsl;

}