package com.wakedt.visual.app.aiusagestatistics.view;

import com.wakedata.common.core.dto.ResultDTO;
import com.wakedt.visual.app.aiusagestatistics.assembler.AiUsageStatisticsDTO2AiUsageStatisticsDOConvert;
import com.wakedt.visual.client.aiusagestatistics.dto.AiUsageStatisticsDTO;
import com.wakedt.visual.client.aiusagestatistics.query.AiUsageStatisticsQuery;
import com.wakedt.visual.infrastructure.aiusagestatistics.repository.mapper.AiUsageStatisticsMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * AI 使用统计详情查询对象-查询器
 */
@Component
public class AiUsageStatisticsQueryExe {

    @Resource
    private AiUsageStatisticsMapper mapper;

    public ResultDTO<AiUsageStatisticsDTO> execute(AiUsageStatisticsQuery query) {
        return ResultDTO.success(
                AiUsageStatisticsDTO2AiUsageStatisticsDOConvert.INSTANCE.do2Dto(mapper.aiUsageStatisticsQuery(query)));
    }
}
