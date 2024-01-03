package com.wakedt.visual.domain.universallanguage.universallanguage;

import com.wakedt.visual.domain.universallanguage.universallanguage.delete.UniversalLanguageDeleteCmd;
import com.wakedt.visual.domain.universallanguage.universallanguage.update.UniversalLanguageUpdateCmd;

/**
 * 统一语言-聚合根-能力
 *
 * @author zhuxueliang
 */
public class UniversalLanguage extends AbstractUniversalLanguage {

    public void update(UniversalLanguageUpdateCmd updateCmd) {
        this.setId(updateCmd.getId());
        this.setConception(updateCmd.getConception());
        this.setEnglishName(updateCmd.getEnglishName());
        this.setDefinition(updateCmd.getDefinition());
        this.setRestraint(updateCmd.getRestraint());
        this.setExample(updateCmd.getExample());
    }

    public void delete(UniversalLanguageDeleteCmd removeCmd) {

    }

}