package com.wakedt.visual.adapter.businessscene.web;

import com.wakedata.common.core.dto.ResultDTO;
import com.wakedt.visual.client.businessscene.BusinessSceneVersionRpcService;
import com.wakedt.visual.client.businessscene.dto.*;
import com.wakedt.visual.client.businessscene.query.BusinessSceneVersionDetailQuery;
import com.wakedt.visual.client.businessscene.query.BusinessSceneVersionPageQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * 业务场景版本-web-controller
 *
 * @author zhuxueliang
 */
@RestController
@RequestMapping("/web/business-scene-version")
@Api(value = "/web/business-scene-version", tags = "B端-业务场景版本")
public class BusinessSceneVersionWebController {

    @Resource
    private BusinessSceneVersionRpcService businessSceneVersionRpcService;


    @ApiOperation("新增业务场景版本")
    @PostMapping("/business-scene-version-create")
    public ResultDTO<Long> businessSceneVersionCreate(@RequestBody @Valid BusinessSceneVersionCreateDTO dto) {
        return businessSceneVersionRpcService.businessSceneVersionCreate(dto);
    }

    @ApiOperation("更新业务场景版本")
    @PostMapping("/business-scene-version-update")
    public ResultDTO<Boolean> businessSceneVersionUpdate(@RequestBody @Valid BusinessSceneVersionUpdateDTO dto) {
        return businessSceneVersionRpcService.businessSceneVersionUpdate(dto);
    }

    @ApiOperation("删除业务场景版本")
    @PostMapping("/business-scene-version-remove")
    public ResultDTO<Boolean> businessSceneVersionRemove(@RequestBody @Valid BusinessSceneVersionRemoveDTO dto) {
        return businessSceneVersionRpcService.businessSceneVersionRemove(dto);
    }

    @ApiOperation("发布业务场景版本")
    @PostMapping("/business-scene-version-pblish")
    public ResultDTO<Boolean> businessSceneVersionPblish(@RequestBody @Valid BusinessSceneVersionPublishDTO dto) {
        return businessSceneVersionRpcService.businessSceneVersionPblish(dto);
    }

    @ApiOperation("更新业务场景DSL")
    @PostMapping("/business-scene-dsl-update")
    public ResultDTO<Boolean> businessSceneDSLUpdate(@RequestBody @Valid BusinessSceneDSLUpdateDTO dto) {
        return businessSceneVersionRpcService.businessSceneDSLUpdate(dto);
    }

    @ApiOperation("查询业务场景版本详情")
    @GetMapping("/business-scene-version-detail-query")
    public ResultDTO<BusinessSceneVersionDTO> businessSceneVersionDetailQuery(BusinessSceneVersionDetailQuery query) {
        return businessSceneVersionRpcService.businessSceneVersionDetailQuery(query);
    }

    @ApiOperation("查询业务场景版本简介")
    @GetMapping("/business-scene-version-simple-query")
    public ResultDTO<BusinessSceneVersionDTO> businessSceneVersionSimpleQuery(BusinessSceneVersionDetailQuery query) {
        return businessSceneVersionRpcService.businessSceneVersionSimpleQuery(query);
    }

    @ApiOperation("分页查询业务场景版本信息")
    @GetMapping("/business-scene-version-page-query")
    public ResultDTO<List<BusinessSceneVersionDTO>> businessSceneVersionPageQuery(BusinessSceneVersionPageQuery pageQuery) {
        return businessSceneVersionRpcService.businessSceneVersionPageQuery(pageQuery);
     }
}


