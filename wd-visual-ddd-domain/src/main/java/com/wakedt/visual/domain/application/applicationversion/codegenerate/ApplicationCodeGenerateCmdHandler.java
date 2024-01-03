package com.wakedt.visual.domain.application.applicationversion.codegenerate;

import com.wakedt.visual.domain.application.applicationversion.ApplicationVersion;
import com.wakedt.visual.domain.application.applicationversion.ApplicationVersionRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 生成应用代码-指令处理器
 *
 * @author zhuxueliang
 */
@Component
public class ApplicationCodeGenerateCmdHandler {

    @Resource
    private ApplicationVersionRepository repository;

    public void handle(ApplicationCodeGenerateCmd updateCmd) {
        ApplicationVersion applicationVersion = repository.find(updateCmd.getId());
        applicationVersion.codeGenerate(updateCmd);
        repository.generateCode(applicationVersion, updateCmd.getOutputStream());

//        DomainEventPublisher.getInstance().postAfterCommit(new ApplicationCodeGenerateCmdEvent(updateCmd));
    }
}