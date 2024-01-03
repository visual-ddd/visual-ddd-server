package com.wakedt.visual.domain.universallanguage.universallanguage.delete;

import com.wakedt.visual.domain.universallanguage.universallanguage.UniversalLanguage;
import com.wakedt.visual.domain.universallanguage.universallanguage.UniversalLanguageRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 删除统一语言-指令处理器
 *
 * @author zhuxueliang
 */
@Component
public class UniversalLanguageDeleteCmdHandler {

    @Resource
    private UniversalLanguageRepository repository;

    public void handle(UniversalLanguageDeleteCmd removeCmd) {
        UniversalLanguage universalLanguage = repository.find(removeCmd.getId());
        universalLanguage.delete(removeCmd);
        repository.remove(universalLanguage);

//        DomainEventPublisher.getInstance().postAfterCommit(new UniversalLanguageDeleteCmdEvent(removeCmd));
    }
}