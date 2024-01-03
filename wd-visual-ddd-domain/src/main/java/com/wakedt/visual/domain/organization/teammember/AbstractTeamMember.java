package com.wakedt.visual.domain.organization.teammember;

import com.wakedt.visual.domain.DomainEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 团队成员-聚合根
 *
 * @author zhuxueliang
 */
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class AbstractTeamMember extends DomainEntity {

    /** 团队ID */
    private Long teamId;

    /** 成员账号ID */
    private Long accountId;

    /** 成员类型（1-产品经理，2-架构师， 3-开发者） */
    private List<MemberType> memberTypeList;

}