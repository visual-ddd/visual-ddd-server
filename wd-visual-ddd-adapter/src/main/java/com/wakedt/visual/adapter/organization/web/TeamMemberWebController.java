package com.wakedt.visual.adapter.organization.web;

import com.wakedata.common.core.dto.ResultDTO;
import com.wakedt.visual.client.organization.TeamMemberRpcService;
import com.wakedt.visual.client.organization.dto.*;
import com.wakedt.visual.client.organization.query.TeamMemberByTeamIdPageQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * 团队成员-web-controller
 *
 * @author zhuxueliang
 */
@RestController
@RequestMapping("/web/team-member")
@Api(value = "/web/team-member", tags = "B端-团队成员")
public class TeamMemberWebController {

    @Resource
    private TeamMemberRpcService teamMemberRpcService;


    @ApiOperation("添加团队成员")
    @PostMapping("/team-member-add")
    public ResultDTO<Boolean> teamMemberAdd(@RequestBody @Valid TeamMemberAddDTO dto) {
        return teamMemberRpcService.teamMemberAdd(dto);
    }

    @ApiOperation("绑定团队成员职位")
    @PostMapping("/team-member-role-bind")
    public ResultDTO<Boolean> teamMemberRoleBind(@RequestBody @Valid TeamMemberRoleBindDTO dto) {
        return teamMemberRpcService.teamMemberRoleBind(dto);
    }

    @ApiOperation("解绑团队成员职位")
    @PostMapping("/team-member-role-unbind")
    public ResultDTO<Boolean> teamMemberRoleUnbind(@RequestBody @Valid TeamMemberRoleUnbindDTO dto) {
        return teamMemberRpcService.teamMemberRoleUnbind(dto);
    }

    @ApiOperation("删除团队成员")
    @PostMapping("/team-member-remove")
    public ResultDTO<Boolean> teamMemberRemove(@RequestBody @Valid TeamMemberRemoveDTO dto) {
        return teamMemberRpcService.teamMemberRemove(dto);
    }

    @ApiOperation("查询团队下的成员信息")
    @GetMapping("/team-member-by-team-id-page-query")
    public ResultDTO<List<TeamMemberDTO>> teamMemberByTeamIdPageQuery(TeamMemberByTeamIdPageQuery pageQuery) {
        return teamMemberRpcService.teamMemberByTeamIdPageQuery(pageQuery);
     }
}


