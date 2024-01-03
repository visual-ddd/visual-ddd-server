package com.wakedt.visual.adapter.organization.web;

import com.wakedata.common.core.dto.ResultDTO;
import com.wakedt.visual.client.organization.TeamRpcService;
import com.wakedt.visual.client.organization.dto.*;
import com.wakedt.visual.client.organization.query.TeamDetailQuery;
import com.wakedt.visual.client.organization.query.TeamPageQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * 团队-web-controller
 *
 * @author zhuxueliang
 */
@RestController
@RequestMapping("/web/team")
@Api(value = "/web/team", tags = "B端-团队")
public class TeamWebController {

    @Resource
    private TeamRpcService teamRpcService;


    @ApiOperation("创建团队")
    @PostMapping("/team-create")
    public ResultDTO<Boolean> teamCreate(@RequestBody @Valid TeamCreateDTO dto) {
        return teamRpcService.teamCreate(dto);
    }

    @ApiOperation("更新团队信息")
    @PostMapping("/team-update")
    public ResultDTO<Boolean> teamUpdate(@RequestBody @Valid TeamUpdateDTO dto) {
        return teamRpcService.teamUpdate(dto);
    }

    @ApiOperation("删除团队")
    @PostMapping("/team-remove")
    public ResultDTO<Boolean> teamRemove(@RequestBody @Valid TeamRemoveDTO dto) {
        return teamRpcService.teamRemove(dto);
    }

    @ApiOperation("绑定团队管理员")
    @PostMapping("/team-manager-bind")
    public ResultDTO<Boolean> teamManagerBind(@RequestBody @Valid TeamManagerBindDTO dto) {
        return teamRpcService.teamManagerBind(dto);
    }

    @ApiOperation("解绑团队管理员")
    @PostMapping("/team-manager-unbind")
    public ResultDTO<Boolean> teamManagerUnbind(@RequestBody @Valid TeamManagerUnbindDTO dto) {
        return teamRpcService.teamManagerUnbind(dto);
    }

    @ApiOperation("查询团队详情")
    @GetMapping("/team-detail-query")
    public ResultDTO<TeamDTO> teamPageQuery(TeamDetailQuery query) {
        return teamRpcService.teamDetailQuery(query);
    }

    @ApiOperation("分页查询团队信息")
    @GetMapping("/team-page-query")
    public ResultDTO<List<TeamDTO>> teamPageQuery(TeamPageQuery pageQuery) {
        return teamRpcService.teamPageQuery(pageQuery);
     }
}


