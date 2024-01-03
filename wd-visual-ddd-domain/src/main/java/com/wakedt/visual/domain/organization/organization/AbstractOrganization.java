package com.wakedt.visual.domain.organization.organization;

import com.wakedt.visual.domain.DomainEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 组织-聚合根
 *
 * @author zhuxueliang
 */
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class AbstractOrganization extends DomainEntity {

    /** 组织管理员ID */
    private Long organizationManagerId;

    /** 描述信息 */
    private String description;

    /** 组织名称 */
    private String name;

}