
package com.wakedt.visual.adapter.prompt.web;

import com.wakedata.common.core.dto.PageResultDTO;
import com.wakedata.common.core.dto.ResultDTO;
import com.wakedt.visual.client.prompt.PromptRpcService;
import com.wakedt.visual.client.prompt.dto.PromptDTO;
import com.wakedt.visual.client.prompt.query.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * 提示词-B端
 */
@RestController
@RequestMapping("/web/prompt")
@Api(value = "/web/prompt", tags = "提示词-B端")
public class PromptWebController {

    @Resource
    private PromptRpcService promptRpcService;

    @ApiOperation("新增提示词")
    @PostMapping("/create")
    public ResultDTO<Long> create(@RequestBody @Valid PromptCreateDTO dto) {
        return promptRpcService.create(dto);
    }

    @ApiOperation("编辑提示词")
    @PostMapping("/modify")
    public ResultDTO<Boolean> modify(@RequestBody @Valid PromptModifyDTO dto) {
        return promptRpcService.modify(dto);
    }

    @ApiOperation("删除提示词")
    @PostMapping("/remove")
    public ResultDTO<Boolean> remove(@RequestBody @Valid PromptRemoveDTO dto) {
        return promptRpcService.remove(dto);
    }

    @ApiOperation("查询提示词详情")
    @GetMapping("/prompt-query")
    public ResultDTO<PromptDTO> promptQuery(PromptQuery query) {
        return promptRpcService.promptQuery(query);
    }

    @ApiOperation("分页查询提示词")
    @GetMapping("/prompt-page-query")
    public PageResultDTO<List<PromptDTO>> promptPageQuery(PromptPageQuery pageQuery) {
        return promptRpcService.promptPageQuery(pageQuery);
    }
}