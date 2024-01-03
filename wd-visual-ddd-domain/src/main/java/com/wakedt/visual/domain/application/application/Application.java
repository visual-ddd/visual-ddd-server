package com.wakedt.visual.domain.application.application;

import com.wakedt.visual.domain.application.application.remove.ApplicationRemoveCmd;
import com.wakedt.visual.domain.application.application.update.ApplicationUpdateCmd;

/**
 * 应用-聚合根-能力
 *
 * @author zhuxueliang
 */
public class Application extends AbstractApplication {

    public void update(ApplicationUpdateCmd updateCmd) {
        this.setId(updateCmd.getId());
        this.setName(updateCmd.getName());
        this.setPackageName(updateCmd.getPackageName());
        this.setDescription(updateCmd.getDescription());
    }

    public void remove(ApplicationRemoveCmd removeCmd) {

    }

}