package com.wakedt.visual.domain.application.applicationversion.create;

import com.wakedt.visual.domain.application.applicationversion.ApplicationVersion;
import com.wakedt.visual.domain.application.applicationversion.ApplicationVersionFactory;
import com.wakedt.visual.domain.application.applicationversion.ApplicationVersionRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 新增应用版本-指令处理器
 *
 * @author zhuxueliang
 */
@Component
public class ApplicationVersionCreateCmdHandler {

    @Resource
    private ApplicationVersionRepository repository;
    @Resource
    private ApplicationVersionFactory factory;

    public Long handle(ApplicationVersionCreateCmd createCmd) {
        ApplicationVersion applicationVersion = factory.getInstance(createCmd);

        // 校验版本号
        applicationVersion.checkLegalVersion();
        // 校验应用是否存在
        repository.checkExistApplicationId(applicationVersion);
        // 当前应用下版本号唯一
        repository.checkRepeatedApplicationVersion(applicationVersion);
        ApplicationVersion newVersion = repository.save(applicationVersion);

//        DomainEventPublisher.getInstance().postAfterCommit(new ApplicationVersionCreateCmdEvent(createCmd));
        return newVersion.getId();
    }
}