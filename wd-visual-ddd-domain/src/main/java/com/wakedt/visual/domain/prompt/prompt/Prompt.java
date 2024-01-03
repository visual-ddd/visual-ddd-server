package com.wakedt.visual.domain.prompt.prompt;

import com.wakedt.visual.domain.prompt.prompt.modify.PromptModifyCmd;
import com.wakedt.visual.domain.prompt.prompt.remove.PromptRemoveCmd;

/**
 * ChatGpt提示词的领域-聚合根能力
 */
public class Prompt extends AbstractPrompt {

    public void modify(PromptModifyCmd updateCmd) {
        this.setId(updateCmd.getId());
        this.setName(updateCmd.getName());
        this.setDescription(updateCmd.getDescription());
        this.setIntroduction(updateCmd.getIntroduction());
        this.setSystem(updateCmd.getSystem());
        this.setAuthor(updateCmd.getAuthor());
        this.setCategory(updateCmd.getCategory());
        this.setDate(updateCmd.getDate());
        this.setTemperature(updateCmd.getTemperature());
        this.setMaxContextLength(updateCmd.getMaxContextLength());
    }

    public void remove(PromptRemoveCmd removeCmd) {
        this.setId(removeCmd.getId());
    }
}