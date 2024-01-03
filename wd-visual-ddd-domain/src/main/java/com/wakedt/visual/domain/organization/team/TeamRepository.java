package com.wakedt.visual.domain.organization.team;

/**
 * 团队-聚合根-仓储接口
 *
 * @author zhuxueliang
 */
public interface TeamRepository {

    Team save(Team team);

    Team update(Team team);

    void remove(Team team);

    Team find(Long id);

    /**
     * 校验名称是否重复
     *
     * @param team 团队
     */
    void checkRepeatedName(Team team);

    /**
     * 检查团队下是否存在应用
     *
     * @param team 团队
     */
    void checkExistApplication(Team team);

    /**
     * 检查团队下是否存在业务场景
     *
     * @param team 团队
     */
    void checkExistBusinessScene(Team team);

    /**
     * 检查团队下是否存在业务域
     *
     * @param team 团队
     */
    void checkExistDomainDesign(Team team);
}
