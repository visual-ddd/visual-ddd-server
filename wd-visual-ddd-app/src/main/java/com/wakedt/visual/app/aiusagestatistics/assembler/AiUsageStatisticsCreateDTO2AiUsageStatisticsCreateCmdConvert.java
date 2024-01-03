package com.wakedt.visual.app.aiusagestatistics.assembler;

import com.wakedt.visual.client.aiusagestatistics.query.AiUsageStatisticsCreateDTO;
import com.wakedt.visual.domain.aiusagestatistics.aiusagestatistics.create.AiUsageStatisticsCreateCmd;
import com.wakedt.visual.infrastructure.BaseConvert;
import com.wakedt.visual.infrastructure.BaseJsonConvertor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {
        BaseJsonConvertor.class,
})
public interface AiUsageStatisticsCreateDTO2AiUsageStatisticsCreateCmdConvert extends BaseConvert<AiUsageStatisticsCreateDTO, AiUsageStatisticsCreateCmd> {

    AiUsageStatisticsCreateDTO2AiUsageStatisticsCreateCmdConvert INSTANCE = Mappers.getMapper(AiUsageStatisticsCreateDTO2AiUsageStatisticsCreateCmdConvert.class);
}