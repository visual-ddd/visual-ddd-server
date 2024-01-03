
package com.wakedt.visual.adapter.whitelist.web;

import com.wakedt.visual.client.whitelist.WhiteListRpcService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 白名单域-B端
 */
@RestController
@RequestMapping("/web/white-list")
@Api(value = "/web/white-list", tags = "白名单域-B端")
public class WhiteListWebController {

    @Resource
    private WhiteListRpcService whiteListRpcService;

//    @ApiOperation("新增白名单")
//    @PostMapping("/create")
//    public ResultDTO<Long> create(@RequestBody @Valid WhiteListCreateDTO dto) {
//        return whiteListRpcService.create(dto);
//    }
//
//    @ApiOperation("编辑白名单")
//    @PostMapping("/modify")
//    public ResultDTO<Boolean> modify(@RequestBody @Valid WhiteListModifyDTO dto) {
//        return whiteListRpcService.modify(dto);
//    }
//
//    @ApiOperation("删除白名单")
//    @PostMapping("/remove")
//    public ResultDTO<Boolean> remove(@RequestBody @Valid WhiteListRemoveDTO dto) {
//        return whiteListRpcService.remove(dto);
//    }
//
//    @ApiOperation("查询白名单详情")
//    @GetMapping("/white-list-query")
//    public ResultDTO<WhiteListDTO> whiteListQuery(WhiteListQuery query) {
//        return whiteListRpcService.whiteListQuery(query);
//    }
//
//    @ApiOperation("分页查询白名单")
//    @GetMapping("/white-list-page-query")
//    public PageResultDTO<List<WhiteListDTO>> whiteListPageQuery(WhiteListPageQuery pageQuery) {
//        return whiteListRpcService.whiteListPageQuery(pageQuery);
//    }
}