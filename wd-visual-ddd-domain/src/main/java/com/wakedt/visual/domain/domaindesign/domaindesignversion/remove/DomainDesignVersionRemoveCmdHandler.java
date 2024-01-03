package com.wakedt.visual.domain.domaindesign.domaindesignversion.remove;

import com.wakedt.visual.domain.domaindesign.domaindesignversion.DomainDesignVersion;
import com.wakedt.visual.domain.domaindesign.domaindesignversion.DomainDesignVersionRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 删除业务域版本-指令处理器
 *
 * @author zhuxueliang
 */
@Component
public class DomainDesignVersionRemoveCmdHandler {

    @Resource
    private DomainDesignVersionRepository repository;

    public void handle(DomainDesignVersionRemoveCmd removeCmd) {
        DomainDesignVersion domainDesignVersion = repository.find(removeCmd.getId());
        domainDesignVersion.remove();
        repository.checkDomainVersionBindApplication(domainDesignVersion);
        repository.remove(domainDesignVersion);

//        DomainEventPublisher.getInstance().postAfterCommit(new DomainDesignVersionRemoveCmdEvent(removeCmd));
    }
}