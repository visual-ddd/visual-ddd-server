package com.wakedt.visual.domain.organization.organization.create;

import com.wakedt.visual.domain.organization.organization.Organization;
import com.wakedt.visual.domain.organization.organization.OrganizationFactory;
import com.wakedt.visual.domain.organization.organization.OrganizationRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 创建组织-指令处理器
 *
 * @author zhuxueliang
 */
@Component
public class OrganizationCreateCmdHandler {

    @Resource
    private OrganizationRepository repository;
    @Resource
    private OrganizationFactory factory;

    public Long handle(OrganizationCreateCmd createCmd) {
        Organization organization = factory.getInstance(createCmd);
        repository.checkRepeatedName(organization);
        Organization newInstance = repository.save(organization);

//        DomainEventPublisher.getInstance().postAfterCommit(new OrganizationCreateCmdEvent(createCmd));
        return newInstance.getId();
    }
}