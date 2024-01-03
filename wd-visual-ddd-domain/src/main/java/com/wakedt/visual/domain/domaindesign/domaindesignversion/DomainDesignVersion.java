package com.wakedt.visual.domain.domaindesign.domaindesignversion;

import com.github.zafarkhaja.semver.ParseException;
import com.github.zafarkhaja.semver.Version;
import com.google.common.base.Objects;
import com.wakedata.common.core.exception.BizException;
import com.wakedt.visual.domain.domaindesign.domaindesignversion.dslupdate.DomainDesignDslUpdateCmd;
import com.wakedt.visual.domain.domaindesign.domaindesignversion.update.DomainDesignVersionUpdateCmd;
import com.wakedt.visual.domain.domaindesign.domaindesignversion.versionpblish.DomainDesignVersionPublishCmd;

/**
 * 业务域版本-聚合根-能力
 *
 * @author zhuxueliang
 */
public class DomainDesignVersion extends AbstractDomainDesignVersion {

    @Override
    public void checkVersionPublishException() {
        if (Objects.equal(VersionState.PUBLISHED, this.getState())){
            throw new BizException("当前版本发布后不允许进行任何操作");
        }
    }

    @Override
    public void checkVersionUnPublishedException() {
        if (!VersionState.PUBLISHED.equals(this.getState())) {
            throw new BizException("版本未发布，不允许操作！");
        }
    }

    public void checkLegalVersion() {
        try {
            Version.valueOf(this.getStartVersion());
            Version.valueOf(this.getCurrentVersion());
        } catch (ParseException e) {
            throw new BizException("版本号命名不符合标准!");
        }
    }

    public void update(DomainDesignVersionUpdateCmd updateCmd) {
        this.checkVersionPublishException();
        this.setId(updateCmd.getId());
        this.setDescription(updateCmd.getDescription());
    }

    public void remove() {
        this.checkVersionPublishException();
    }

    public void versionPublish(DomainDesignVersionPublishCmd updateCmd) {
        this.checkVersionPublishException();
        this.setDescription(updateCmd.getDescription());
        this.setState(VersionState.PUBLISHED);
    }

    public void dslUpdate(DomainDesignDslUpdateCmd updateCmd) {
        this.checkVersionPublishException();
        this.setId(updateCmd.getId());
        this.setDomainDesignDsl(updateCmd.getDomainDesignDsl());
        this.setGraphDsl(updateCmd.getGraphDsl());
    }

}