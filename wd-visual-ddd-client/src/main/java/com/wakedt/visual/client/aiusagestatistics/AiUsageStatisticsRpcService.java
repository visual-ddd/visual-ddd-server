package com.wakedt.visual.client.aiusagestatistics;

import com.wakedata.common.core.dto.PageResultDTO;
import com.wakedata.common.core.dto.ResultDTO;
import com.wakedt.visual.client.aiusagestatistics.dto.AiUsageStatisticsDTO;
import com.wakedt.visual.client.aiusagestatistics.query.AiUsageStatisticsCreateDTO;
import com.wakedt.visual.client.aiusagestatistics.query.AiUsageStatisticsPageQuery;
import com.wakedt.visual.client.aiusagestatistics.query.AiUsageStatisticsQuery;

import java.util.List;

/**
 * AI 使用统计-RPC能力接口
 */
public interface AiUsageStatisticsRpcService {

    /** 新增AI 使用统计 */
    ResultDTO<Long> create(AiUsageStatisticsCreateDTO dto);

    /** 查询AI 使用统计详情 */
    ResultDTO<AiUsageStatisticsDTO> aiUsageStatisticsQuery(AiUsageStatisticsQuery query);

    /** 分页查询AI 使用统计 */
    PageResultDTO<List<AiUsageStatisticsDTO>> aiUsageStatisticsPageQuery(AiUsageStatisticsPageQuery pageQuery);

}