package com.wakedt.visual.domain.domaindesign.domaindesignversion;

import com.wakedt.visual.domain.domaindesign.domaindesignversion.create.DomainDesignVersionCreateCmd;
import org.springframework.stereotype.Component;

/**
 * 业务域版本-聚合根-工厂
 *
 * @author zhuxueliang
 */
@Component
public class DomainDesignVersionFactory {

    public DomainDesignVersion getInstance(DomainDesignVersionCreateCmd createCmd) {
        DomainDesignVersion instance = new DomainDesignVersion();
        instance.setDomainDesignId(createCmd.getDomainDesignId());
        instance.setStartVersion(createCmd.getStartVersion());
        instance.setCurrentVersion(createCmd.getCurrentVersion());
        instance.setDescription(createCmd.getDescription());
        instance.setState(VersionState.UN_PUBLISHED);
        return instance;
    }

}
