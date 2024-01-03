package com.wakedt.visual.adapter.organization.web;

import com.wakedata.common.core.dto.ResultDTO;
import com.wakedt.visual.client.organization.OrganizationRpcService;
import com.wakedt.visual.client.organization.dto.*;
import com.wakedt.visual.client.organization.query.OrganizationDetailQuery;
import com.wakedt.visual.client.organization.query.OrganizationPageQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * 组织-web-controller
 *
 * @author zhuxueliang
 */
@RestController
@RequestMapping("/web/organization")
@Api(value = "/web/organization", tags = "B端-组织")
public class OrganizationWebController {

    @Resource
    private OrganizationRpcService organizationRpcService;


    @ApiOperation("创建组织")
    @PostMapping("/organization-create")
    public ResultDTO<Boolean> organizationCreate(@RequestBody @Valid OrganizationCreateDTO dto) {
        return organizationRpcService.organizationCreate(dto);
    }

    @ApiOperation("更新组织信息")
    @PostMapping("/organization-update")
    public ResultDTO<Boolean> organizationUpdate(@RequestBody @Valid OrganizationUpdateDTO dto) {
        return organizationRpcService.organizationUpdate(dto);
    }

    @ApiOperation(value = "删除组织")
    @PostMapping("/organization-remove")
    public ResultDTO<Boolean> organizationRemove(@RequestBody @Valid OrganizationRemoveDTO dto) {
        return organizationRpcService.organizationRemove(dto);
    }

    @ApiOperation("批量删除组织")
    @PostMapping("/organization-batch-remove")
    public ResultDTO<Boolean> organizationBatchRemove(@RequestBody @Valid OrganizationBatchRemoveDTO dto) {
        return organizationRpcService.organizationBatchRemove(dto);
    }

    @ApiOperation("绑定组织管理员")
    @PostMapping("/organization-manager-bind")
    public ResultDTO<Boolean> organizationManagerBind(@RequestBody @Valid OrganizationManagerBindDTO dto) {
        return organizationRpcService.organizationManagerBind(dto);
    }

    @ApiOperation("解绑组织管理员")
    @PostMapping("/organization-manager-unbind")
    public ResultDTO<Boolean> organizationManagerUnbind(@RequestBody @Valid OrganizationManagerUnbindDTO dto) {
        return organizationRpcService.organizationManagerUnbind(dto);
    }

    @ApiOperation("分页查询组织信息")
    @GetMapping("/organization-page-query")
    public ResultDTO<List<OrganizationDTO>> organizationPageQuery(OrganizationPageQuery pageQuery) {
        return organizationRpcService.organizationPageQuery(pageQuery);
     }

    @ApiOperation("查询组织详情")
    @GetMapping("/organization-detail-query")
    public ResultDTO<OrganizationDTO> organizationDetailQuery(OrganizationDetailQuery query) {
        return organizationRpcService.organizationDetailQuery(query);
    }
}


