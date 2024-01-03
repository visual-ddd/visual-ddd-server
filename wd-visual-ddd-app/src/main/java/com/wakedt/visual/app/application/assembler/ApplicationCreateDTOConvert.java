package com.wakedt.visual.app.application.assembler;

import com.wakedt.visual.client.application.dto.ApplicationCreateDTO;
import com.wakedt.visual.domain.application.application.create.ApplicationCreateCmd;
import com.wakedt.visual.infrastructure.BaseConvert;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * ApplicationCreateCmd和DTO转换器
 *
 * @author zhuxueliang
 */
@Mapper(uses = {
})
public interface ApplicationCreateDTOConvert extends
        BaseConvert<ApplicationCreateDTO, ApplicationCreateCmd> {

    ApplicationCreateDTOConvert INSTANCE = Mappers.getMapper(ApplicationCreateDTOConvert.class);
}