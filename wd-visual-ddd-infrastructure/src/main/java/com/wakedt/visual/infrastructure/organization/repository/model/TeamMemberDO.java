package com.wakedt.visual.infrastructure.organization.repository.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.wakedt.visual.infrastructure.BaseJpaAggregate;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 团队成员实体类
 *
 * @author zhuxueliang
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "wd_organization_team_member")
@TableName("wd_organization_team_member")
public class TeamMemberDO extends BaseJpaAggregate {

    /** 团队ID */
    private Long teamId;

    /** 成员账号ID */
    private Long accountId;

    /** 成员类型（1-产品经理，2-架构师， 3-开发者） */
    private String memberTypeList;

}
