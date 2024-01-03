package com.wakedt.visual.domain.prompt.prompt.remove;

import com.wakedt.visual.domain.prompt.prompt.Prompt;
import com.wakedt.visual.domain.prompt.prompt.PromptRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 删除提示词-指令处理器
 */
@Component
public class PromptRemoveCmdHandler {

    @Resource
    private PromptRepository repository;

    public void handle(PromptRemoveCmd removeCmd) {
        Prompt prompt = repository.find(removeCmd.getId());
        prompt.remove(removeCmd);

        repository.remove(prompt);

//        DomainEventPublisher.getInstance().postAfterCommit(new PromptRemoveEvent(removeCmd));
    }
}