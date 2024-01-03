package com.wakedt.visual.domain.prompt.prompt.modify;

import com.wakedt.visual.domain.prompt.prompt.Prompt;
import com.wakedt.visual.domain.prompt.prompt.PromptRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 编辑提示词-指令处理器
 */
@Component
public class PromptModifyCmdHandler {

    @Resource
    private PromptRepository repository;

    public void handle(PromptModifyCmd updateCmd) {
        Prompt prompt = repository.find(updateCmd.getId());
        prompt.modify(updateCmd);

        repository.update(prompt);

//        DomainEventPublisher.getInstance().postAfterCommit(new PromptModifyEvent(updateCmd));
    }
}