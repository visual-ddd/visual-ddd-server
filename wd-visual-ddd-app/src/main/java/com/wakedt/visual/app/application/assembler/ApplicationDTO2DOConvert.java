package com.wakedt.visual.app.application.assembler;

import com.wakedt.visual.client.application.dto.ApplicationDTO;
import com.wakedt.visual.infrastructure.BaseConvert;
import com.wakedt.visual.infrastructure.application.repository.model.ApplicationDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * ApplicationDTO和DO转换器
 *
 * @author zhuxueliang
 */
@Mapper(uses = {
        JsonConverter.class,
})
public interface ApplicationDTO2DOConvert extends
        BaseConvert<ApplicationDTO, ApplicationDO> {

    ApplicationDTO2DOConvert INSTANCE = Mappers.getMapper(ApplicationDTO2DOConvert.class);
}