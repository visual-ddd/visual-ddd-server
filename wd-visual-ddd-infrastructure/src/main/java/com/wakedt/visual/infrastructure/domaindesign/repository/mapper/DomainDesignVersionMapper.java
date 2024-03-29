package com.wakedt.visual.infrastructure.domaindesign.repository.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wakedt.visual.client.domaindesign.query.DomainDesignVersionDetailQuery;
import com.wakedt.visual.client.domaindesign.query.DomainDesignVersionPageQuery;
import com.wakedt.visual.infrastructure.domaindesign.repository.model.DomainDesignVersionDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

/**
 * 业务域版本Mapper接口
 *
 * @author zhuxueliang
 */
@Mapper
public interface DomainDesignVersionMapper extends BaseMapper<DomainDesignVersionDO> {

    /**
     * 查询业务域版本详情
     *
     * @param query 查询条件
     * @return DomainDesignVersionDO
     */
    DomainDesignVersionDO domainDesignVersionDetailQuery(DomainDesignVersionDetailQuery query);

    /**
     * 查询业务域版本简介
     *
     * @param query 查询条件
     * @return DomainDesignVersionDO
     */
    DomainDesignVersionDO domainDesignVersionSimpleQuery(DomainDesignVersionDetailQuery query);

    /**
     * 分页查询业务域版本信息
     *
     * @param pageQuery 查询条件
     * @return 业务域版本信息List
     */
    List<DomainDesignVersionDO> domainDesignVersionPageQuery(DomainDesignVersionPageQuery pageQuery);

    /**
     * 查询应用关联的业务域列表
     *
     * @param applicationVersionId 应用id
     */
    List<DomainDesignVersionDO> selectBindDomainDesignList(@Param("applicationVersionId") Long applicationVersionId);

    /**
     * 批量查询业务域版本信息，排除DSL
     *
     * @param domainDesignVersionIds 业务域版本id列表
     * @return 业务域版本信息列表
     */
    List<DomainDesignVersionDO> selectBatchIdsExcludeDsl(@Param("domainDesignVersionIds") List<Long> domainDesignVersionIds);

    /**
     * 查询关联id列表
     *
     * @param domainDesignVersionIds 业务域版本id列表
     * @return 关联id列表
     */
    List<Long> selectBindIds(@Param("domainDesignVersionIds") Set<Long> domainDesignVersionIds);
}