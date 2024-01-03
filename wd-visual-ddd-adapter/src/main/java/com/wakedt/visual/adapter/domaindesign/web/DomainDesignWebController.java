package com.wakedt.visual.adapter.domaindesign.web;

import com.wakedata.common.core.dto.ResultDTO;
import com.wakedt.visual.client.domaindesign.DomainDesignRpcService;
import com.wakedt.visual.client.domaindesign.dto.DomainDesignCreateDTO;
import com.wakedt.visual.client.domaindesign.dto.DomainDesignDTO;
import com.wakedt.visual.client.domaindesign.dto.DomainDesignRemoveDTO;
import com.wakedt.visual.client.domaindesign.dto.DomainDesignUpdateDTO;
import com.wakedt.visual.client.domaindesign.query.DomainDesignDetailQuery;
import com.wakedt.visual.client.domaindesign.query.DomainDesignListQuery;
import com.wakedt.visual.client.domaindesign.query.DomainDesignPageQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * 业务域-web-controller
 *
 * @author zhuxueliang
 */
@RestController
@RequestMapping("/web/domain-design")
@Api(value = "/web/domain-design", tags = "B端-业务域")
public class DomainDesignWebController {

    @Resource
    private DomainDesignRpcService domainDesignRpcService;


    @ApiOperation("新增业务域")
    @PostMapping("/domain-design-create")
    public ResultDTO<Long> domainDesignCreate(@RequestBody @Valid DomainDesignCreateDTO dto) {
        return domainDesignRpcService.domainDesignCreate(dto);
    }

    @ApiOperation("更新业务域")
    @PostMapping("/domain-design-update")
    public ResultDTO<Boolean> domainDesignUpdate(@RequestBody @Valid DomainDesignUpdateDTO dto) {
        return domainDesignRpcService.domainDesignUpdate(dto);
    }

    @ApiOperation("删除业务域")
    @PostMapping("/domain-design-remove")
    public ResultDTO<Boolean> domainDesignRemove(@RequestBody @Valid DomainDesignRemoveDTO dto) {
        return domainDesignRpcService.domainDesignRemove(dto);
    }

    @ApiOperation("查询业务域详情")
    @GetMapping("/domain-design-detail-query")
    public ResultDTO<DomainDesignDTO> domainDesignDetailQuery(DomainDesignDetailQuery query) {
        return domainDesignRpcService.domainDesignDetailQuery(query);
    }

    @ApiOperation("查询业务域列表详情")
    @GetMapping("/domain-design-list-query")
    public ResultDTO<List<DomainDesignDTO>> domainDesignDetailQuery(DomainDesignListQuery query) {
        return domainDesignRpcService.domainDesignListQuery(query);
    }

    @ApiOperation("分页查询业务域信息")
    @GetMapping("/domain-design-page-query")
    public ResultDTO<List<DomainDesignDTO>> domainDesignPageQuery(DomainDesignPageQuery pageQuery) {
        return domainDesignRpcService.domainDesignPageQuery(pageQuery);
    }
}


