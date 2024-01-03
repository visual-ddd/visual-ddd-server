package com.wakedt.visual.domain.application.application.update;

import com.wakedt.visual.domain.application.application.Application;
import com.wakedt.visual.domain.application.application.ApplicationRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 更新应用-指令处理器
 *
 * @author zhuxueliang
 */
@Component
public class ApplicationUpdateCmdHandler {

    @Resource
    private ApplicationRepository repository;

    public void handle(ApplicationUpdateCmd updateCmd) {
        Application application = repository.find(updateCmd.getId());
        application.update(updateCmd);
        repository.update(application);

//        DomainEventPublisher.getInstance().postAfterCommit(new ApplicationUpdateCmdEvent(updateCmd));
    }
}