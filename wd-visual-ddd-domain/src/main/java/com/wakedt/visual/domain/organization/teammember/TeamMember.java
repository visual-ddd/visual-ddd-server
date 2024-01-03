package com.wakedt.visual.domain.organization.teammember;

import com.wakedt.visual.domain.organization.teammember.memberremove.TeamMemberRemoveCmd;
import com.wakedt.visual.domain.organization.teammember.memberrolebind.TeamMemberRoleBindCmd;
import com.wakedt.visual.domain.organization.teammember.memberroleunbind.TeamMemberRoleUnbindCmd;

/**
 * 团队成员-聚合根-能力
 *
 * @author zhuxueliang
 */
public class TeamMember extends AbstractTeamMember {

    public void memberRoleBind(TeamMemberRoleBindCmd updateCmd) {
        this.setId(updateCmd.getId());
        this.setMemberTypeList(updateCmd.getMemberTypeList());
    }

    public void memberRoleUnBind(TeamMemberRoleUnbindCmd updateCmd) {
        this.setId(updateCmd.getId());
        this.setMemberTypeList(updateCmd.getMemberTypeList());
    }

    public void remove(TeamMemberRemoveCmd removeCmd) {

    }

}