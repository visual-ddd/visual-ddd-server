package com.wakedt.visual.domain.organization.teammember.memberremove;

import com.wakedt.visual.domain.organization.teammember.TeamMember;
import com.wakedt.visual.domain.organization.teammember.TeamMemberRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 删除团队成员-指令处理器
 *
 * @author zhuxueliang
 */
@Component
public class TeamMemberRemoveCmdHandler {

    @Resource
    private TeamMemberRepository repository;

    public void handle(TeamMemberRemoveCmd removeCmd) {
        TeamMember teamMember = repository.find(removeCmd.getId());
        teamMember.remove(removeCmd);
        repository.remove(teamMember);

//        DomainEventPublisher.getInstance().postAfterCommit(new TeamMemberRemoveCmdEvent(removeCmd));
    }
}