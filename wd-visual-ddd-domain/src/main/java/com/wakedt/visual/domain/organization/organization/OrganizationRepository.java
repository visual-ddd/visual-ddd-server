package com.wakedt.visual.domain.organization.organization;

/**
 * 组织-聚合根-仓储接口
 *
 * @author zhuxueliang
 */
public interface OrganizationRepository {

    Organization save(Organization organization);

    Organization update(Organization organization);

    void remove(Organization organization);

    Organization find(Long id);

    /**
     * 校验名称是否重复
     *
     * @param organization 组织
     */
    void checkRepeatedName(Organization organization);

    /**
     * 检查组织下是否存在团队
     * @param organization 组织
     */
    void checkExistTeam(Organization organization);

}
