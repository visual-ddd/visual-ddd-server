package com.wakedt.visual.domain.organization.team;

import com.wakedt.visual.domain.organization.team.managerbind.TeamManagerBindCmd;
import com.wakedt.visual.domain.organization.team.managerunbind.TeamManagerUnbindCmd;
import com.wakedt.visual.domain.organization.team.remove.TeamRemoveCmd;
import com.wakedt.visual.domain.organization.team.update.TeamUpdateCmd;

/**
 * 团队-聚合根-能力
 *
 * @author zhuxueliang
 */
public class Team extends AbstractTeam {

    public void update(TeamUpdateCmd updateCmd) {
        this.setId(updateCmd.getId());
        this.setName(updateCmd.getName());
        this.setDescription(updateCmd.getDescription());
        this.setTeamManagerId(updateCmd.getTeamManagerId());
    }

    public void remove(TeamRemoveCmd removeCmd) {
        this.setId(removeCmd.getId());
    }

    public void managerBind(TeamManagerBindCmd updateCmd) {
        this.setId(updateCmd.getId());
        this.setTeamManagerId(updateCmd.getTeamManagerId());
    }

    public void managerUnBind(TeamManagerUnbindCmd updateCmd) {
        this.setId(updateCmd.getId());
        this.setTeamManagerId(-1L);
    }
}