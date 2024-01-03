package com.wakedt.visual.domain.domaindesign.domaindesignversion.create;

import com.wakedt.visual.domain.domaindesign.domaindesignversion.DomainDesignVersion;
import com.wakedt.visual.domain.domaindesign.domaindesignversion.DomainDesignVersionFactory;
import com.wakedt.visual.domain.domaindesign.domaindesignversion.DomainDesignVersionRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 新增业务域版本-指令处理器
 *
 * @author zhuxueliang
 */
@Component
public class DomainDesignVersionCreateCmdHandler {

    @Resource
    private DomainDesignVersionRepository repository;
    @Resource
    private DomainDesignVersionFactory factory;

    public Long handle(DomainDesignVersionCreateCmd createCmd) {
        DomainDesignVersion domainDesignVersion = factory.getInstance(createCmd);

        // 校验版本号
        domainDesignVersion.checkLegalVersion();
        // 校验应用是否存在
        repository.checkCurrentDomainDesignExit(domainDesignVersion);
        // 当前应用下版本号唯一
        repository.checkDomainVersionIdentityUnique(domainDesignVersion);
        DomainDesignVersion newDomainDesignVersion = repository.save(domainDesignVersion);

//        DomainEventPublisher.getInstance().postAfterCommit(new DomainDesignVersionCreateCmdEvent(createCmd));
        return newDomainDesignVersion.getId();
    }
}