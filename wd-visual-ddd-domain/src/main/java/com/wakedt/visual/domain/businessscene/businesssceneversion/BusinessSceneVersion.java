package com.wakedt.visual.domain.businessscene.businesssceneversion;

import com.github.zafarkhaja.semver.ParseException;
import com.github.zafarkhaja.semver.Version;
import com.wakedata.common.core.exception.BizException;
import com.wakedt.visual.domain.businessscene.businesssceneversion.dslupdate.BusinessSceneDSLUpdateCmd;
import com.wakedt.visual.domain.businessscene.businesssceneversion.remove.BusinessSceneVersionRemoveCmd;
import com.wakedt.visual.domain.businessscene.businesssceneversion.update.BusinessSceneVersionUpdateCmd;
import com.wakedt.visual.domain.businessscene.businesssceneversion.versionpblish.BusinessSceneVersionPublishCmd;

/**
 * 业务场景版本-聚合根-能力
 *
 * @author zhuxueliang
 */
public class BusinessSceneVersion extends AbstractBusinessSceneVersion {

    @Override
    public void checkVersionPublishedException(){
        if (VersionState.PUBLISHED.equals(this.getState())){
            throw new BizException("版本已发布，不允许操作！");
        }
    }

    @Override
    public void checkVersionUnPublishedException() {
        if (!com.wakedt.visual.domain.application.applicationversion.VersionState.PUBLISHED.equals(this.getState())) {
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

    public void update(BusinessSceneVersionUpdateCmd updateCmd) {
        // 当前版本发布后不能再进行任何操作
        checkVersionPublishedException();
        this.setId(updateCmd.getId());
        this.setDescription(updateCmd.getDescription());
    }

    public void remove(BusinessSceneVersionRemoveCmd removeCmd) {
        // 当前版本发布后不能再进行任何操作
        checkVersionPublishedException();
        this.setId(removeCmd.getId());
    }

    public void versionPublish(BusinessSceneVersionPublishCmd updateCmd) {
        // 当前版本发布后不能再进行任何操作
        checkVersionPublishedException();
        this.setId(updateCmd.getId());
        this.setDescription(updateCmd.getDescription());
        this.setState(VersionState.PUBLISHED);
    }

    public void dSLUpdate(BusinessSceneDSLUpdateCmd updateCmd) {
        // 当前版本发布后不能再进行任何操作
        checkVersionPublishedException();
        this.setId(updateCmd.getId());
        this.setDsl(updateCmd.getDsl());
        this.setGraphDsl(updateCmd.getGraphDsl());
    }

}