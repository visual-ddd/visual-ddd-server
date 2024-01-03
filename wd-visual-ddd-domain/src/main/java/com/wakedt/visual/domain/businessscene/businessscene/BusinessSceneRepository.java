package com.wakedt.visual.domain.businessscene.businessscene;

/**
 * 业务场景-聚合根-仓储接口
 *
 * @author zhuxueliang
 */
public interface BusinessSceneRepository {

    BusinessScene save(BusinessScene businessScene);

    BusinessScene update(BusinessScene businessScene);

    void remove(BusinessScene businessScene);

    BusinessScene find(Long id);

    /**
     * 校验当前团队下业务场景标识符是否重复
     *
     * @param businessScene 业务场景
     */
    void checkRepeatedIdentity(BusinessScene businessScene);

    /**
     * 校验当前业务场景下是否存在版本
     *
     * @param businessScene 业务场景
     */
    void checkExistBusinessSceneVersion(BusinessScene businessScene);
}
