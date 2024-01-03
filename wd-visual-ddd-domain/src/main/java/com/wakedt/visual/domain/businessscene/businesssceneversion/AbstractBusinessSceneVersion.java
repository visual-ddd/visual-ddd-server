package com.wakedt.visual.domain.businessscene.businesssceneversion;

import com.wakedt.visual.domain.DomainEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 业务场景版本-聚合根
 *
 * @author zhuxueliang
 */
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class AbstractBusinessSceneVersion extends DomainEntity {

    /** 所属业务场景ID */
    private Long businessSceneId;

    /** 起始版本号 */
    private String startVersion;

    /** 当前版本号 */
    private String currentVersion;

    /** 描述信息 */
    private String description;

    /** 业务场景DSL */
    private String dsl;

    /** 图形DSL */
    private String graphDsl;

    /** 版本状态 */
    private VersionState state;

    /** 当前版本是否已发布 */
    public abstract void checkVersionPublishedException();

    /** 当前版本是否未发布 */
    public abstract void checkVersionUnPublishedException();
}