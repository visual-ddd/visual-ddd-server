package com.wakedt.visual.domain.application.application.update;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 更新应用-指令
 *
 * @author zhuxueliang
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "更新应用指令")
public class ApplicationUpdateCmd {

    /** 主键 */
    private Long id;

    /** 名称 */
    private String name;

    /** 包名 */
    private String packageName;

    /** 描述信息 */
    private String description;

}