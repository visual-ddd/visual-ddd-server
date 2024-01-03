package com.wakedt.visual.domain.application.applicationversion;

import com.wakedt.visual.domain.DomainEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

/**
 * 应用版本-聚合根
 *
 * @author zhuxueliang
 */
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class AbstractApplicationVersion extends DomainEntity {

    /** 所属应用ID */
    private Long applicationId;

    /** 起始版本号 */
    private String startVersion;

    /** 当前版本号 */
    private String currentVersion;

    /** 描述信息 */
    private String description;

    /** 业务域版本ID列表 */
    private Set<Long> domainDesignVersionIds;

    /** 业务场景版本ID列表 */
    private Set<Long> businessSceneVersionIds;

    /** 版本状态 */
    private VersionState state;

    /** 当前版本是否已发布 */
    public abstract void checkVersionPublishedException();

    /** 当前版本是否未发布 */
    public abstract void checkVersionUnPublishedException();
}