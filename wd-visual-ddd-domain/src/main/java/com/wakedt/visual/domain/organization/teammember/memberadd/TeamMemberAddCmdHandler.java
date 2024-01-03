package com.wakedt.visual.domain.organization.teammember.memberadd;

import com.wakedt.visual.domain.organization.teammember.TeamMember;
import com.wakedt.visual.domain.organization.teammember.TeamMemberFactory;
import com.wakedt.visual.domain.organization.teammember.TeamMemberRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 添加团队成员-指令处理器
 *
 * @author zhuxueliang
 */
@Component
public class TeamMemberAddCmdHandler {

    @Resource
    private TeamMemberRepository repository;
    @Resource
    private TeamMemberFactory factory;

    public void handle(TeamMemberAddCmd createCmd) {
        TeamMember teamMember = factory.getInstance(createCmd);
        repository.checkRepeatedTeamMember(teamMember);
        repository.save(teamMember);

//        DomainEventPublisher.getInstance().postAfterCommit(new TeamMemberAddCmdEvent(createCmd));
    }
}