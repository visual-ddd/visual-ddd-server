package com.wakedt.visual.domain.application.applicationversion.businesssceneversionbind;

import com.wakedt.visual.domain.application.applicationversion.ApplicationVersion;
import com.wakedt.visual.domain.application.applicationversion.ApplicationVersionRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Set;

/**
 * 关联业务场景版本-指令处理器
 *
 * @author zhuxueliang
 */
@Component
public class BusinessSceneVersionBindCmdHandler {

    @Resource
    private ApplicationVersionRepository repository;

    public void handle(BusinessSceneVersionBindCmd updateCmd) {
        ApplicationVersion applicationVersion = repository.find(updateCmd.getId());
        Set<Long> oldBusinessSceneVersionIds = applicationVersion.getBusinessSceneVersionIds();
        applicationVersion.businessSceneVersionBind(updateCmd);

        // 校验业务场景版本号是否存在
        repository.checkExistBusinessSceneVersionVersionIds(applicationVersion);

        // 同一业务场景只能关联一个版本号
        repository.checkBindRepeatedBusinessSceneVersion(applicationVersion);

        // 未发布的业务同一个版本只能关联一个应用
        repository.checkUnpublishedBSVersionHasBindOther(applicationVersion, oldBusinessSceneVersionIds);
        repository.update(applicationVersion);

//        DomainEventPublisher.getInstance().postAfterCommit(new BusinessSceneVersionBindCmdEvent(updateCmd));
    }
}