package com.wakedt.visual.app.application.assembler;

import com.wakedt.visual.client.application.dto.ApplicationVersionCreateDTO;
import com.wakedt.visual.domain.application.applicationversion.VersionStateConverter;
import com.wakedt.visual.domain.application.applicationversion.create.ApplicationVersionCreateCmd;
import com.wakedt.visual.infrastructure.BaseConvert;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * ApplicationVersionCreateCmd和DTO转换器
 *
 * @author zhuxueliang
 */
@Mapper(uses = {
        VersionStateConverter.class,
})
public interface ApplicationVersionCreateDTOConvert extends
        BaseConvert<ApplicationVersionCreateDTO, ApplicationVersionCreateCmd> {

    ApplicationVersionCreateDTOConvert INSTANCE = Mappers.getMapper(ApplicationVersionCreateDTOConvert.class);
}