package com.wakedt.visual.domain.organization.organization.remove;

import com.wakedt.visual.domain.organization.organization.Organization;
import com.wakedt.visual.domain.organization.organization.OrganizationRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 删除组织-指令处理器
 *
 * @author zhuxueliang
 */
@Component
public class OrganizationRemoveCmdHandler {

    @Resource
    private OrganizationRepository repository;

    public void handle(OrganizationRemoveCmd removeCmd) {
        Organization organization = repository.find(removeCmd.getId());
        organization.remove(removeCmd);
        repository.remove(organization);

//        DomainEventPublisher.getInstance().postAfterCommit(new OrganizationRemoveCmdEvent(removeCmd));
    }
}