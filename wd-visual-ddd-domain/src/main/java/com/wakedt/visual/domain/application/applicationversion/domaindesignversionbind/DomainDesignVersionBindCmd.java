package com.wakedt.visual.domain.application.applicationversion.domaindesignversionbind;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

/**
 * 关联业务域版本-指令
 *
 * @author zhuxueliang
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "关联业务域版本指令")
public class DomainDesignVersionBindCmd {

    /** 主键 */
    private Long id;

    /** 业务域版本ID列表 */
    private Set<Long> domainDesignVersionIds;

}