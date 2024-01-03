package com.wakedt.visual.domain.application.applicationversion.domaindesignversionbind;

import com.wakedt.visual.domain.application.applicationversion.ApplicationVersion;
import com.wakedt.visual.domain.application.applicationversion.ApplicationVersionRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Set;

/**
 * 关联业务域版本-指令处理器
 *
 * @author zhuxueliang
 */
@Component
public class DomainDesignVersionBindCmdHandler {

    @Resource
    private ApplicationVersionRepository repository;

    public void handle(DomainDesignVersionBindCmd updateCmd) {
        ApplicationVersion applicationVersion = repository.find(updateCmd.getId());
        Set<Long> oldDomainDesignVersionIds = applicationVersion.getDomainDesignVersionIds();
        applicationVersion.domainDesignVersionBind(updateCmd);

        // 校验业务域版本号是否存在
        repository.checkExistDomainDesignVersionIds(applicationVersion);

        // 同一业务域只能关联一个版本号
        repository.checkBindRepeatedDomainDesignVersion(applicationVersion);

        // 未发布的业务同一个版本只能关联一个应用
        repository.checkUnpublishedDDVersionHasBindOther(applicationVersion, oldDomainDesignVersionIds);
        repository.update(applicationVersion);

//        DomainEventPublisher.getInstance().postAfterCommit(new DomainDesignVersionBindCmdEvent(updateCmd));
    }
}