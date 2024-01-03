package com.wakedt.visual.domain.businessscene.businessscene.remove;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 删除业务场景-指令
 *
 * @author zhuxueliang
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "删除业务场景指令")
public class BusinessSceneRemoveCmd {

    /** 主键 */
    private Long id;

}