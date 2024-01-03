package com.wakedt.visual.app.application.assembler;

import com.wakedt.visual.client.application.dto.ApplicationRemoveDTO;
import com.wakedt.visual.domain.application.application.remove.ApplicationRemoveCmd;
import com.wakedt.visual.infrastructure.BaseConvert;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * ApplicationRemoveCmd和DTO转换器
 *
 * @author zhuxueliang
 */
@Mapper(uses = {
})
public interface ApplicationRemoveDTOConvert extends
        BaseConvert<ApplicationRemoveDTO, ApplicationRemoveCmd> {

    ApplicationRemoveDTOConvert INSTANCE = Mappers.getMapper(ApplicationRemoveDTOConvert.class);
}