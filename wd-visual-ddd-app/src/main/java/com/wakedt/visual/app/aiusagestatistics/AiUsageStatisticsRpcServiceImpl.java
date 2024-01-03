package com.wakedt.visual.app.aiusagestatistics;

import com.wakedata.common.core.dto.PageResultDTO;
import com.wakedata.common.core.dto.ResultDTO;
import com.wakedt.visual.app.aiusagestatistics.assembler.AiUsageStatisticsCreateDTO2AiUsageStatisticsCreateCmdConvert;
import com.wakedt.visual.app.aiusagestatistics.view.AiUsageStatisticsPageQueryExe;
import com.wakedt.visual.app.aiusagestatistics.view.AiUsageStatisticsQueryExe;
import com.wakedt.visual.client.aiusagestatistics.AiUsageStatisticsRpcService;
import com.wakedt.visual.client.aiusagestatistics.dto.AiUsageStatisticsDTO;
import com.wakedt.visual.client.aiusagestatistics.query.AiUsageStatisticsCreateDTO;
import com.wakedt.visual.client.aiusagestatistics.query.AiUsageStatisticsPageQuery;
import com.wakedt.visual.client.aiusagestatistics.query.AiUsageStatisticsQuery;
import com.wakedt.visual.domain.aiusagestatistics.aiusagestatistics.create.AiUsageStatisticsCreateCmdHandler;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * AI 使用统计-RPC能力接口实现
 */
@Service
public class AiUsageStatisticsRpcServiceImpl implements AiUsageStatisticsRpcService {

    @Resource
    private AiUsageStatisticsCreateCmdHandler aiUsageStatisticsCreateCmdHandler;
    @Resource
    private AiUsageStatisticsQueryExe aiUsageStatisticsQueryExe;
    @Resource
    private AiUsageStatisticsPageQueryExe aiUsageStatisticsPageQueryExe;


    @Override
    public ResultDTO<Long> create(AiUsageStatisticsCreateDTO dto) {
        Long id = aiUsageStatisticsCreateCmdHandler.handle(AiUsageStatisticsCreateDTO2AiUsageStatisticsCreateCmdConvert.INSTANCE.dto2Do(dto));
        return ResultDTO.success(id);
    }

    @Override
    public ResultDTO<AiUsageStatisticsDTO> aiUsageStatisticsQuery(AiUsageStatisticsQuery query) {
        return aiUsageStatisticsQueryExe.execute(query);
    }

    @Override
    public PageResultDTO<List<AiUsageStatisticsDTO>> aiUsageStatisticsPageQuery(AiUsageStatisticsPageQuery pageQuery) {
        return aiUsageStatisticsPageQueryExe.execute(pageQuery);
    }
}