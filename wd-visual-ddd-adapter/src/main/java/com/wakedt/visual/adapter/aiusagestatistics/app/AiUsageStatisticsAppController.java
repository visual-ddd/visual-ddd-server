package com.wakedt.visual.adapter.aiusagestatistics.app;

import com.wakedata.common.core.dto.PageResultDTO;
import com.wakedata.common.core.dto.ResultDTO;
import com.wakedt.visual.client.aiusagestatistics.AiUsageStatisticsRpcService;
import com.wakedt.visual.client.aiusagestatistics.dto.AiUsageStatisticsDTO;
import com.wakedt.visual.client.aiusagestatistics.query.AiUsageStatisticsCreateDTO;
import com.wakedt.visual.client.aiusagestatistics.query.AiUsageStatisticsPageQuery;
import com.wakedt.visual.client.aiusagestatistics.query.AiUsageStatisticsQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * AI 使用统计-C端
 */
@RestController
@RequestMapping("/app/ai-usage-statistics")
@Api(value = "/app/ai-usage-statistics", tags = "AI 使用统计-C端")
public class AiUsageStatisticsAppController {

    @Resource
    private AiUsageStatisticsRpcService aiUsageStatisticsRpcService;

    @ApiOperation("新增AI 使用统计")
    @PostMapping("/create")
    public ResultDTO<Long> create(@RequestBody @Valid AiUsageStatisticsCreateDTO dto) {
        return aiUsageStatisticsRpcService.create(dto);
    }

    @ApiOperation("AI 使用统计详情查询对象")
    @GetMapping("/ai-usage-statistics-query")
    public ResultDTO<AiUsageStatisticsDTO> aiUsageStatisticsQuery(AiUsageStatisticsQuery query) {
        return aiUsageStatisticsRpcService.aiUsageStatisticsQuery(query);
    }

    @ApiOperation("AI 使用统计分页查询对象")
    @GetMapping("/ai-usage-statistics-page-query")
    public PageResultDTO<List<AiUsageStatisticsDTO>> aiUsageStatisticsPageQuery(AiUsageStatisticsPageQuery pageQuery) {
        return aiUsageStatisticsRpcService.aiUsageStatisticsPageQuery(pageQuery);
    }
}