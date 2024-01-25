package com.wakedt.visual.adapter.domaindesign.web;

import com.wakedata.common.core.dto.ResultDTO;
import com.wakedt.visual.client.domaindesign.DomainDesignVersionRpcService;
import com.wakedt.visual.client.domaindesign.dto.*;
import com.wakedt.visual.client.domaindesign.query.DomainDesignVersionDetailQuery;
import com.wakedt.visual.client.domaindesign.query.DomainDesignVersionPageQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * 业务域版本-web-controller
 *
 * @author zhuxueliang
 */
@RestController
@RequestMapping("/web/domain-design-version")
@Api(value = "/web/domain-design-version", tags = "B端-业务域版本")
public class DomainDesignVersionWebController {

    @Resource
    private DomainDesignVersionRpcService domainDesignVersionRpcService;


    @ApiOperation("新增业务域版本")
    @PostMapping("/domain-design-version-create")
    public ResultDTO<Long> domainDesignVersionCreate(@RequestBody @Valid DomainDesignVersionCreateDTO dto) {
        return domainDesignVersionRpcService.domainDesignVersionCreate(dto);
    }

    @ApiOperation("更新业务域版本")
    @PostMapping("/domain-design-version-update")
    public ResultDTO<Boolean> domainDesignVersionUpdate(@RequestBody @Valid DomainDesignVersionUpdateDTO dto) {
        return domainDesignVersionRpcService.domainDesignVersionUpdate(dto);
    }

    @ApiOperation("删除业务域版本")
    @PostMapping("/domain-design-version-remove")
    public ResultDTO<Boolean> domainDesignVersionRemove(@RequestBody @Valid DomainDesignVersionRemoveDTO dto) {
        return domainDesignVersionRpcService.domainDesignVersionRemove(dto);
    }

    @ApiOperation("发布业务域版本")
    @PostMapping("/domain-design-version-publish")
    public ResultDTO<Boolean> domainDesignVersionPublish(@RequestBody @Valid DomainDesignVersionPublishDTO dto) {
        return domainDesignVersionRpcService.domainDesignVersionPublish(dto);
    }

    @ApiOperation("更新业务域DSL")
    @PostMapping("/domain-design-dsl-update")
    public ResultDTO<Boolean> domainDesignDSLUpdate(@RequestBody @Valid DomainDesignDSLUpdateDTO dto) {
        return domainDesignVersionRpcService.domainDesignDslUpdate(dto);
    }

    @ApiOperation("查询业务域版本详情")
    @GetMapping("/domain-design-version-detail-query")
    public ResultDTO<DomainDesignVersionDTO> domainDesignVersionDetailQuery(DomainDesignVersionDetailQuery query) {
        return domainDesignVersionRpcService.domainDesignVersionDetailQuery(query);
    }

    @ApiOperation("查询业务域版本简介")
    @GetMapping("/domain-design-version-simple-query")
    public ResultDTO<DomainDesignVersionDTO> domainDesignVersionSimpleQuery(DomainDesignVersionDetailQuery query) {
        return domainDesignVersionRpcService.domainDesignVersionSimpleQuery(query);
    }

    @ApiOperation("分页查询业务域版本信息")
    @GetMapping("/domain-design-version-page-query")
    public ResultDTO<List<DomainDesignVersionDTO>> domainDesignVersionPageQuery(DomainDesignVersionPageQuery pageQuery) {
        return domainDesignVersionRpcService.domainDesignVersionPageQuery(pageQuery);
    }
}


