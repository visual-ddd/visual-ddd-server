package com.wakedt.visual.domain.businessscene.businessscene;

import com.wakedt.visual.domain.businessscene.businessscene.remove.BusinessSceneRemoveCmd;
import com.wakedt.visual.domain.businessscene.businessscene.update.BusinessSceneUpdateCmd;

/**
 * 业务场景-聚合根-能力
 *
 * @author zhuxueliang
 */
public class BusinessScene extends AbstractBusinessScene {

    public void update(BusinessSceneUpdateCmd updateCmd) {
        this.setId(updateCmd.getId());
        this.setName(updateCmd.getName());
        this.setDescription(updateCmd.getDescription());
    }

    public void remove(BusinessSceneRemoveCmd removeCmd) {
        this.setId(removeCmd.getId());
    }

}