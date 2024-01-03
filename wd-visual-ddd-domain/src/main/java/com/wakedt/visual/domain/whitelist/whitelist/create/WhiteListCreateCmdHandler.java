package com.wakedt.visual.domain.whitelist.whitelist.create;

import com.wakedt.visual.domain.whitelist.whitelist.WhiteList;
import com.wakedt.visual.domain.whitelist.whitelist.WhiteListFactory;
import com.wakedt.visual.domain.whitelist.whitelist.WhiteListRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 新增白名单-指令处理器
 */
@Component
public class WhiteListCreateCmdHandler {

    @Resource
    private WhiteListRepository repository;
    @Resource
    private WhiteListFactory factory;

    public Long handle(WhiteListCreateCmd createCmd) {
        WhiteList entity = factory.getInstance(createCmd);

        WhiteList newEntity = repository.save(entity);

//        DomainEventPublisher.getInstance().postAfterCommit(new WhiteListCreateEvent(createCmd));
        return newEntity.getId();
    }
}