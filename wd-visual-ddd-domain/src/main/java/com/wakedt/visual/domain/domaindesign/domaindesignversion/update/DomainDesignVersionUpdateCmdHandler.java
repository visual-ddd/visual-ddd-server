package com.wakedt.visual.domain.domaindesign.domaindesignversion.update;

import com.wakedt.visual.domain.domaindesign.domaindesignversion.DomainDesignVersion;
import com.wakedt.visual.domain.domaindesign.domaindesignversion.DomainDesignVersionRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 更新业务域版本-指令处理器
 *
 * @author zhuxueliang
 */
@Component
public class DomainDesignVersionUpdateCmdHandler {

    @Resource
    private DomainDesignVersionRepository repository;

    public void handle(DomainDesignVersionUpdateCmd updateCmd) {
        DomainDesignVersion domainDesignVersion = repository.find(updateCmd.getId());
        domainDesignVersion.update(updateCmd);
        repository.update(domainDesignVersion);

//        DomainEventPublisher.getInstance().postAfterCommit(new DomainDesignVersionUpdateCmdEvent(updateCmd));
    }
}