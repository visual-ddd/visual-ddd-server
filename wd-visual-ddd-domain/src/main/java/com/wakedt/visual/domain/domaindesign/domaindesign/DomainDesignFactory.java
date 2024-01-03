package com.wakedt.visual.domain.domaindesign.domaindesign;

import com.wakedt.visual.domain.domaindesign.domaindesign.create.DomainDesignCreateCmd;
import org.springframework.stereotype.Component;

/**
 * 业务域-聚合根-工厂
 *
 * @author zhuxueliang
 */
@Component
public class DomainDesignFactory {

    public DomainDesign getInstance(DomainDesignCreateCmd createCmd) {
        DomainDesign instance = new DomainDesign();
        instance.setTeamId(createCmd.getTeamId());
        instance.setName(createCmd.getName());
        instance.setIdentity(createCmd.getIdentity());
        instance.setDescription(createCmd.getDescription());
        return instance;
    }

}
