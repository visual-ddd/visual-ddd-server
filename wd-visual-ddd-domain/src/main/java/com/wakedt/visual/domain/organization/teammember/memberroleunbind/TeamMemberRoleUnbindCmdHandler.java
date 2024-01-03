package com.wakedt.visual.domain.organization.teammember.memberroleunbind;

import com.wakedt.visual.domain.organization.teammember.TeamMember;
import com.wakedt.visual.domain.organization.teammember.TeamMemberRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 解绑团队成员职位-指令处理器
 *
 * @author zhuxueliang
 */
@Component
public class TeamMemberRoleUnbindCmdHandler {

    @Resource
    private TeamMemberRepository repository;

    public void handle(TeamMemberRoleUnbindCmd updateCmd) {
        TeamMember teamMember = repository.find(updateCmd.getId());
        teamMember.memberRoleUnBind(updateCmd);
        repository.update(teamMember);

        // DomainEventPublisher.getInstance().postAfterCommit(new TeamMemberRoleUnbindCmdEvent(cmd));
    }
}