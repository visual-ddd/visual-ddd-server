package com.wakedt.visual.domain.organization.organization.managerbind;

import com.wakedt.visual.domain.organization.organization.Organization;
import com.wakedt.visual.domain.organization.organization.OrganizationRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 绑定组织管理员-指令处理器
 *
 * @author zhuxueliang
 */
@Component
public class OrganizationManagerBindCmdHandler {

    @Resource
    private OrganizationRepository repository;

    public void handle(OrganizationManagerBindCmd updateCmd) {
        Organization organization = repository.find(updateCmd.getId());
        organization.managerBind(updateCmd);
        repository.update(organization);

//        DomainEventPublisher.getInstance().postAfterCommit(new OrganizationManagerBindCmdEvent(updateCmd));
    }
}