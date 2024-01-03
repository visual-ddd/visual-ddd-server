package com.wakedt.visual.domain.domaindesign.domaindesign.create;

import com.wakedt.visual.domain.domaindesign.domaindesign.DomainDesign;
import com.wakedt.visual.domain.domaindesign.domaindesign.DomainDesignFactory;
import com.wakedt.visual.domain.domaindesign.domaindesign.DomainDesignRepository;
import com.wakedt.visual.domain.domaindesign.domaindesignversion.create.DomainDesignVersionCreateCmd;
import com.wakedt.visual.domain.domaindesign.domaindesignversion.create.DomainDesignVersionCreateCmdHandler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 新增业务域-指令处理器
 *
 * @author zhuxueliang
 */
@Component
public class DomainDesignCreateCmdHandler {

    @Resource
    private DomainDesignRepository repository;
    @Resource
    private DomainDesignFactory factory;
    @Resource
    private DomainDesignVersionCreateCmdHandler domainDesignVersionCreateCmdHandler;

    public Long handle(DomainDesignCreateCmd createCmd) {
        DomainDesign domainDesign = factory.getInstance(createCmd);

        // 校验业务域唯一标识是否唯一
        repository.checkRepeatedIdentity(domainDesign);
        // 新增业务域
        DomainDesign newDomainDesign = repository.save(domainDesign);
        // 新增业务域版本
        String startVersion = createCmd.getStartVersion();
        domainDesignVersionCreateCmdHandler.handle(new DomainDesignVersionCreateCmd(
                newDomainDesign.getId(), startVersion, startVersion, "起始版本"));

//        DomainEventPublisher.getInstance().postAfterCommit(new DomainDesignCreateCmdEvent(createCmd));
        return newDomainDesign.getId();
    }
}