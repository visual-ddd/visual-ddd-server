package com.wakedt.visual.domain.application.applicationversion;

import com.github.zafarkhaja.semver.ParseException;
import com.github.zafarkhaja.semver.Version;
import com.wakedata.common.core.exception.BizException;
import com.wakedt.visual.domain.application.applicationversion.businesssceneversionbind.BusinessSceneVersionBindCmd;
import com.wakedt.visual.domain.application.applicationversion.codegenerate.ApplicationCodeGenerateCmd;
import com.wakedt.visual.domain.application.applicationversion.domaindesignversionbind.DomainDesignVersionBindCmd;
import com.wakedt.visual.domain.application.applicationversion.remove.ApplicationVersionRemoveCmd;
import com.wakedt.visual.domain.application.applicationversion.update.ApplicationVersionUpdateCmd;
import com.wakedt.visual.domain.application.applicationversion.versionpublish.ApplicationVersionPublishCmd;

/**
 * 应用版本-聚合根-能力
 *
 * @author zhuxueliang
 */
public class ApplicationVersion extends AbstractApplicationVersion {

    @Override
    public void checkVersionPublishedException() {
        if (VersionState.PUBLISHED.equals(this.getState())) {
            throw new BizException("版本已发布，不允许操作！");
        }
    }

    @Override
    public void checkVersionUnPublishedException() {
        if (!VersionState.PUBLISHED.equals(this.getState())) {
            throw new BizException("版本未发布，不允许操作！");
        }
    }

    public void checkHasBindException() {
        if (this.getBusinessSceneVersionIds() != null) {
            throw new BizException("应用下关联了业务场景，不允许操作！");
        }
        if (this.getDomainDesignVersionIds() != null) {
            throw new BizException("应用下关联了业务域，不允许操作！");
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

    public void update(ApplicationVersionUpdateCmd updateCmd) {
        // 当前版本发布后不能再进行任何操作
        checkVersionPublishedException();
        this.setId(updateCmd.getId());
        this.setDescription(updateCmd.getDescription());
    }

    public void remove(ApplicationVersionRemoveCmd removeCmd) {
        // 当前版本发布后不能再进行任何操作
        checkVersionPublishedException();
        // 当前版本发布下关联了业务域或业务场景，不允许删除
        checkHasBindException();
        this.setId(removeCmd.getId());
    }

    public void domainDesignVersionBind(DomainDesignVersionBindCmd updateCmd) {
        // 当前版本发布后不能再进行任何操作
        checkVersionPublishedException();
        this.setId(updateCmd.getId());
        this.setDomainDesignVersionIds(updateCmd.getDomainDesignVersionIds());
    }

    public void businessSceneVersionBind(BusinessSceneVersionBindCmd updateCmd) {
        // 当前版本发布后不能再进行任何操作
        checkVersionPublishedException();
        this.setId(updateCmd.getId());
        this.setBusinessSceneVersionIds(updateCmd.getBusinessSceneVersionIds());
    }

    public void versionPublish(ApplicationVersionPublishCmd updateCmd) {
        // 当前版本发布后不能再进行任何操作
        checkVersionPublishedException();
        this.setId(updateCmd.getId());
        this.setDescription(updateCmd.getDescription());
        this.setState(VersionState.PUBLISHED);
    }

    public void codeGenerate(ApplicationCodeGenerateCmd updateCmd) {
        this.setId(updateCmd.getId());
    }
}