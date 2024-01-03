package com.wakedt.visual.domain.businessscene.businessscene.remove;

import com.wakedt.visual.domain.businessscene.businessscene.BusinessScene;
import com.wakedt.visual.domain.businessscene.businessscene.BusinessSceneRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 删除业务场景-指令处理器
 *
 * @author zhuxueliang
 */
@Component
public class BusinessSceneRemoveCmdHandler {

    @Resource
    private BusinessSceneRepository repository;

    public void handle(BusinessSceneRemoveCmd removeCmd) {
        BusinessScene businessScene = repository.find(removeCmd.getId());
        businessScene.remove(removeCmd);
        repository.remove(businessScene);

//        DomainEventPublisher.getInstance().postAfterCommit(new BusinessSceneRemoveCmdEvent(removeCmd));
    }
}