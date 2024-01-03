package com.wakedt.visual.app.aiusagestatistics.assembler;

import com.wakedt.visual.client.aiusagestatistics.dto.AiUsageStatisticsDTO;
import com.wakedt.visual.infrastructure.BaseConvert;
import com.wakedt.visual.infrastructure.BaseJsonConvertor;
import com.wakedt.visual.infrastructure.aiusagestatistics.repository.model.AiUsageStatisticsDO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {
        BaseJsonConvertor.class,
})
public interface AiUsageStatisticsDTO2AiUsageStatisticsDOConvert extends BaseConvert<AiUsageStatisticsDTO, AiUsageStatisticsDO> {

    AiUsageStatisticsDTO2AiUsageStatisticsDOConvert INSTANCE = Mappers.getMapper(AiUsageStatisticsDTO2AiUsageStatisticsDOConvert.class);

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
    AiUsageStatisticsDO dto2Do(AiUsageStatisticsDTO dto);

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
    AiUsageStatisticsDTO do2Dto(AiUsageStatisticsDO d);
}