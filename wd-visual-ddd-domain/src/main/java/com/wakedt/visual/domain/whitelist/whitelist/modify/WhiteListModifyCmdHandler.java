package com.wakedt.visual.domain.whitelist.whitelist.modify;

import com.wakedt.visual.domain.whitelist.whitelist.WhiteList;
import com.wakedt.visual.domain.whitelist.whitelist.WhiteListRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 编辑白名单-指令处理器
 */
@Component
public class WhiteListModifyCmdHandler {

    @Resource
    private WhiteListRepository repository;

    public void handle(WhiteListModifyCmd updateCmd) {
        WhiteList whiteList = repository.find(updateCmd.getId());
        whiteList.modify(updateCmd);

        repository.update(whiteList);

//        DomainEventPublisher.getInstance().postAfterCommit(new WhiteListModifyEvent(updateCmd));
    }
}