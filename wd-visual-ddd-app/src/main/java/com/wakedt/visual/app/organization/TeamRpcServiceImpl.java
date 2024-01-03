package com.wakedt.visual.app.organization;

import com.wakedata.common.core.dto.ResultDTO;
import com.wakedt.visual.app.organization.assembler.*;
import com.wakedt.visual.app.organization.view.TeamDetailQueryExe;
import com.wakedt.visual.app.organization.view.TeamPageQueryExe;
import com.wakedt.visual.client.organization.TeamRpcService;
import com.wakedt.visual.client.organization.dto.*;
import com.wakedt.visual.client.organization.query.TeamDetailQuery;
import com.wakedt.visual.client.organization.query.TeamPageQuery;
import com.wakedt.visual.domain.organization.team.create.TeamCreateCmd;
import com.wakedt.visual.domain.organization.team.create.TeamCreateCmdHandler;
import com.wakedt.visual.domain.organization.team.managerbind.TeamManagerBindCmd;
import com.wakedt.visual.domain.organization.team.managerbind.TeamManagerBindCmdHandler;
import com.wakedt.visual.domain.organization.team.managerunbind.TeamManagerUnbindCmd;
import com.wakedt.visual.domain.organization.team.managerunbind.TeamManagerUnbindCmdHandler;
import com.wakedt.visual.domain.organization.team.remove.TeamRemoveCmd;
import com.wakedt.visual.domain.organization.team.remove.TeamRemoveCmdHandler;
import com.wakedt.visual.domain.organization.team.update.TeamUpdateCmd;
import com.wakedt.visual.domain.organization.team.update.TeamUpdateCmdHandler;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 团队-聚合根-RPC能力接口实现
 *
 * @author zhuxueliang
 */
@Service
public class TeamRpcServiceImpl implements TeamRpcService {

    @Resource
    private TeamCreateCmdHandler teamCreateCmdHandler;
    @Resource
    private TeamUpdateCmdHandler teamUpdateCmdHandler;
    @Resource
    private TeamRemoveCmdHandler teamRemoveCmdHandler;
    @Resource
    private TeamManagerBindCmdHandler teamManagerBindCmdHandler;
    @Resource
    private TeamManagerUnbindCmdHandler teamManagerUnbindCmdHandler;
    @Resource
    private TeamPageQueryExe teamPageQueryExe;
    @Resource
    private TeamDetailQueryExe teamDetailQueryExe;


    @Override
    public ResultDTO<Boolean> teamCreate(TeamCreateDTO teamCreateDto) {
        TeamCreateCmd teamCreateCmd =
            TeamCreateDTOConvert.INSTANCE.dto2Do(teamCreateDto);
        teamCreateCmdHandler.handle(teamCreateCmd);
        return ResultDTO.success(Boolean.TRUE);
    }

    @Override
    public ResultDTO<Boolean> teamUpdate(TeamUpdateDTO teamUpdateDto) {
        TeamUpdateCmd teamUpdateCmd =
            TeamUpdateDTOConvert.INSTANCE.dto2Do(teamUpdateDto);
        teamUpdateCmdHandler.handle(teamUpdateCmd);
        return ResultDTO.success(Boolean.TRUE);
    }

    @Override
    public ResultDTO<Boolean> teamRemove(TeamRemoveDTO teamRemoveDto) {
        TeamRemoveCmd teamRemoveCmd =
            TeamRemoveDTOConvert.INSTANCE.dto2Do(teamRemoveDto);
        teamRemoveCmdHandler.handle(teamRemoveCmd);
        return ResultDTO.success(Boolean.TRUE);
    }

    @Override
    public ResultDTO<Boolean> teamManagerBind(TeamManagerBindDTO teamManagerBindDto) {
        TeamManagerBindCmd teamManagerBindCmd =
            TeamManagerBindDTOConvert.INSTANCE.dto2Do(teamManagerBindDto);
        teamManagerBindCmdHandler.handle(teamManagerBindCmd);
        return ResultDTO.success(Boolean.TRUE);
    }

    @Override
    public ResultDTO<Boolean> teamManagerUnbind(TeamManagerUnbindDTO teamManagerUnbindDto) {
        TeamManagerUnbindCmd teamManagerUnbindCmd =
            TeamManagerUnbindDTOConvert.INSTANCE.dto2Do(teamManagerUnbindDto);
        teamManagerUnbindCmdHandler.handle(teamManagerUnbindCmd);
        return ResultDTO.success(Boolean.TRUE);
    }

    @Override
    public ResultDTO<TeamDTO> teamDetailQuery(TeamDetailQuery query) {
        return teamDetailQueryExe.execute(query);
    }

    @Override
    public ResultDTO<List<TeamDTO>> teamPageQuery(TeamPageQuery pageQuery) {
        return teamPageQueryExe.execute(pageQuery);
    }

}