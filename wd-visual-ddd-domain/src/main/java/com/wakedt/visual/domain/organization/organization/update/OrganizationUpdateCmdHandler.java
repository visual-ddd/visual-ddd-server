package com.wakedt.visual.domain.organization.organization.update;

import com.wakedt.visual.domain.organization.organization.Organization;
import com.wakedt.visual.domain.organization.organization.OrganizationRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 更新组织信息-指令处理器
 *
 * @author zhuxueliang
 */
@Component
public class OrganizationUpdateCmdHandler {

    @Resource
    private OrganizationRepository repository;

    public void handle(OrganizationUpdateCmd updateCmd) {
        Organization organization = repository.find(updateCmd.getId());
        organization.update(updateCmd);
        repository.checkRepeatedName(organization);
        repository.update(organization);

//        DomainEventPublisher.getInstance().postAfterCommit(new OrganizationUpdateCmdEvent(updateCmd));
    }
}