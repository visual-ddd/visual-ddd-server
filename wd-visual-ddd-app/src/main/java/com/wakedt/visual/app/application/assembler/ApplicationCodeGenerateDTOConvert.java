package com.wakedt.visual.app.application.assembler;

import com.wakedt.visual.client.application.dto.ApplicationCodeGenerateDTO;
import com.wakedt.visual.domain.application.applicationversion.VersionStateConverter;
import com.wakedt.visual.domain.application.applicationversion.codegenerate.ApplicationCodeGenerateCmd;
import com.wakedt.visual.infrastructure.BaseConvert;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * ApplicationCodeGenerateCmd和DTO转换器
 *
 * @author zhuxueliang
 */
@Mapper(uses = {
        VersionStateConverter.class,
})
public interface ApplicationCodeGenerateDTOConvert extends
        BaseConvert<ApplicationCodeGenerateDTO, ApplicationCodeGenerateCmd> {

    ApplicationCodeGenerateDTOConvert INSTANCE = Mappers.getMapper(ApplicationCodeGenerateDTOConvert.class);
}