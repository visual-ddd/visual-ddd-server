package com.wakedt.visual.app.application.assembler;

import com.wakedt.visual.client.application.dto.ApplicationUpdateDTO;
import com.wakedt.visual.domain.application.application.update.ApplicationUpdateCmd;
import com.wakedt.visual.infrastructure.BaseConvert;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * ApplicationUpdateCmd和DTO转换器
 *
 * @author zhuxueliang
 */
@Mapper(uses = {
})
public interface ApplicationUpdateDTOConvert extends
        BaseConvert<ApplicationUpdateDTO, ApplicationUpdateCmd> {

    ApplicationUpdateDTOConvert INSTANCE = Mappers.getMapper(ApplicationUpdateDTOConvert.class);
}