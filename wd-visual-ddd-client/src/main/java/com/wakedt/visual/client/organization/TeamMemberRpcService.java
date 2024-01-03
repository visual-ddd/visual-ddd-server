package com.wakedt.visual.client.organization;

import com.wakedata.common.core.dto.ResultDTO;
import com.wakedt.visual.client.organization.dto.*;
import com.wakedt.visual.client.organization.query.TeamMemberByTeamIdPageQuery;

import java.util.List;

/**
 * 团队成员-聚合根-RPC能力接口
 *
 * @author zhuxueliang
 */
public interface TeamMemberRpcService {

    /**
    * 添加团队成员
    */
    ResultDTO<Boolean> teamMemberAdd(TeamMemberAddDTO teamMemberAddDto);

    /**
    * 绑定团队成员职位
    */
    ResultDTO<Boolean> teamMemberRoleBind(TeamMemberRoleBindDTO teamMemberRoleBindDto);

    /**
    * 解绑团队成员职位
    */
    ResultDTO<Boolean> teamMemberRoleUnbind(TeamMemberRoleUnbindDTO teamMemberRoleUnbindDto);

    /**
    * 删除团队成员
    */
    ResultDTO<Boolean> teamMemberRemove(TeamMemberRemoveDTO teamMemberRemoveDto);

    /**
     * 查询团队下的成员信息
     */
    ResultDTO<List<TeamMemberDTO>> teamMemberByTeamIdPageQuery(TeamMemberByTeamIdPageQuery pageQuery);

}