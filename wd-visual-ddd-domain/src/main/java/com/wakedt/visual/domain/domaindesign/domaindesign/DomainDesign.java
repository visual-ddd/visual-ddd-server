package com.wakedt.visual.domain.domaindesign.domaindesign;

import com.wakedt.visual.domain.domaindesign.domaindesign.remove.DomainDesignRemoveCmd;
import com.wakedt.visual.domain.domaindesign.domaindesign.update.DomainDesignUpdateCmd;

/**
 * 业务域-聚合根-能力
 *
 * @author zhuxueliang
 */
public class DomainDesign extends AbstractDomainDesign {

    public void update(DomainDesignUpdateCmd updateCmd) {
        this.setId(updateCmd.getId());
        this.setName(updateCmd.getName());
        this.setDescription(updateCmd.getDescription());
    }

    public void remove(DomainDesignRemoveCmd removeCmd) {

    }

}