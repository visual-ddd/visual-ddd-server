package com.wakedt.visual.app.application.assembler;

import com.wakedt.visual.client.application.dto.ApplicationVersionDTO;
import com.wakedt.visual.infrastructure.BaseConvert;
import com.wakedt.visual.infrastructure.application.repository.model.ApplicationVersionDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * ApplicationVersionDTO和DO转换器
 *
 * @author zhuxueliang
 */
@Mapper(uses = {
        JsonConverter.class,
})
public interface ApplicationVersionDTO2DOConvert extends
        BaseConvert<ApplicationVersionDTO, ApplicationVersionDO> {

    ApplicationVersionDTO2DOConvert INSTANCE = Mappers.getMapper(ApplicationVersionDTO2DOConvert.class);
}