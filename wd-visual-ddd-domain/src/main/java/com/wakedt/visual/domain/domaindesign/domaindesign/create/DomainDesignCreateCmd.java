package com.wakedt.visual.domain.domaindesign.domaindesign.create;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 新增业务域-指令
 *
 * @author zhuxueliang
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "新增业务域指令")
public class DomainDesignCreateCmd {

    /** 所属团队ID */
    private Long teamId;

    /** 名称 */
    private String name;

    /** 标识符 */
    private String identity;

    /** 描述信息 */
    private String description;

    /** 起始版本号 */
    private String startVersion;

}