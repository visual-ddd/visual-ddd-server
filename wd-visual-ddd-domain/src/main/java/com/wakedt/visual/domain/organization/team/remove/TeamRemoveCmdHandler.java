package com.wakedt.visual.domain.organization.team.remove;

import com.wakedt.visual.domain.organization.team.Team;
import com.wakedt.visual.domain.organization.team.TeamRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 删除团队-指令处理器
 *
 * @author zhuxueliang
 */
@Component
public class TeamRemoveCmdHandler {

    @Resource
    private TeamRepository repository;

    public void handle(TeamRemoveCmd removeCmd) {
        Team team = repository.find(removeCmd.getId());
        team.remove(removeCmd);
        repository.remove(team);

//        DomainEventPublisher.getInstance().postAfterCommit(new TeamRemoveCmdEvent(removeCmd));
    }
}