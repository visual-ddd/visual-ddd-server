package com.wakedt.visual.domain.domaindesign.domaindesignversion.dslupdate;

import com.wakedt.visual.domain.domaindesign.domaindesignversion.DomainDesignVersion;
import com.wakedt.visual.domain.domaindesign.domaindesignversion.DomainDesignVersionRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 更新业务域DSL-指令处理器
 *
 * @author zhuxueliang
 */
@Component
public class DomainDesignDslUpdateCmdHandler {

    @Resource
    private DomainDesignVersionRepository repository;

    public void handle(DomainDesignDslUpdateCmd updateCmd) {
        DomainDesignVersion domainDesignVersion = repository.find(updateCmd.getId());
        domainDesignVersion.dslUpdate(updateCmd);
        repository.update(domainDesignVersion);

//        DomainEventPublisher.getInstance().postAfterCommit(new DomainDesignDslUpdateCmdEvent(updateCmd));
    }
}