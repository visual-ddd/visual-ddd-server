package com.wakedt.visual.domain.businessscene.businesssceneversion.create;

import com.wakedt.visual.domain.businessscene.businesssceneversion.BusinessSceneVersion;
import com.wakedt.visual.domain.businessscene.businesssceneversion.BusinessSceneVersionFactory;
import com.wakedt.visual.domain.businessscene.businesssceneversion.BusinessSceneVersionRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 新增业务场景版本-指令处理器
 *
 * @author zhuxueliang
 */
@Component
public class BusinessSceneVersionCreateCmdHandler {

    @Resource
    private BusinessSceneVersionRepository repository;
    @Resource
    private BusinessSceneVersionFactory factory;

    public Long handle(BusinessSceneVersionCreateCmd createCmd) {
        BusinessSceneVersion businessSceneVersion = factory.getInstance(createCmd);

        // 校验版本号
        businessSceneVersion.checkLegalVersion();
        // 校验业务场景是否存在
        repository.checkExistBusinessSceneId(businessSceneVersion);
        // 当前应用下版本号唯一
        repository.checkRepeatedBusinessSceneVersion(businessSceneVersion);
        BusinessSceneVersion newVersion = repository.save(businessSceneVersion);

//        DomainEventPublisher.getInstance().postAfterCommit(new BusinessSceneVersionCreateCmdEvent(createCmd));
        return newVersion.getId();
    }
}