package com.wakedt.visual.domain.aiusagestatistics.aiusagestatistics;

import com.wakedt.visual.domain.aiusagestatistics.aiusagestatistics.create.AiUsageStatisticsCreateCmd;
import org.springframework.stereotype.Component;

/**
 * AI 使用统计-聚合根-工厂
 */
@Component
public class AiUsageStatisticsFactory {

    public AiUsageStatistics getInstance(AiUsageStatisticsCreateCmd createCmd) {
        AiUsageStatistics instance = new AiUsageStatistics();
        instance.setUserId(createCmd.getUserId());
        instance.setAccount(createCmd.getAccount());
        instance.setModel(createCmd.getModel());
        instance.setReportSource(createCmd.getReportSource());
        instance.setRequestTime(createCmd.getRequestTime());
        instance.setBusinessCode(createCmd.getBusinessCode());
        instance.setBusinessDesc(createCmd.getBusinessDesc());
        instance.setRequestTokens(createCmd.getRequestTokens());
        instance.setResponseTokens(createCmd.getResponseTokens());
        instance.setTotalTokens(createCmd.getTotalTokens());
        return instance;
    }

}
