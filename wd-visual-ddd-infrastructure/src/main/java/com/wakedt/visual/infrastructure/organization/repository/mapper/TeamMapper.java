package com.wakedt.visual.infrastructure.organization.repository.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wakedt.visual.client.organization.query.TeamDetailQuery;
import com.wakedt.visual.client.organization.query.TeamPageQuery;
import com.wakedt.visual.infrastructure.organization.repository.model.TeamDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 团队Mapper接口
 *
 * @author zhuxueliang
 */
@Mapper
public interface TeamMapper extends BaseMapper<TeamDO> {

    /**
     * 查询团队详情
     */
    TeamDO teamDetailQuery(TeamDetailQuery query);

    /**
     * 分页查询团队信息
     */
    List<TeamDO> teamPageQuery(TeamPageQuery pageQuery);

    /**
     * 根据账号查询所属团队信息列表
     */
    List<TeamDO> teamInfoByAccountId(@Param("accountId") Long accountId);
}