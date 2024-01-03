package com.wakedt.visual.app.application.assembler;

import com.wakedt.visual.client.application.dto.ApplicationVersionRemoveDTO;
import com.wakedt.visual.domain.application.applicationversion.VersionStateConverter;
import com.wakedt.visual.domain.application.applicationversion.remove.ApplicationVersionRemoveCmd;
import com.wakedt.visual.infrastructure.BaseConvert;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * ApplicationVersionRemoveCmd和DTO转换器
 *
 * @author zhuxueliang
 */
@Mapper(uses = {
        VersionStateConverter.class,
})
public interface ApplicationVersionRemoveDTOConvert extends
        BaseConvert<ApplicationVersionRemoveDTO, ApplicationVersionRemoveCmd> {

    ApplicationVersionRemoveDTOConvert INSTANCE = Mappers.getMapper(ApplicationVersionRemoveDTOConvert.class);
}