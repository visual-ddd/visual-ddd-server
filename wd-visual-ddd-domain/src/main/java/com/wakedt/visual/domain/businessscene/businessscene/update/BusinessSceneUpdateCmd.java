package com.wakedt.visual.domain.businessscene.businessscene.update;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 更新业务场景-指令
 *
 * @author zhuxueliang
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "更新业务场景指令")
public class BusinessSceneUpdateCmd {

    /** 主键 */
    private Long id;

    /** 名称 */
    private String name;

    /** 描述信息 */
    private String description;

}