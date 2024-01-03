package com.wakedt.visual.domain.businessscene.businesssceneversion.dslupdate;

import com.wakedt.visual.domain.businessscene.businesssceneversion.BusinessSceneVersion;
import com.wakedt.visual.domain.businessscene.businesssceneversion.BusinessSceneVersionRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 更新业务场景DSL-指令处理器
 *
 * @author zhuxueliang
 */
@Component
public class BusinessSceneDSLUpdateCmdHandler {

    @Resource
    private BusinessSceneVersionRepository repository;

    public void handle(BusinessSceneDSLUpdateCmd updateCmd) {
        BusinessSceneVersion businessSceneVersion = repository.find(updateCmd.getId());
        businessSceneVersion.dSLUpdate(updateCmd);
        repository.update(businessSceneVersion);

//        DomainEventPublisher.getInstance().postAfterCommit(new BusinessSceneDslUpdateCmdEvent(updateCmd));
    }
}