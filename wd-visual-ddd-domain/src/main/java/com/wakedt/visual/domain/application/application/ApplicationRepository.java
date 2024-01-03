package com.wakedt.visual.domain.application.application;

/**
 * 应用-聚合根-仓储接口
 *
 * @author zhuxueliang
 */
public interface ApplicationRepository {

    Application save(Application application);

    Application update(Application application);

    void remove(Application application);

    Application find(Long id);

    /**
     * 校验当前团队下应用标识符是否重复
     *
     * @param application 应用
     */
    void checkRepeatedIdentity(Application application);

    /**
     * 校验当前应用下是否存在版本
     *
     * @param application 应用
     */
    void checkExistApplicationVersion(Application application);
}
