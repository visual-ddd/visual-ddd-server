package com.wakedt.visual.domain.application.applicationversion.update;

import com.wakedt.visual.domain.application.applicationversion.ApplicationVersion;
import com.wakedt.visual.domain.application.applicationversion.ApplicationVersionRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 更新应用版本-指令处理器
 *
 * @author zhuxueliang
 */
@Component
public class ApplicationVersionUpdateCmdHandler {

    @Resource
    private ApplicationVersionRepository repository;

    public void handle(ApplicationVersionUpdateCmd updateCmd) {
        ApplicationVersion applicationVersion = repository.find(updateCmd.getId());
        applicationVersion.update(updateCmd);
        repository.update(applicationVersion);

//        DomainEventPublisher.getInstance().postAfterCommit(new ApplicationVersionUpdateCmdEvent(updateCmd));
    }
}