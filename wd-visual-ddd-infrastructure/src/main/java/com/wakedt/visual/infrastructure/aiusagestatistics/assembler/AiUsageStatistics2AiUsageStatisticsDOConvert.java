package com.wakedt.visual.infrastructure.aiusagestatistics.assembler;

import com.wakedt.visual.domain.aiusagestatistics.aiusagestatistics.AiUsageStatistics;
import com.wakedt.visual.infrastructure.BaseConvert;
import com.wakedt.visual.infrastructure.BaseJsonConvertor;
import com.wakedt.visual.infrastructure.aiusagestatistics.repository.model.AiUsageStatisticsDO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {
        BaseJsonConvertor.class,
})
public interface AiUsageStatistics2AiUsageStatisticsDOConvert extends BaseConvert<AiUsageStatistics, AiUsageStatisticsDO> {

    AiUsageStatistics2AiUsageStatisticsDOConvert INSTANCE = Mappers.getMapper(AiUsageStatistics2AiUsageStatisticsDOConvert.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "userId", target = "userId")
    @Mapping(source = "account", target = "account")
    @Mapping(source = "model", target = "model")
    @Mapping(source = "reportSource", target = "reportSource")
    @Mapping(source = "requestTime", target = "requestTime")
    @Mapping(source = "businessCode", target = "businessCode")
    @Mapping(source = "businessDesc", target = "businessDesc")
    @Mapping(source = "requestTokens", target = "requestTokens")
    @Mapping(source = "responseTokens", target = "responseTokens")
    @Mapping(source = "totalTokens", target = "totalTokens")
    @Override
    AiUsageStatisticsDO dto2Do(AiUsageStatistics dto);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "userId", target = "userId")
    @Mapping(source = "account", target = "account")
    @Mapping(source = "model", target = "model")
    @Mapping(source = "reportSource", target = "reportSource")
    @Mapping(source = "requestTime", target = "requestTime")
    @Mapping(source = "businessCode", target = "businessCode")
    @Mapping(source = "businessDesc", target = "businessDesc")
    @Mapping(source = "requestTokens", target = "requestTokens")
    @Mapping(source = "responseTokens", target = "responseTokens")
    @Mapping(source = "totalTokens", target = "totalTokens")
    @Override
    AiUsageStatistics do2Dto(AiUsageStatisticsDO d);
}
