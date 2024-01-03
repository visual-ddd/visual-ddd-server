package com.wakedt.visual.domain.businessscene.businesssceneversion;

import com.wakedt.visual.domain.businessscene.businesssceneversion.create.BusinessSceneVersionCreateCmd;
import org.springframework.stereotype.Component;

/**
 * 业务场景版本-聚合根-工厂
 *
 * @author zhuxueliang
 */
@Component
public class BusinessSceneVersionFactory {

    public BusinessSceneVersion getInstance(BusinessSceneVersionCreateCmd createCmd) {
        BusinessSceneVersion instance = new BusinessSceneVersion();
        instance.setBusinessSceneId(createCmd.getBusinessSceneId());
        instance.setStartVersion(createCmd.getStartVersion());
        instance.setCurrentVersion(createCmd.getCurrentVersion());
        instance.setDescription(createCmd.getDescription());
        instance.setState(VersionState.UN_PUBLISHED);
        return instance;
    }

}
