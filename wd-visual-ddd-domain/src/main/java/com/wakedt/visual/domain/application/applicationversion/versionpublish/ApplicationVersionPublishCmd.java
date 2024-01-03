package com.wakedt.visual.domain.application.applicationversion.versionpublish;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 发布应用版本-指令
 *
 * @author zhuxueliang
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "发布应用版本指令")
public class ApplicationVersionPublishCmd {

    /** 主键 */
    private Long id;

    /** 描述信息 */
    private String description;

}