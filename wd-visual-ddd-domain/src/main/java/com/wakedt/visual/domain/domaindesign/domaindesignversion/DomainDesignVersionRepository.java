package com.wakedt.visual.domain.domaindesign.domaindesignversion;

/**
 * 业务域版本-聚合根-仓储接口
 *
 * @author zhuxueliang
 */
public interface DomainDesignVersionRepository {

    /**
     * 新增业务域版本
     *
     * @param domainDesignVersion 新增业务域版本入参
     * @return 业务域版本
     */
    DomainDesignVersion save(DomainDesignVersion domainDesignVersion);

    /**
     * 更新业务域版本
     *
     * @param domainDesignVersion 更新业务域版本入参
     * @return 业务域版本
     */
    DomainDesignVersion update(DomainDesignVersion domainDesignVersion);

    /**
     * 删除业务域版本
     *
     * @param domainDesignVersion 删除业务域版本入参
     */
    void remove(DomainDesignVersion domainDesignVersion);

    /**
     * 根据id查询业务域版本
     *
     * @param id
     * @return 业务域版本
     */
    DomainDesignVersion find(Long id);

    /**
     * 校验当前业务域下版本号是否唯一
     *
     * @param domainDesignVersion 业务域版本
     */
    void checkDomainVersionIdentityUnique(DomainDesignVersion domainDesignVersion);

    /**
     * 校验当前业务域是否存在
     *
     * @param domainDesignVersion 业务域版本
     */
    void checkCurrentDomainDesignExit(DomainDesignVersion domainDesignVersion);

    /**
     * 校验当前业务域版本是否
     *
     * @param domainDesignVersion 业务域版本
     */
    void checkDomainVersionBindApplication(DomainDesignVersion domainDesignVersion);
}
