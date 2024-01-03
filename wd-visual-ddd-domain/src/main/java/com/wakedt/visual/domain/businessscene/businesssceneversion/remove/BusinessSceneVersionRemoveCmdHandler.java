package com.wakedt.visual.domain.businessscene.businesssceneversion.remove;

import com.wakedt.visual.domain.businessscene.businesssceneversion.BusinessSceneVersion;
import com.wakedt.visual.domain.businessscene.businesssceneversion.BusinessSceneVersionRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 删除业务场景版本-指令处理器
 *
 * @author zhuxueliang
 */
@Component
public class BusinessSceneVersionRemoveCmdHandler {

    @Resource
    private BusinessSceneVersionRepository repository;

    public void handle(BusinessSceneVersionRemoveCmd removeCmd) {
        BusinessSceneVersion businessSceneVersion = repository.find(removeCmd.getId());

        // 业务场景被应用绑定时，不允许删除
        repository.checkBSVersionBindApplication(businessSceneVersion);
        businessSceneVersion.remove(removeCmd);
        repository.remove(businessSceneVersion);

//        DomainEventPublisher.getInstance().postAfterCommit(new BusinessSceneVersionRemoveCmdEvent(removeCmd));
    }
}