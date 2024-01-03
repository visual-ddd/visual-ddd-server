package com.wakedt.visual.domain.businessscene.businesssceneversion;

/**
 * 业务场景版本-聚合根-仓储接口
 *
 * @author zhuxueliang
 */
public interface BusinessSceneVersionRepository {

    BusinessSceneVersion save(BusinessSceneVersion businessSceneVersion);

    BusinessSceneVersion update(BusinessSceneVersion businessSceneVersion);

    void remove(BusinessSceneVersion businessSceneVersion);

    BusinessSceneVersion find(Long id);

    /**
     * 校验当前业务场景下版本号是否重复
     *
     * @param businessSceneVersion 业务场景版本
     */
    void checkRepeatedBusinessSceneVersion(BusinessSceneVersion businessSceneVersion);

    /**
     * 校验业务场景是否存在
     *
     * @param businessSceneVersion 业务场景版本
     */
    void checkExistBusinessSceneId(BusinessSceneVersion businessSceneVersion);

    /**
     * 校验业务场景是否被应用绑定
     *
     * @param businessSceneVersion 业务场景版本
     */
    void checkBSVersionBindApplication(BusinessSceneVersion businessSceneVersion);
}
