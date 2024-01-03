package com.wakedt.visual.infrastructure.organization.repository.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wakedt.visual.client.organization.query.OrganizationDetailQuery;
import com.wakedt.visual.client.organization.query.OrganizationPageQuery;
import com.wakedt.visual.infrastructure.organization.repository.model.OrganizationDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 组织Mapper接口
 *
 * @author zhuxueliang
 */
@Mapper
public interface OrganizationMapper extends BaseMapper<OrganizationDO> {

    /**
     * 查询组织详情
     */
    OrganizationDO organizationDetailQuery(OrganizationDetailQuery query);

    /**
     * 分页查询组织信息
     */
    List<OrganizationDO> organizationPageQuery(OrganizationPageQuery pageQuery);

    /**
     * 根据用户查询组织信息列表
     */
    List<OrganizationDO> organizationInfoByAccountId(Long accountId);
}