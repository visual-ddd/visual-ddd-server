package com.wakedt.visual.domain.application.applicationversion.businesssceneversionbind;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

/**
 * 关联业务场景版本-指令
 *
 * @author zhuxueliang
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "关联业务场景版本指令")
public class BusinessSceneVersionBindCmd {

    /** 主键 */
    private Long id;

    /** 业务场景版本ID列表 */
    private Set<Long> businessSceneVersionIds;

}