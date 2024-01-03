package com.wakedt.visual.domain.organization.team.update;

import com.wakedt.visual.domain.organization.team.Team;
import com.wakedt.visual.domain.organization.team.TeamRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 更新团队信息-指令处理器
 *
 * @author zhuxueliang
 */
@Component
public class TeamUpdateCmdHandler {

    @Resource
    private TeamRepository repository;

    public void handle(TeamUpdateCmd updateCmd) {
        Team team = repository.find(updateCmd.getId());
        team.update(updateCmd);
        repository.checkRepeatedName(team);
        repository.update(team);

//        DomainEventPublisher.getInstance().postAfterCommit(new TeamUpdateCmdEvent(updateCmd));
    }
}