package com.wakedt.visual.domain.application.applicationversion.remove;

import com.wakedt.visual.domain.application.applicationversion.ApplicationVersion;
import com.wakedt.visual.domain.application.applicationversion.ApplicationVersionRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 删除应用版本-指令处理器
 *
 * @author zhuxueliang
 */
@Component
public class ApplicationVersionRemoveCmdHandler {

    @Resource
    private ApplicationVersionRepository repository;

    public void handle(ApplicationVersionRemoveCmd removeCmd) {
        ApplicationVersion applicationVersion = repository.find(removeCmd.getId());
        applicationVersion.remove(removeCmd);
        repository.remove(applicationVersion);

//        DomainEventPublisher.getInstance().postAfterCommit(new ApplicationVersionRemoveCmdEvent(removeCmd));
    }
}