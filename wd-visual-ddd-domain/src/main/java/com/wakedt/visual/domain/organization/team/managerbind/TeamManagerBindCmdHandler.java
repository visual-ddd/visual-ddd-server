package com.wakedt.visual.domain.organization.team.managerbind;

import com.wakedt.visual.domain.organization.team.Team;
import com.wakedt.visual.domain.organization.team.TeamRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 绑定团队管理员-指令处理器
 *
 * @author zhuxueliang
 */
@Component
public class TeamManagerBindCmdHandler {

    @Resource
    private TeamRepository repository;

    public void handle(TeamManagerBindCmd updateCmd) {
        Team team = repository.find(updateCmd.getId());
        team.managerBind(updateCmd);
        repository.update(team);

//        DomainEventPublisher.getInstance().postAfterCommit(new TeamManagerBindCmdEvent(updateCmd));
    }
}