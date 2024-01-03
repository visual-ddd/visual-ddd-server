package com.wakedt.visual.domain.application.application.remove;

import com.wakedt.visual.domain.application.application.Application;
import com.wakedt.visual.domain.application.application.ApplicationRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 删除应用-指令处理器
 *
 * @author zhuxueliang
 */
@Component
public class ApplicationRemoveCmdHandler {

    @Resource
    private ApplicationRepository repository;

    public void handle(ApplicationRemoveCmd removeCmd) {
        Application application = repository.find(removeCmd.getId());
        application.remove(removeCmd);
        repository.remove(application);

//        DomainEventPublisher.getInstance().postAfterCommit(new ApplicationRemoveCmdEvent(removeCmd));
    }
}