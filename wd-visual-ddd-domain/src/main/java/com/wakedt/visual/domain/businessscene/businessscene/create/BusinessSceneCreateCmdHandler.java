package com.wakedt.visual.domain.businessscene.businessscene.create;

import com.wakedt.visual.domain.businessscene.businessscene.BusinessScene;
import com.wakedt.visual.domain.businessscene.businessscene.BusinessSceneFactory;
import com.wakedt.visual.domain.businessscene.businessscene.BusinessSceneRepository;
import com.wakedt.visual.domain.businessscene.businesssceneversion.create.BusinessSceneVersionCreateCmd;
import com.wakedt.visual.domain.businessscene.businesssceneversion.create.BusinessSceneVersionCreateCmdHandler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 新增业务场景-指令处理器
 *
 * @author zhuxueliang
 */
@Component
public class BusinessSceneCreateCmdHandler {

    @Resource
    private BusinessSceneRepository repository;
    @Resource
    private BusinessSceneFactory factory;
    @Resource
    private BusinessSceneVersionCreateCmdHandler businessSceneVersionCreateCmdHandler;

    public Long handle(BusinessSceneCreateCmd createCmd) {
        BusinessScene businessScene = factory.getInstance(createCmd);
        // 标识符唯一
        repository.checkRepeatedIdentity(businessScene);
        BusinessScene newBusinessScene = repository.save(businessScene);

        // 同时初始化起始版本
        String startVersion = createCmd.getStartVersion();
        businessSceneVersionCreateCmdHandler.handle(
                new BusinessSceneVersionCreateCmd(newBusinessScene.getId(), startVersion, startVersion, "起始版本"));

//        DomainEventPublisher.getInstance().postAfterCommit(new BusinessSceneCreateCmdEvent(createCmd));
        return newBusinessScene.getId();
    }
}