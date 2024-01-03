package com.wakedt.visual.app.application.assembler;

import com.wakedt.visual.client.application.dto.ApplicationVersionUpdateDTO;
import com.wakedt.visual.domain.application.applicationversion.VersionStateConverter;
import com.wakedt.visual.domain.application.applicationversion.update.ApplicationVersionUpdateCmd;
import com.wakedt.visual.infrastructure.BaseConvert;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * ApplicationVersionUpdateCmd和DTO转换器
 *
 * @author zhuxueliang
 */
@Mapper(uses = {
        VersionStateConverter.class,
})
public interface ApplicationVersionUpdateDTOConvert extends
        BaseConvert<ApplicationVersionUpdateDTO, ApplicationVersionUpdateCmd> {

    ApplicationVersionUpdateDTOConvert INSTANCE = Mappers.getMapper(ApplicationVersionUpdateDTOConvert.class);
}