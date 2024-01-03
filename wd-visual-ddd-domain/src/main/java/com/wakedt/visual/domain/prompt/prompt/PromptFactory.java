package com.wakedt.visual.domain.prompt.prompt;

import com.wakedt.visual.domain.prompt.prompt.create.PromptCreateCmd;
import org.springframework.stereotype.Component;

/**
 * ChatGpt提示词的领域-聚合根-工厂
 */
@Component
public class PromptFactory {

    public Prompt getInstance(PromptCreateCmd createCmd) {
        Prompt instance = new Prompt();
        instance.setName(createCmd.getName());
        instance.setDescription(createCmd.getDescription());
        instance.setIntroduction(createCmd.getIntroduction());
        instance.setSystem(createCmd.getSystem());
        instance.setAuthor(createCmd.getAuthor());
        instance.setCategory(createCmd.getCategory());
        instance.setDate(createCmd.getDate());
        instance.setTemperature(createCmd.getTemperature());
        instance.setMaxContextLength(createCmd.getMaxContextLength());
        return instance;
    }

}
