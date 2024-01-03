package com.wakedt.visual.domain.businessscene.businesssceneversion.update;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 更新业务场景版本-指令
 *
 * @author zhuxueliang
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "更新业务场景版本指令")
public class BusinessSceneVersionUpdateCmd {

    /** 主键 */
    private Long id;

    /** 描述信息 */
    private String description;

}