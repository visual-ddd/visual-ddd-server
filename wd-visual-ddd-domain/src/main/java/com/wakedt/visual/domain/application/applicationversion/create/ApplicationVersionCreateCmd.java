package com.wakedt.visual.domain.application.applicationversion.create;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 新增应用版本-指令
 *
 * @author zhuxueliang
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "新增应用版本指令")
public class ApplicationVersionCreateCmd {

    /** 所属应用ID */
    private Long applicationId;

    /** 起始版本号 */
    private String startVersion;

    /** 当前版本号 */
    private String currentVersion;

    /** 描述信息 */
    private String description;

}