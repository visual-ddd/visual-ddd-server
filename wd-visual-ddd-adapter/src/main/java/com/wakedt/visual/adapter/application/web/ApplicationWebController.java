package com.wakedt.visual.adapter.application.web;

import com.wakedata.common.core.dto.ResultDTO;
import com.wakedt.visual.client.application.ApplicationRpcService;
import com.wakedt.visual.client.application.dto.ApplicationCreateDTO;
import com.wakedt.visual.client.application.dto.ApplicationDTO;
import com.wakedt.visual.client.application.dto.ApplicationRemoveDTO;
import com.wakedt.visual.client.application.dto.ApplicationUpdateDTO;
import com.wakedt.visual.client.application.query.ApplicationDetailQuery;
import com.wakedt.visual.client.application.query.ApplicationListQuery;
import com.wakedt.visual.client.application.query.ApplicationPageQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * 应用-web-controller
 *
 * @author zhuxueliang
 */
@RestController
@RequestMapping("/web/application")
@Api(value = "/web/application", tags = "B端-应用")
public class ApplicationWebController {

    @Resource
    private ApplicationRpcService applicationRpcService;


    @ApiOperation("新增应用")
    @PostMapping("/application-create")
    public ResultDTO<Long> applicationCreate(@RequestBody @Valid ApplicationCreateDTO dto) {
        return applicationRpcService.applicationCreate(dto);
    }

    @ApiOperation("更新应用")
    @PostMapping("/application-update")
    public ResultDTO<Boolean> applicationUpdate(@RequestBody @Valid ApplicationUpdateDTO dto) {
        return applicationRpcService.applicationUpdate(dto);
    }

    @ApiOperation("删除应用")
    @PostMapping("/application-remove")
    public ResultDTO<Boolean> applicationRemove(@RequestBody @Valid ApplicationRemoveDTO dto) {
        return applicationRpcService.applicationRemove(dto);
    }

    @ApiOperation("查询应用详情")
    @GetMapping("/application-detail-query")
    public ResultDTO<ApplicationDTO> applicationDetailQuery(ApplicationDetailQuery query) {
        return applicationRpcService.applicationDetailQuery(query);
    }

    @ApiOperation("查询应用列表详情")
    @GetMapping("/application-list-query")
    public ResultDTO<List<ApplicationDTO>> applicationDetailQuery(ApplicationListQuery query) {
        return applicationRpcService.applicationListQuery(query);
    }

    @ApiOperation("分页查询应用信息")
    @GetMapping("/application-page-query")
    public ResultDTO<List<ApplicationDTO>> applicationPageQuery(ApplicationPageQuery pageQuery) {
        return applicationRpcService.applicationPageQuery(pageQuery);
     }
}


