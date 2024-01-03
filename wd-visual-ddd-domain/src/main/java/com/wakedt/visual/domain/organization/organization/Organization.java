package com.wakedt.visual.domain.organization.organization;

import com.wakedt.visual.domain.organization.organization.managerbind.OrganizationManagerBindCmd;
import com.wakedt.visual.domain.organization.organization.managerunbind.OrganizationManagerUnbindCmd;
import com.wakedt.visual.domain.organization.organization.remove.OrganizationRemoveCmd;
import com.wakedt.visual.domain.organization.organization.update.OrganizationUpdateCmd;

/**
 * 组织-聚合根-能力
 *
 * @author zhuxueliang
 */
public class Organization extends AbstractOrganization {

    public void update(OrganizationUpdateCmd updateCmd) {
        this.setId(updateCmd.getId());
        this.setName(updateCmd.getName());
        this.setDescription(updateCmd.getDescription());
        this.setOrganizationManagerId(updateCmd.getOrganizationManagerId());
    }

    public void remove(OrganizationRemoveCmd removeCmd) {
        this.setId(removeCmd.getId());
    }

    public void managerBind(OrganizationManagerBindCmd updateCmd) {
        this.setId(updateCmd.getId());
        this.setOrganizationManagerId(updateCmd.getOrganizationManagerId());
    }

    public void managerUnbind(OrganizationManagerUnbindCmd updateCmd) {
        this.setId(updateCmd.getId());
        this.setOrganizationManagerId(-1L);
    }

}