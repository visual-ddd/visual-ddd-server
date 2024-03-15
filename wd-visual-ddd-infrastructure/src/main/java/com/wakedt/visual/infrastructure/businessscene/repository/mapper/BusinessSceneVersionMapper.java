package com.wakedt.visual.infrastructure.businessscene.repository.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wakedt.visual.client.businessscene.query.BusinessSceneVersionDetailQuery;
import com.wakedt.visual.client.businessscene.query.BusinessSceneVersionPageQuery;
import com.wakedt.visual.infrastructure.businessscene.repository.model.BusinessSceneVersionDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

/**
 * 业务场景版本Mapper接口
 *
 * @author zhuxueliang
 */
@Mapper
public interface BusinessSceneVersionMapper extends BaseMapper<BusinessSceneVersionDO> {

    /**
    * 查询业务场景版本详情
    */
    BusinessSceneVersionDO businessSceneVersionDetailQuery(BusinessSceneVersionDetailQuery query);

    /**
     * 查询业务场景版本简介
     */
    BusinessSceneVersionDO businessSceneVersionSimpleQuery(BusinessSceneVersionDetailQuery query);

    /**
     * 分页查询业务场景版本信息
     */
    List<BusinessSceneVersionDO> businessSceneVersionPageQuery(BusinessSceneVersionPageQuery pageQuery);

    /**
     * 查询应用关联的业务场景列表
     *
     * @param applicationVersionId 应用id
     */
    List<BusinessSceneVersionDO> selectBindBusinessSceneList(@Param("applicationVersionId") Long applicationVersionId);

    /**
     * 批量查询业务场景版本信息，排除DSL
     */
    List<BusinessSceneVersionDO> selectBatchIdsExcludeDsl(@Param("businessSceneVersionIds") List<Long> businessSceneVersionIds);

    /**
     * 查询关联id列表
     */
    List<Long> selectBindIds(@Param("businessSceneVersionIds") Set<Long> businessSceneVersionIds);
}