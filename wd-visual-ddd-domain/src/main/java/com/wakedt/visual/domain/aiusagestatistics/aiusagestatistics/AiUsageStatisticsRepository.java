package com.wakedt.visual.domain.aiusagestatistics.aiusagestatistics;

/**
 * AI 使用统计-聚合根-仓储接口
 */
public interface AiUsageStatisticsRepository {

    AiUsageStatistics save(AiUsageStatistics aiUsageStatistics);

    AiUsageStatistics update(AiUsageStatistics aiUsageStatistics);

    void remove(AiUsageStatistics aiUsageStatistics);

    AiUsageStatistics find(Long id);

}
