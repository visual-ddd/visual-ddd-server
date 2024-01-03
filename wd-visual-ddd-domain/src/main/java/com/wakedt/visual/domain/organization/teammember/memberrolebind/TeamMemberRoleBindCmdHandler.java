package com.wakedt.visual.domain.organization.teammember.memberrolebind;

import com.wakedt.visual.domain.organization.teammember.TeamMember;
import com.wakedt.visual.domain.organization.teammember.TeamMemberRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 绑定团队成员职位-指令处理器
 *
 * @author zhuxueliang
 */
@Component
public class TeamMemberRoleBindCmdHandler {

    @Resource
    private TeamMemberRepository repository;

    public void handle(TeamMemberRoleBindCmd updateCmd) {
        TeamMember teamMember = repository.find(updateCmd.getId());
        teamMember.memberRoleBind(updateCmd);
        repository.update(teamMember);

//        DomainEventPublisher.getInstance().postAfterCommit(new TeamMemberRoleBindCmdEvent(updateCmd));
    }
}