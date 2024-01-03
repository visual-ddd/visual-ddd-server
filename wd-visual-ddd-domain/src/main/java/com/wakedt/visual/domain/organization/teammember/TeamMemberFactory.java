package com.wakedt.visual.domain.organization.teammember;

import com.wakedt.visual.domain.organization.teammember.memberadd.TeamMemberAddCmd;
import org.springframework.stereotype.Component;

/**
 * 团队成员-聚合根-工厂
 *
 * @author zhuxueliang
 */
@Component
public class TeamMemberFactory {

    public TeamMember getInstance(TeamMemberAddCmd createCmd) {
        TeamMember instance = new TeamMember();
        instance.setAccountId(createCmd.getAccountId());
        instance.setTeamId(createCmd.getTeamId());
        instance.setMemberTypeList(createCmd.getMemberTypeList());
        return instance;
    }

}
