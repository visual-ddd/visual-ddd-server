package com.wakedt.visual.infrastructure.application.repository.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wakedt.visual.client.application.query.ApplicationDetailQuery;
import com.wakedt.visual.client.application.query.ApplicationListQuery;
import com.wakedt.visual.client.application.query.ApplicationPageQuery;
import com.wakedt.visual.infrastructure.application.repository.model.ApplicationDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 应用Mapper接口
 *
 * @author zhuxueliang
 */
@Mapper
public interface ApplicationMapper extends BaseMapper<ApplicationDO> {

    /**
    * 查询应用详情
    */
    ApplicationDO applicationDetailQuery(ApplicationDetailQuery query);

    /**
     * 查询应用列表详情
     */
    List<ApplicationDO> applicationListQuery(ApplicationListQuery query);

    /**
     * 分页查询应用信息
     */
    List<ApplicationDO> applicationPageQuery(ApplicationPageQuery pageQuery);
}