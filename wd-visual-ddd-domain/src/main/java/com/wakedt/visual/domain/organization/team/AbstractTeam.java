package com.wakedt.visual.domain.organization.team;

import com.wakedt.visual.domain.DomainEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 团队-聚合根
 *
 * @author zhuxueliang
 */
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class AbstractTeam extends DomainEntity {

    /** 所属组织ID */
    private Long organizationId;

    /** 团队名称 */
    private String name;

    /** 团队管理员ID */
    private Long teamManagerId;

    /** 描述信息 */
    private String description;

}