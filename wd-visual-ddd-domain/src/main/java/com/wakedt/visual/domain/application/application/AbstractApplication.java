package com.wakedt.visual.domain.application.application;

import com.wakedt.visual.domain.DomainEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 应用-聚合根
 *
 * @author zhuxueliang
 */
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class AbstractApplication extends DomainEntity {

    /** 所属团队ID */
    private Long teamId;

    /** 名称 */
    private String name;

    /** 标识符 */
    private String identity;

    /** 描述信息 */
    private String description;

    /** 包名 */
    private String packageName;

}