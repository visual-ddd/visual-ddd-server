package com.wakedt.visual.app.aiusagestatistics.view;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wakedata.common.core.dto.PageResultDTO;
import com.wakedt.visual.app.aiusagestatistics.assembler.AiUsageStatisticsDTO2AiUsageStatisticsDOConvert;
import com.wakedt.visual.client.aiusagestatistics.dto.AiUsageStatisticsDTO;
import com.wakedt.visual.client.aiusagestatistics.query.AiUsageStatisticsPageQuery;
import com.wakedt.visual.infrastructure.aiusagestatistics.repository.mapper.AiUsageStatisticsMapper;
import com.wakedt.visual.infrastructure.aiusagestatistics.repository.model.AiUsageStatisticsDO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * AI 使用统计分页查询对象-查询器
 */
@Component
public class AiUsageStatisticsPageQueryExe {

    @Resource
    private AiUsageStatisticsMapper mapper;

    public PageResultDTO<List<AiUsageStatisticsDTO>> execute(AiUsageStatisticsPageQuery pageQuery) {
        PageHelper.startPage(pageQuery.getPageNo(),pageQuery.getPageSize());

        PageInfo<AiUsageStatisticsDO> pageInfo = new PageInfo<>(mapper.aiUsageStatisticsPageQuery(pageQuery));
        PageResultDTO<List<AiUsageStatisticsDTO>> pageResultDTO = new PageResultDTO<>();
        pageResultDTO.setData(AiUsageStatisticsDTO2AiUsageStatisticsDOConvert.INSTANCE.doList2DtoList(pageInfo.getList()));
        pageResultDTO.setPageNo(pageInfo.getPageNum());
        pageResultDTO.setPageSize(pageInfo.getSize());
        pageResultDTO.setTotalCount(pageInfo.getTotal());
        return pageResultDTO;
    }
}
