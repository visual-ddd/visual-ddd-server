package com.wakedt.visual.domain.domaindesign.domaindesign.update;

import com.wakedt.visual.domain.domaindesign.domaindesign.DomainDesign;
import com.wakedt.visual.domain.domaindesign.domaindesign.DomainDesignRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 更新业务域-指令处理器
 *
 * @author zhuxueliang
 */
@Component
public class DomainDesignUpdateCmdHandler {

    @Resource
    private DomainDesignRepository repository;

    public void handle(DomainDesignUpdateCmd updateCmd) {
        DomainDesign domainDesign = repository.find(updateCmd.getId());
        domainDesign.update(updateCmd);
        repository.update(domainDesign);

//        DomainEventPublisher.getInstance().postAfterCommit(new DomainDesignUpdateCmdEvent(updateCmd));
    }
}