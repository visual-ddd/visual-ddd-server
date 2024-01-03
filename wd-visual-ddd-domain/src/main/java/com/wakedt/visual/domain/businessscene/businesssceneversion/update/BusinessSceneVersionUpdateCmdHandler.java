package com.wakedt.visual.domain.businessscene.businesssceneversion.update;

import com.wakedt.visual.domain.businessscene.businesssceneversion.BusinessSceneVersion;
import com.wakedt.visual.domain.businessscene.businesssceneversion.BusinessSceneVersionRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 更新业务场景版本-指令处理器
 *
 * @author zhuxueliang
 */
@Component
public class BusinessSceneVersionUpdateCmdHandler {

    @Resource
    private BusinessSceneVersionRepository repository;

    public void handle(BusinessSceneVersionUpdateCmd updateCmd) {
        BusinessSceneVersion businessSceneVersion = repository.find(updateCmd.getId());
        businessSceneVersion.update(updateCmd);
        repository.update(businessSceneVersion);

//        DomainEventPublisher.getInstance().postAfterCommit(new BusinessSceneVersionUpdateCmdEvent(updateCmd));
    }
}