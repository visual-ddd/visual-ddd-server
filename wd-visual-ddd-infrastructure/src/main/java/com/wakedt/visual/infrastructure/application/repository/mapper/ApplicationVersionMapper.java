package com.wakedt.visual.infrastructure.application.repository.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wakedt.visual.client.application.query.ApplicationVersionDetailQuery;
import com.wakedt.visual.client.application.query.ApplicationVersionPageQuery;
import com.wakedt.visual.infrastructure.application.repository.model.ApplicationVersionDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;
import java.util.List;

/**
 * 应用版本Mapper接口
 *
 * @author zhuxueliang
 */
@Mapper
public interface ApplicationVersionMapper extends BaseMapper<ApplicationVersionDO> {

    /**
    * 查询应用版本详情
    */
    ApplicationVersionDO applicationVersionDetailQuery(ApplicationVersionDetailQuery query);

    /**
     * 分页查询应用版本信息
     */
    List<ApplicationVersionDO> applicationVersionPageQuery(ApplicationVersionPageQuery pageQuery);

    /**
     * 获取未发布业务场景关联应用的数量
     */
    List<ApplicationVersionDO> selectUnpublishedBSVersionBindCount(@Param("businessSceneVersionIds") Collection<Long> businessSceneVersionIds);

    /**
     * 获取未发布业务域关联应用的数量
     */
    List<ApplicationVersionDO> selectUnpublishedDDVersionBindCount(@Param("domainDesignVersionIds") Collection<Long> domainDesignVersionIds);
}