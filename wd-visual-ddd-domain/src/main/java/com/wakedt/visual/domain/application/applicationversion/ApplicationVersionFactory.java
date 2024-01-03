package com.wakedt.visual.domain.application.applicationversion;

import com.wakedt.visual.domain.application.applicationversion.create.ApplicationVersionCreateCmd;
import org.springframework.stereotype.Component;

import java.util.Collections;

/**
 * 应用版本-聚合根-工厂
 *
 * @author zhuxueliang
 */
@Component
public class ApplicationVersionFactory {

    public ApplicationVersion getInstance(ApplicationVersionCreateCmd createCmd) {
        ApplicationVersion instance = new ApplicationVersion();
        instance.setApplicationId(createCmd.getApplicationId());
        instance.setStartVersion(createCmd.getStartVersion());
        instance.setCurrentVersion(createCmd.getCurrentVersion());
        instance.setDescription(createCmd.getDescription());
        instance.setBusinessSceneVersionIds(Collections.emptySet());
        instance.setDomainDesignVersionIds(Collections.emptySet());
        instance.setState(VersionState.UN_PUBLISHED);
        return instance;
    }
}
