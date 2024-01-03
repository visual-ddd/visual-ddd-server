package com.wakedt.visual.domain.aiusagestatistics.aiusagestatistics.create;

import com.wakedt.visual.domain.aiusagestatistics.aiusagestatistics.AiUsageStatistics;
import com.wakedt.visual.domain.aiusagestatistics.aiusagestatistics.AiUsageStatisticsFactory;
import com.wakedt.visual.domain.aiusagestatistics.aiusagestatistics.AiUsageStatisticsRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 新增AI 使用统计-指令处理器
 */
@Component
public class AiUsageStatisticsCreateCmdHandler {

    @Resource
    private AiUsageStatisticsRepository repository;
    @Resource
    private AiUsageStatisticsFactory factory;

    public Long handle(AiUsageStatisticsCreateCmd createCmd) {
        AiUsageStatistics entity = factory.getInstance(createCmd);

        AiUsageStatistics newEntity = repository.save(entity);

       // DomainEventPublisher.getInstance().postAfterCommit(new AiUsageStatisticsCreateEvent(createCmd));
        return newEntity.getId();
    }
}