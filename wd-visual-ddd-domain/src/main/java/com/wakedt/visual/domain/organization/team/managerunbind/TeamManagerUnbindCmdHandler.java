package com.wakedt.visual.domain.organization.team.managerunbind;

import com.wakedt.visual.domain.organization.team.Team;
import com.wakedt.visual.domain.organization.team.TeamRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 解绑团队管理员-指令处理器
 *
 * @author zhuxueliang
 */
@Component
public class TeamManagerUnbindCmdHandler {

    @Resource
    private TeamRepository repository;

    public void handle(TeamManagerUnbindCmd updateCmd) {
        Team team = repository.find(updateCmd.getId());
        team.managerUnBind(updateCmd);
        repository.update(team);

//        DomainEventPublisher.getInstance().postAfterCommit(new TeamManagerUnbindCmdEvent(updateCmd));
    }
}