package com.wakedt.visual.domain.organization.organization.managerunbind;

import com.wakedt.visual.domain.organization.organization.Organization;
import com.wakedt.visual.domain.organization.organization.OrganizationRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 解绑组织管理员-指令处理器
 *
 * @author zhuxueliang
 */
@Component
public class OrganizationManagerUnbindCmdHandler {

    @Resource
    private OrganizationRepository repository;

    public void handle(OrganizationManagerUnbindCmd updateCmd) {
        Organization organization = repository.find(updateCmd.getId());
        organization.managerUnbind(updateCmd);
        repository.update(organization);

//        DomainEventPublisher.getInstance().postAfterCommit(new OrganizationManagerUnbindCmdEvent(updateCmd));
    }
}