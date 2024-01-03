package com.wakedt.visual.app.organization;

import com.wakedata.common.core.dto.ResultDTO;
import com.wakedt.visual.app.organization.assembler.TeamMemberAddDTOConvert;
import com.wakedt.visual.app.organization.assembler.TeamMemberRemoveDTOConvert;
import com.wakedt.visual.app.organization.assembler.TeamMemberRoleBindDTOConvert;
import com.wakedt.visual.app.organization.assembler.TeamMemberRoleUnbindDTOConvert;
import com.wakedt.visual.app.organization.view.TeamMemberByTeamIdPageQueryExe;
import com.wakedt.visual.client.organization.TeamMemberRpcService;
import com.wakedt.visual.client.organization.dto.*;
import com.wakedt.visual.client.organization.query.TeamMemberByTeamIdPageQuery;
import com.wakedt.visual.domain.organization.teammember.memberadd.TeamMemberAddCmdHandler;
import com.wakedt.visual.domain.organization.teammember.memberremove.TeamMemberRemoveCmd;
import com.wakedt.visual.domain.organization.teammember.memberremove.TeamMemberRemoveCmdHandler;
import com.wakedt.visual.domain.organization.teammember.memberrolebind.TeamMemberRoleBindCmdHandler;
import com.wakedt.visual.domain.organization.teammember.memberroleunbind.TeamMemberRoleUnbindCmd;
import com.wakedt.visual.domain.organization.teammember.memberroleunbind.TeamMemberRoleUnbindCmdHandler;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 团队成员-聚合根-RPC能力接口实现
 *
 * @author zhuxueliang
 */
@Service
public class TeamMemberRpcServiceImpl implements TeamMemberRpcService {

    @Resource
    private TeamMemberAddCmdHandler teamMemberAddCmdHandler;
    @Resource
    private TeamMemberRoleBindCmdHandler teamMemberRoleBindCmdHandler;
    @Resource
    private TeamMemberRoleUnbindCmdHandler teamMemberRoleUnbindCmdHandler;
    @Resource
    private TeamMemberRemoveCmdHandler teamMemberRemoveCmdHandler;
    @Resource
    private TeamMemberByTeamIdPageQueryExe teamMemberByTeamIdPageQueryExe;


    @Override
    public ResultDTO<Boolean> teamMemberAdd(TeamMemberAddDTO dto) {
        teamMemberAddCmdHandler.handle(TeamMemberAddDTOConvert.INSTANCE.dto2Do(dto));
        return ResultDTO.success(Boolean.TRUE);
    }

    @Override
    public ResultDTO<Boolean> teamMemberRoleBind(TeamMemberRoleBindDTO dto) {
        teamMemberRoleBindCmdHandler.handle(TeamMemberRoleBindDTOConvert.INSTANCE.dto2Do(dto));
        return ResultDTO.success(Boolean.TRUE);
    }

    @Override
    public ResultDTO<Boolean> teamMemberRoleUnbind(TeamMemberRoleUnbindDTO teamMemberRoleUnbindDto) {
        TeamMemberRoleUnbindCmd teamMemberRoleUnbindCmd =
            TeamMemberRoleUnbindDTOConvert.INSTANCE.dto2Do(teamMemberRoleUnbindDto);
        teamMemberRoleUnbindCmdHandler.handle(teamMemberRoleUnbindCmd);
        return ResultDTO.success(Boolean.TRUE);
    }

    @Override
    public ResultDTO<Boolean> teamMemberRemove(TeamMemberRemoveDTO teamMemberRemoveDto) {
        TeamMemberRemoveCmd teamMemberRemoveCmd =
            TeamMemberRemoveDTOConvert.INSTANCE.dto2Do(teamMemberRemoveDto);
        teamMemberRemoveCmdHandler.handle(teamMemberRemoveCmd);
        return ResultDTO.success(Boolean.TRUE);
    }

    @Override
    public ResultDTO<List<TeamMemberDTO>> teamMemberByTeamIdPageQuery(TeamMemberByTeamIdPageQuery pageQuery) {
        return teamMemberByTeamIdPageQueryExe.execute(pageQuery);
    }

}