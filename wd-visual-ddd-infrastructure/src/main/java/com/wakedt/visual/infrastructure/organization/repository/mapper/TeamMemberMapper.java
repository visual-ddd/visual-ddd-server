package com.wakedt.visual.infrastructure.organization.repository.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wakedt.visual.client.organization.query.TeamMemberByTeamIdPageQuery;
import com.wakedt.visual.infrastructure.organization.repository.model.TeamMemberDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 团队成员Mapper接口
 *
 * @author zhuxueliang
 */
@Mapper
public interface TeamMemberMapper extends BaseMapper<TeamMemberDO> {

    /**
     * 查询团队下的成员信息
     */
    List<TeamMemberDO> teamMemberByTeamIdPageQuery(TeamMemberByTeamIdPageQuery pageQuery);
}