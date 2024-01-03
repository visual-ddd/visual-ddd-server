package com.wakedt.visual.domain.businessscene.businesssceneversion.versionpblish;

import com.wakedt.visual.domain.businessscene.businesssceneversion.BusinessSceneVersion;
import com.wakedt.visual.domain.businessscene.businesssceneversion.BusinessSceneVersionRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 发布业务场景版本-指令处理器
 *
 * @author zhuxueliang
 */
@Component
public class BusinessSceneVersionPblishCmdHandler {

    @Resource
    private BusinessSceneVersionRepository repository;

    public void handle(BusinessSceneVersionPublishCmd updateCmd) {
        BusinessSceneVersion businessSceneVersion = repository.find(updateCmd.getId());
        businessSceneVersion.versionPublish(updateCmd);
        repository.update(businessSceneVersion);

//        DomainEventPublisher.getInstance().postAfterCommit(new BusinessSceneVersionPblishCmdEvent(updateCmd));
    }
}