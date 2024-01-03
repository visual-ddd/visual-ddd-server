package com.wakedt.visual.domain.application.applicationversion.remove;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 删除应用版本-指令
 *
 * @author zhuxueliang
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "删除应用版本指令")
public class ApplicationVersionRemoveCmd {

    /** 主键 */
    private Long id;

}