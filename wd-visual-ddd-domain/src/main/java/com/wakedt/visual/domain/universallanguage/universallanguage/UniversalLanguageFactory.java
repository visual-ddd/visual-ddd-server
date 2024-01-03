package com.wakedt.visual.domain.universallanguage.universallanguage;

import com.wakedt.visual.domain.universallanguage.universallanguage.create.UniversalLanguageAddCmd;
import org.springframework.stereotype.Component;

/**
 * 统一语言-聚合根-工厂
 *
 * @author zhuxueliang
 */
@Component
public class UniversalLanguageFactory {

    public UniversalLanguage getInstance(UniversalLanguageAddCmd createCmd) {
        UniversalLanguage instance = new UniversalLanguage();
        instance.setConception(createCmd.getConception());
        instance.setEnglishName(createCmd.getEnglishName());
        instance.setDefinition(createCmd.getDefinition());
        instance.setRestraint(createCmd.getRestraint());
        instance.setLanguageType(createCmd.getLanguageType());
        instance.setIdentity(createCmd.getIdentity());
        instance.setExample(createCmd.getExample());
        return instance;
    }

}
