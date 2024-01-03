package com.wakedt.visual.infrastructure.businessscene.repository.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wakedt.visual.client.businessscene.query.BusinessSceneDetailQuery;
import com.wakedt.visual.client.businessscene.query.BusinessSceneListQuery;
import com.wakedt.visual.client.businessscene.query.BusinessScenePageQuery;
import com.wakedt.visual.infrastructure.businessscene.repository.model.BusinessSceneDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 业务场景Mapper接口
 *
 * @author zhuxueliang
 */
@Mapper
public interface BusinessSceneMapper extends BaseMapper<BusinessSceneDO> {

    /**
    * 查询业务场景详情
    */
    BusinessSceneDO businessSceneDetailQuery(BusinessSceneDetailQuery query);

    /**
     * 查询业务场景列表详情
     */
    List<BusinessSceneDO> businessSceneListQuery(BusinessSceneListQuery query);

    /**
     * 分页查询业务场景信息
     */
    List<BusinessSceneDO> businessScenePageQuery(BusinessScenePageQuery pageQuery);
}