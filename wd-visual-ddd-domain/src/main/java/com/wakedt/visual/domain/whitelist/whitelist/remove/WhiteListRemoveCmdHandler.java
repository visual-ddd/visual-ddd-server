package com.wakedt.visual.domain.whitelist.whitelist.remove;

import com.wakedt.visual.domain.whitelist.whitelist.WhiteList;
import com.wakedt.visual.domain.whitelist.whitelist.WhiteListRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 删除白名单-指令处理器
 */
@Component
public class WhiteListRemoveCmdHandler {

    @Resource
    private WhiteListRepository repository;

    public void handle(WhiteListRemoveCmd removeCmd) {
        WhiteList whiteList = repository.find(removeCmd.getId());
        whiteList.remove(removeCmd);

        repository.remove(whiteList);

//        DomainEventPublisher.getInstance().postAfterCommit(new WhiteListRemoveEvent(removeCmd));
    }
}