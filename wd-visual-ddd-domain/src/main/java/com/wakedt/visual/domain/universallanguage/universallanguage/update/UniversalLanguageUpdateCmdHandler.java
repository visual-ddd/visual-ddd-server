package com.wakedt.visual.domain.universallanguage.universallanguage.update;

import com.wakedt.visual.domain.universallanguage.universallanguage.UniversalLanguage;
import com.wakedt.visual.domain.universallanguage.universallanguage.UniversalLanguageRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 更新统一语言-指令处理器
 *
 * @author zhuxueliang
 */
@Component
public class UniversalLanguageUpdateCmdHandler {

    @Resource
    private UniversalLanguageRepository repository;

    public void handle(UniversalLanguageUpdateCmd updateCmd) {
        UniversalLanguage universalLanguage = repository.find(updateCmd.getId());
        universalLanguage.update(updateCmd);
        repository.update(universalLanguage);

//        DomainEventPublisher.getInstance().postAfterCommit(new UniversalLanguageUpdateCmdEvent(updateCmd));
    }
}