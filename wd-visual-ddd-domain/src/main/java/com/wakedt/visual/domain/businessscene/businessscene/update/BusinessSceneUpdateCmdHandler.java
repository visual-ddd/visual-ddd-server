package com.wakedt.visual.domain.businessscene.businessscene.update;

import com.wakedt.visual.domain.businessscene.businessscene.BusinessScene;
import com.wakedt.visual.domain.businessscene.businessscene.BusinessSceneRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 更新业务场景-指令处理器
 *
 * @author zhuxueliang
 */
@Component
public class BusinessSceneUpdateCmdHandler {

    @Resource
    private BusinessSceneRepository repository;

    public void handle(BusinessSceneUpdateCmd updateCmd) {
        BusinessScene businessScene = repository.find(updateCmd.getId());
        businessScene.update(updateCmd);
        repository.update(businessScene);

//        DomainEventPublisher.getInstance().postAfterCommit(new BusinessSceneUpdateCmdEvent(updateCmd));
    }
}