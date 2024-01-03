package com.wakedt.visual.domain.domaindesign.domaindesignversion.versionpblish;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 发布业务域版本-指令
 *
 * @author zhuxueliang
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "发布业务域版本指令")
public class DomainDesignVersionPublishCmd {

    /**
     * 主键
     */
    private Long id;

    /** 描述信息 */
    private String description;

}