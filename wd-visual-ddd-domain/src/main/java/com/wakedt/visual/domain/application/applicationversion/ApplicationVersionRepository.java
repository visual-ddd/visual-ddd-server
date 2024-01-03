package com.wakedt.visual.domain.application.applicationversion;

import java.util.Set;
import java.util.zip.ZipOutputStream;

/**
 * 应用版本-聚合根-仓储接口
 *
 * @author zhuxueliang
 */
public interface ApplicationVersionRepository {

    ApplicationVersion save(ApplicationVersion applicationVersion);

    ApplicationVersion update(ApplicationVersion applicationVersion);

    void remove(ApplicationVersion applicationVersion);

    ApplicationVersion find(Long id);

    /**
     * 校验当前应用下版本号是否重复
     *
     * @param applicationVersion 应用版本号
     */
    void checkRepeatedApplicationVersion(ApplicationVersion applicationVersion);

    /**
     * 校验应用是否存在
     *
     * @param applicationVersion 应用版本号
     */
    void checkExistApplicationId(ApplicationVersion applicationVersion);

    /**
     * 校验业务域是否重复绑定
     *
     * @param applicationVersion 应用版本号
     */
    void checkBindRepeatedDomainDesignVersion(ApplicationVersion applicationVersion);

    /**
     * 校验业务场景是否重复绑定
     *
     * @param applicationVersion 应用版本号
     */
    void checkBindRepeatedBusinessSceneVersion(ApplicationVersion applicationVersion);

    /**
     * 校验业务场景是否存在
     *
     * @param applicationVersion 应用版本号
     */
    void checkExistBusinessSceneVersionVersionIds(ApplicationVersion applicationVersion);

    /**
     * 校验业务域是否存在
     *
     * @param applicationVersion 应用版本号
     */
    void checkExistDomainDesignVersionIds(ApplicationVersion applicationVersion);

    /**
     * 未发布的业务场景同一个版本只能关联一个应用
     */
    void checkUnpublishedBSVersionHasBindOther(ApplicationVersion applicationVersion, Set<Long> oldBusinessSceneVersionIds);

    /**
     * 未发布的业务域同一个版本只能关联一个应用
     */
    void checkUnpublishedDDVersionHasBindOther(ApplicationVersion applicationVersion, Set<Long> oldDomainDesignIds);

    /**
     * 根据应用版本信息生成代码，并返回到输出流中
     *
     * @param applicationVersion 应用版本信息
     * @param outputStream 压缩流
     */
    void generateCode(ApplicationVersion applicationVersion, ZipOutputStream outputStream);
}
