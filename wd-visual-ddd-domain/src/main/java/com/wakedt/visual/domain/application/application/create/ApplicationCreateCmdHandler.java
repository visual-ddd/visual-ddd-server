package com.wakedt.visual.domain.application.application.create;

import com.wakedt.visual.domain.application.application.Application;
import com.wakedt.visual.domain.application.application.ApplicationFactory;
import com.wakedt.visual.domain.application.application.ApplicationRepository;
import com.wakedt.visual.domain.application.applicationversion.create.ApplicationVersionCreateCmd;
import com.wakedt.visual.domain.application.applicationversion.create.ApplicationVersionCreateCmdHandler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 新增应用-指令处理器
 *
 * @author zhuxueliang
 */
@Component
public class ApplicationCreateCmdHandler {

    @Resource
    private ApplicationRepository repository;
    @Resource
    private ApplicationFactory factory;
    @Resource
    private ApplicationVersionCreateCmdHandler applicationVersionCreateCmdHandler;

    public Long handle(ApplicationCreateCmd createCmd) {
        Application application = factory.getInstance(createCmd);
        // 标识符唯一
        repository.checkRepeatedIdentity(application);
        Application newApplication = repository.save(application);

        // 同时初始化起始版本
        String startVersion = createCmd.getStartVersion();
        applicationVersionCreateCmdHandler.handle(
                new ApplicationVersionCreateCmd(newApplication.getId(), startVersion, startVersion, "起始版本"));

//        DomainEventPublisher.getInstance().postAfterCommit(new ApplicationCreateCmdEvent(createCmd));
        return newApplication.getId();
    }
}