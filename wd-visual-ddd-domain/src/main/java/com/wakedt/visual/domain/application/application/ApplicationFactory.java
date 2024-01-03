package com.wakedt.visual.domain.application.application;

import com.wakedt.visual.domain.application.application.create.ApplicationCreateCmd;
import org.springframework.stereotype.Component;

/**
 * 应用-聚合根-工厂
 *
 * @author zhuxueliang
 */
@Component
public class ApplicationFactory {

    public Application getInstance(ApplicationCreateCmd createCmd) {
        Application instance = new Application();
        instance.setTeamId(createCmd.getTeamId());
        instance.setName(createCmd.getName());
        instance.setIdentity(createCmd.getIdentity());
        instance.setPackageName(createCmd.getPackageName());
        instance.setDescription(createCmd.getDescription());
        return instance;
    }

}
