package com.wakedt.visual.domain.organization.team.create;

import com.wakedt.visual.domain.organization.team.Team;
import com.wakedt.visual.domain.organization.team.TeamFactory;
import com.wakedt.visual.domain.organization.team.TeamRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 创建团队-指令处理器
 *
 * @author zhuxueliang
 */
@Component
public class TeamCreateCmdHandler {

    @Resource
    private TeamRepository repository;
    @Resource
    private TeamFactory factory;

    public void handle(TeamCreateCmd createCmd) {
        Team team = factory.getInstance(createCmd);
        repository.checkRepeatedName(team);
        repository.save(team);

//        DomainEventPublisher.getInstance().postAfterCommit(new TeamCreateCmdEvent(createCmd));
    }
}