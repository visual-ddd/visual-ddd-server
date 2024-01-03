package com.wakedt.visual.client.organization;

import com.wakedata.common.core.dto.ResultDTO;
import com.wakedt.visual.client.organization.dto.*;
import com.wakedt.visual.client.organization.query.TeamDetailQuery;
import com.wakedt.visual.client.organization.query.TeamPageQuery;

import java.util.List;

/**
 * 团队-聚合根-RPC能力接口
 *
 * @author zhuxueliang
 */
public interface TeamRpcService {

    /**
    * 创建团队
    */
    ResultDTO<Boolean> teamCreate(TeamCreateDTO teamCreateDto);

    /**
    * 更新团队信息
    */
    ResultDTO<Boolean> teamUpdate(TeamUpdateDTO teamUpdateDto);

    /**
    * 删除团队
    */
    ResultDTO<Boolean> teamRemove(TeamRemoveDTO teamRemoveDto);

    /**
    * 绑定团队管理员
    */
    ResultDTO<Boolean> teamManagerBind(TeamManagerBindDTO teamManagerBindDto);

    /**
    * 解绑团队管理员
    */
    ResultDTO<Boolean> teamManagerUnbind(TeamManagerUnbindDTO teamManagerUnbindDto);

    /**
     * 查询团队详情
     */
    ResultDTO<TeamDTO> teamDetailQuery(TeamDetailQuery query);

    /**
     * 分页查询团队信息
     */
    ResultDTO<List<TeamDTO>> teamPageQuery(TeamPageQuery pageQuery);

}