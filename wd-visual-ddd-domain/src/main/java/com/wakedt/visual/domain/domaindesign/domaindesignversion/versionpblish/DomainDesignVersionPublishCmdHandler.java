package com.wakedt.visual.domain.domaindesign.domaindesignversion.versionpblish;

import com.wakedt.visual.domain.domaindesign.domaindesignversion.DomainDesignVersion;
import com.wakedt.visual.domain.domaindesign.domaindesignversion.DomainDesignVersionRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 发布业务域版本-指令处理器
 *
 * @author zhuxueliang
 */
@Component
public class DomainDesignVersionPublishCmdHandler {

    @Resource
    private DomainDesignVersionRepository repository;

    public void handle(DomainDesignVersionPublishCmd updateCmd) {
        DomainDesignVersion domainDesignVersion = repository.find(updateCmd.getId());
        domainDesignVersion.versionPublish(updateCmd);
        repository.update(domainDesignVersion);

//        DomainEventPublisher.getInstance().postAfterCommit(new DomainDesignVersionPblishCmdEvent(updateCmd));
    }
}