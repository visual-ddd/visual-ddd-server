package com.wakedt.visual.domain.businessscene.businesssceneversion.remove;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 删除业务场景版本-指令
 *
 * @author zhuxueliang
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "删除业务场景版本指令")
public class BusinessSceneVersionRemoveCmd {

    /** 主键 */
    private Long id;

}