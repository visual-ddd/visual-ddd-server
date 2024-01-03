package com.wakedt.visual.domain.organization.teammember;

/**
 * 团队成员-聚合根-仓储接口
 *
 * @author zhuxueliang
 */
public interface TeamMemberRepository {

    TeamMember save(TeamMember teamMember);

    TeamMember update(TeamMember teamMember);

    void remove(TeamMember teamMember);

    TeamMember find(Long id);

    /**
     * 校验团队成员是否重复
     *
     * @param teamMember 团队
     */
    void checkRepeatedTeamMember(TeamMember teamMember);

}
