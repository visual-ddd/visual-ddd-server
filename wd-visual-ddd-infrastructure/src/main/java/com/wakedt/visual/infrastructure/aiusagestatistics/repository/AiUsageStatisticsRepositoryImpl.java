package com.wakedt.visual.infrastructure.aiusagestatistics.repository;

import com.wakedata.common.core.exception.BizException;
import com.wakedt.visual.domain.aiusagestatistics.aiusagestatistics.AiUsageStatistics;
import com.wakedt.visual.domain.aiusagestatistics.aiusagestatistics.AiUsageStatisticsRepository;
import com.wakedt.visual.infrastructure.aiusagestatistics.assembler.AiUsageStatistics2AiUsageStatisticsDOConvert;
import com.wakedt.visual.infrastructure.aiusagestatistics.repository.mapper.AiUsageStatisticsMapper;
import com.wakedt.visual.infrastructure.aiusagestatistics.repository.model.AiUsageStatisticsDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.Resource;

/**
 * AiUsageStatistics-聚合仓储实现类
 */
@Slf4j
@Component
public class AiUsageStatisticsRepositoryImpl implements AiUsageStatisticsRepository {

    @Resource
    private AiUsageStatisticsMapper aiUsageStatisticsMapper;

    @Override
    public AiUsageStatistics save(AiUsageStatistics aiUsageStatistics) {
        AiUsageStatisticsDO aiUsageStatisticsDO = AiUsageStatistics2AiUsageStatisticsDOConvert.INSTANCE.dto2Do(aiUsageStatistics);
        int insert = aiUsageStatisticsMapper.insert(aiUsageStatisticsDO);
        Assert.isTrue(insert == 1, "插入数据库异常，请联系管理员");
        return AiUsageStatistics2AiUsageStatisticsDOConvert.INSTANCE.do2Dto(aiUsageStatisticsDO);
    }

    @Override
    public AiUsageStatistics update(AiUsageStatistics aiUsageStatistics) {
        AiUsageStatisticsDO aiUsageStatisticsDO = AiUsageStatistics2AiUsageStatisticsDOConvert.INSTANCE.dto2Do(aiUsageStatistics);
        int update = aiUsageStatisticsMapper.updateById(aiUsageStatisticsDO);
        Assert.isTrue(update == 1, "更新数据库异常，请联系管理员");
        return AiUsageStatistics2AiUsageStatisticsDOConvert.INSTANCE.do2Dto(aiUsageStatisticsDO);
    }

    @Override
    public void remove(AiUsageStatistics aiUsageStatistics) {
        AiUsageStatisticsDO aiUsageStatisticsDO = AiUsageStatistics2AiUsageStatisticsDOConvert.INSTANCE.dto2Do(aiUsageStatistics);
        aiUsageStatisticsMapper.deleteById(aiUsageStatisticsDO.getId());
    }

    @Override
    public AiUsageStatistics find(Long id) {
        AiUsageStatisticsDO result = aiUsageStatisticsMapper.selectById(id);
        if (result == null) throw new BizException("id不存在!");
        return AiUsageStatistics2AiUsageStatisticsDOConvert.INSTANCE.do2Dto(result);
    }
}
