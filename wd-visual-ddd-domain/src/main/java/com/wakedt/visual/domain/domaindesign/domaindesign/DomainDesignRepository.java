package com.wakedt.visual.domain.domaindesign.domaindesign;

/**
 * 业务域-聚合根-仓储接口
 *
 * @author zhuxueliang
 */
public interface DomainDesignRepository {

    /**
     * 新增业务域
     *
     * @param domainDesign 新增业务域参数
     * @return 业务域
     */
    DomainDesign save(DomainDesign domainDesign);

    /**
     * 更新业务域
     *
     * @param domainDesign 更新业务域参数
     * @return 业务域
     */
    DomainDesign update(DomainDesign domainDesign);

    /**
     * 删除业务域
     *
     * @param domainDesign 删除业务域参数
     */
    void remove(DomainDesign domainDesign);

    /**
     * 根据id查询业务域
     *
     * @param id 主键
     * @return 业务域
     */
    DomainDesign find(Long id);

    /**
     * 校验唯一标识是否唯一
     *
     * @param domainDesign 业务域
     */
    void checkRepeatedIdentity(DomainDesign domainDesign);

    /**
     * 校验当前业务域下是否存在版本
     *
     * @param domainDesign 业务域
     */
    void checkExistDomainDesignVersion(DomainDesign domainDesign);
}
