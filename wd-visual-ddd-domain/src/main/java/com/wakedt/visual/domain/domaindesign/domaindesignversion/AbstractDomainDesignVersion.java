package com.wakedt.visual.domain.domaindesign.domaindesignversion;

import com.wakedt.visual.domain.DomainEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 业务域版本-聚合根
 *
 * @author zhuxueliang
 */
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class AbstractDomainDesignVersion extends DomainEntity {

    /**
     * 所属业务域ID
     */
    private Long domainDesignId;

    /**
     * 起始版本号
     */
    private String startVersion;

    /**
     * 当前版本号
     */
    private String currentVersion;

    /**
     * 描述信息
     */
    private String description;

    /**
     * 图形DSL
     */
    private String graphDsl;

    /**
     * 业务域DSL
     */
    private String domainDesignDsl;

    /**
     * 版本状态
     */
    private VersionState state;

    /**
     * 当前版本是否已发布
     */
    public abstract void checkVersionPublishException();

    /**
     * 当前版本是否未发布
     */
    public abstract void checkVersionUnPublishedException();
}