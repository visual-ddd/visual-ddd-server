package com.wakedt.visual.app.application.assembler;

import com.wakedt.visual.client.application.dto.ApplicationVersionPublishDTO;
import com.wakedt.visual.domain.application.applicationversion.VersionStateConverter;
import com.wakedt.visual.domain.application.applicationversion.versionpublish.ApplicationVersionPublishCmd;
import com.wakedt.visual.infrastructure.BaseConvert;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * ApplicationVersionPublishCmd和DTO转换器
 *
 * @author zhuxueliang
 */
@Mapper(uses = {
        VersionStateConverter.class,
})
public interface ApplicationVersionPublishDTOConvert extends
        BaseConvert<ApplicationVersionPublishDTO, ApplicationVersionPublishCmd> {

    ApplicationVersionPublishDTOConvert INSTANCE = Mappers.getMapper(ApplicationVersionPublishDTOConvert.class);
}