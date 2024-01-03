package com.wakedt.visual.domain.businessscene.businesssceneversion.create;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 新增业务场景版本-指令
 *
 * @author zhuxueliang
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "新增业务场景版本指令")
public class BusinessSceneVersionCreateCmd {

    /** 所属业务场景ID */
    private Long businessSceneId;

    /** 起始版本号 */
    private String startVersion;

    /** 当前版本号 */
    private String currentVersion;

    /** 描述信息 */
    private String description;

}