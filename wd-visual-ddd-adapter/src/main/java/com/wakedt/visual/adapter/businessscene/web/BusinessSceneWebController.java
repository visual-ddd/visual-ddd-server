package com.wakedt.visual.adapter.businessscene.web;

import com.wakedata.common.core.dto.ResultDTO;
import com.wakedt.visual.client.businessscene.BusinessSceneRpcService;
import com.wakedt.visual.client.businessscene.dto.BusinessSceneCreateDTO;
import com.wakedt.visual.client.businessscene.dto.BusinessSceneDTO;
import com.wakedt.visual.client.businessscene.dto.BusinessSceneRemoveDTO;
import com.wakedt.visual.client.businessscene.dto.BusinessSceneUpdateDTO;
import com.wakedt.visual.client.businessscene.query.BusinessSceneDetailQuery;
import com.wakedt.visual.client.businessscene.query.BusinessSceneListQuery;
import com.wakedt.visual.client.businessscene.query.BusinessScenePageQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * 业务场景-web-controller
 *
 * @author zhuxueliang
 */
@RestController
@RequestMapping("/web/business-scene")
@Api(value = "/web/business-scene", tags = "B端-业务场景")
public class BusinessSceneWebController {

    @Resource
    private BusinessSceneRpcService businessSceneRpcService;


    @ApiOperation("新增业务场景")
    @PostMapping("/business-scene-create")
    public ResultDTO<Long> businessSceneCreate(@RequestBody @Valid BusinessSceneCreateDTO dto) {
        return businessSceneRpcService.businessSceneCreate(dto);
    }

    @ApiOperation("更新业务场景")
    @PostMapping("/business-scene-update")
    public ResultDTO<Boolean> businessSceneUpdate(@RequestBody @Valid BusinessSceneUpdateDTO dto) {
        return businessSceneRpcService.businessSceneUpdate(dto);
    }

    @ApiOperation("删除业务场景")
    @PostMapping("/business-scene-remove")
    public ResultDTO<Boolean> businessSceneRemove(@RequestBody @Valid BusinessSceneRemoveDTO dto) {
        return businessSceneRpcService.businessSceneRemove(dto);
    }

    @ApiOperation("查询业务场景详情")
    @GetMapping("/business-scene-detail-query")
    public ResultDTO<BusinessSceneDTO> businessSceneDetailQuery(@Valid BusinessSceneDetailQuery query) {
        return businessSceneRpcService.businessSceneDetailQuery(query);
    }

    @ApiOperation("查询业务场景列表详情")
    @GetMapping("/business-scene-list-query")
    public ResultDTO<List<BusinessSceneDTO>> businessSceneDetailQuery(@Valid BusinessSceneListQuery query) {
        return businessSceneRpcService.businessSceneListQuery(query);
    }

    @ApiOperation("分页查询业务场景信息")
    @GetMapping("/business-scene-page-query")
    public ResultDTO<List<BusinessSceneDTO>> businessScenePageQuery(BusinessScenePageQuery pageQuery) {
        return businessSceneRpcService.businessScenePageQuery(pageQuery);
     }
}


