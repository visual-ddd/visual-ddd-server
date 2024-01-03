package com.wakedt.visual.domain.application.applicationversion.versionpublish;

import com.wakedt.visual.domain.application.applicationversion.ApplicationVersion;
import com.wakedt.visual.domain.application.applicationversion.ApplicationVersionRepository;
import com.wakedt.visual.domain.businessscene.businesssceneversion.BusinessSceneVersion;
import com.wakedt.visual.domain.businessscene.businesssceneversion.BusinessSceneVersionRepository;
import com.wakedt.visual.domain.domaindesign.domaindesignversion.DomainDesignVersion;
import com.wakedt.visual.domain.domaindesign.domaindesignversion.DomainDesignVersionRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 发布应用版本-指令处理器
 *
 * @author zhuxueliang
 */
@Component
public class ApplicationVersionPublishCmdHandler {

    @Resource
    private ApplicationVersionRepository repository;
    @Resource
    private DomainDesignVersionRepository domainDesignVersionRepository;
    @Resource
    private BusinessSceneVersionRepository businessSceneVersionRepository;

    public void handle(ApplicationVersionPublishCmd updateCmd) {
        ApplicationVersion applicationVersion = repository.find(updateCmd.getId());

        // 检查关联的业务场景、业务域是否发布
        checkDependencyPublished(applicationVersion);

        applicationVersion.versionPublish(updateCmd);
        repository.update(applicationVersion);

//        DomainEventPublisher.getInstance().postAfterCommit(new ApplicationVersionPublishCmdEvent(updateCmd));
    }

    /**
     * 检查关联的业务场景、业务域是否发布
     *
     * @param applicationVersion 应用版本聚合信息
     */
    private void checkDependencyPublished(ApplicationVersion applicationVersion) {
        for (Long domainDesignVersionId : applicationVersion.getDomainDesignVersionIds()) {
            DomainDesignVersion domainDesignVersion = domainDesignVersionRepository.find(domainDesignVersionId);
            domainDesignVersion.checkVersionUnPublishedException();
        }

        for (Long businessSceneVersionId : applicationVersion.getBusinessSceneVersionIds()) {
            BusinessSceneVersion businessSceneVersion = businessSceneVersionRepository.find(businessSceneVersionId);
            businessSceneVersion.checkVersionUnPublishedException();
        }
    }
}