package com.wakedt.visual.domain.domaindesign.domaindesign.update;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 更新业务域-指令
 *
 * @author zhuxueliang
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "更新业务域指令")
public class DomainDesignUpdateCmd {

    /** 主键 */
    private Long id;

    /** 名称 */
    private String name;

    /** 描述信息 */
    private String description;

}