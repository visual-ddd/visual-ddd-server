package com.wakedt.visual.domain.application.applicationversion.update;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 更新应用版本-指令
 *
 * @author zhuxueliang
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "更新应用版本指令")
public class ApplicationVersionUpdateCmd {

    /** 主键 */
    private Long id;

    /** 描述信息 */
    private String description;

}