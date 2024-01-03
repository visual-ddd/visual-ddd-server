package com.wakedt.visual.infrastructure.aiusagestatistics.repository.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wakedt.visual.client.aiusagestatistics.query.AiUsageStatisticsPageQuery;
import com.wakedt.visual.client.aiusagestatistics.query.AiUsageStatisticsQuery;
import com.wakedt.visual.infrastructure.aiusagestatistics.repository.model.AiUsageStatisticsDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * AiUsageStatisticsMapper接口
 */
@Mapper
public interface AiUsageStatisticsMapper extends BaseMapper<AiUsageStatisticsDO> {

    /** AI 使用统计详情查询对象 */
    AiUsageStatisticsDO aiUsageStatisticsQuery(AiUsageStatisticsQuery query);

    /** AI 使用统计分页查询对象 */
    List<AiUsageStatisticsDO> aiUsageStatisticsPageQuery(AiUsageStatisticsPageQuery pageQuery);

}