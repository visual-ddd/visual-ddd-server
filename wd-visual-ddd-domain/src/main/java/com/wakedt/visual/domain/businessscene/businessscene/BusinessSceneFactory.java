package com.wakedt.visual.domain.businessscene.businessscene;

import com.wakedt.visual.domain.businessscene.businessscene.create.BusinessSceneCreateCmd;
import org.springframework.stereotype.Component;

/**
 * 业务场景-聚合根-工厂
 *
 * @author zhuxueliang
 */
@Component
public class BusinessSceneFactory {

    public BusinessScene getInstance(BusinessSceneCreateCmd createCmd) {
        BusinessScene instance = new BusinessScene();
        instance.setTeamId(createCmd.getTeamId());
        instance.setName(createCmd.getName());
        instance.setIdentity(createCmd.getIdentity());
        instance.setDescription(createCmd.getDescription());
        return instance;
    }

}
