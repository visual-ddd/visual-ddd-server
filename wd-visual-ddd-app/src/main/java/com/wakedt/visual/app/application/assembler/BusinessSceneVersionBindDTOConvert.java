package com.wakedt.visual.app.application.assembler;

import com.wakedt.visual.client.application.dto.BusinessSceneVersionBindDTO;
import com.wakedt.visual.domain.application.applicationversion.VersionStateConverter;
import com.wakedt.visual.domain.application.applicationversion.businesssceneversionbind.BusinessSceneVersionBindCmd;
import com.wakedt.visual.infrastructure.BaseConvert;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * BusinessSceneVersionBindCmd和DTO转换器
 *
 * @author zhuxueliang
 */
@Mapper(uses = {
        VersionStateConverter.class,
})
public interface BusinessSceneVersionBindDTOConvert extends
        BaseConvert<BusinessSceneVersionBindDTO, BusinessSceneVersionBindCmd> {

    BusinessSceneVersionBindDTOConvert INSTANCE = Mappers.getMapper(BusinessSceneVersionBindDTOConvert.class);
}