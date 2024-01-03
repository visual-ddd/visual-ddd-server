package com.wakedt.visual.infrastructure.domaindesign.repository.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wakedt.visual.client.domaindesign.query.DomainDesignDetailQuery;
import com.wakedt.visual.client.domaindesign.query.DomainDesignListQuery;
import com.wakedt.visual.client.domaindesign.query.DomainDesignPageQuery;
import com.wakedt.visual.infrastructure.domaindesign.repository.model.DomainDesignDO;
import com.wakedt.visual.infrastructure.domaindesign.repository.model.DomainDesignVersionDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 业务域Mapper接口
 *
 * @author zhuxueliang
 */
@Mapper
public interface DomainDesignMapper extends BaseMapper<DomainDesignDO> {

    /**
    * 查询业务域详情
    */
    DomainDesignDO domainDesignDetailQuery(DomainDesignDetailQuery query);

    /**
     * 查询业务域列表详情
     */
    List<DomainDesignDO> domainDesignListQuery(DomainDesignListQuery query);

    /**
     * 分页查询业务域信息
     */
    List<DomainDesignDO> domainDesignPageQuery(DomainDesignPageQuery pageQuery);

    /**
     * 查询应用关联的业务域信息列表，不包含DSL
     *
     * @param domainDesignVersionIds 关联的领域版本ID列表
     * @return 关联的业务域信息列表
     */
    List<DomainDesignVersionDO> selectBindBusinessSceneInfoList(List<Long> domainDesignVersionIds);
}