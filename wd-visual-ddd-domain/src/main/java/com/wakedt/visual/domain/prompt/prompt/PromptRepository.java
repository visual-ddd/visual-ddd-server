package com.wakedt.visual.domain.prompt.prompt;

/**
 * ChatGpt提示词的领域-聚合根-仓储接口
 */
public interface PromptRepository {

    Prompt save(Prompt prompt);

    Prompt update(Prompt prompt);

    void remove(Prompt prompt);

    Prompt find(Long id);

}
