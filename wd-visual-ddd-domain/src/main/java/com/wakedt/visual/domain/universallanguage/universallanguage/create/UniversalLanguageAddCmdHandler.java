package com.wakedt.visual.domain.universallanguage.universallanguage.create;

import com.wakedt.visual.domain.universallanguage.universallanguage.UniversalLanguage;
import com.wakedt.visual.domain.universallanguage.universallanguage.UniversalLanguageFactory;
import com.wakedt.visual.domain.universallanguage.universallanguage.UniversalLanguageRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 新增统一语言-指令处理器
 *
 * @author zhuxueliang
 */
@Component
public class UniversalLanguageAddCmdHandler {

    @Resource
    private UniversalLanguageRepository repository;
    @Resource
    private UniversalLanguageFactory factory;

    public Long handle(UniversalLanguageAddCmd createCmd) {
        UniversalLanguage universalLanguage = factory.getInstance(createCmd);
        UniversalLanguage save = repository.save(universalLanguage);

//        DomainEventPublisher.getInstance().postAfterCommit(new UniversalLanguageAddCmdEvent(createCmd));
        return save.getId();
    }
}