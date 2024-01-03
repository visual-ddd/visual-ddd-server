package com.wakedt.visual.domain.prompt.prompt.create;

import com.wakedt.visual.domain.prompt.prompt.Prompt;
import com.wakedt.visual.domain.prompt.prompt.PromptFactory;
import com.wakedt.visual.domain.prompt.prompt.PromptRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 新增提示词-指令处理器
 */
@Component
public class PromptCreateCmdHandler {

    @Resource
    private PromptRepository repository;
    @Resource
    private PromptFactory factory;

    public Long handle(PromptCreateCmd createCmd) {
        Prompt entity = factory.getInstance(createCmd);

        Prompt newEntity = repository.save(entity);

//        DomainEventPublisher.getInstance().postAfterCommit(new PromptCreateEvent(createCmd));
        return newEntity.getId();
    }
}