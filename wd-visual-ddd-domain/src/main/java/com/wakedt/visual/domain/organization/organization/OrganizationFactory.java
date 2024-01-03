package com.wakedt.visual.domain.organization.organization;

import com.wakedt.visual.domain.organization.organization.create.OrganizationCreateCmd;
import org.springframework.stereotype.Component;

/**
 * 组织-聚合根-工厂
 *
 * @author zhuxueliang
 */
@Component
public class OrganizationFactory {

    public Organization getInstance(OrganizationCreateCmd createCmd) {
        Organization instance = new Organization();
        instance.setName(createCmd.getName());
        instance.setDescription(createCmd.getDescription());
        instance.setOrganizationManagerId(createCmd.getOrganizationManagerId());
        return instance;
    }

}
