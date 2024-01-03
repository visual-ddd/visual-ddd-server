package com.wakedt.visual.infrastructure.application.assembler;

import com.wakedt.visual.domain.application.applicationversion.ApplicationVersion;
import com.wakedt.visual.domain.application.applicationversion.VersionStateConverter;
import com.wakedt.visual.infrastructure.BaseConvert;
import com.wakedt.visual.infrastructure.application.repository.model.ApplicationVersionDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * ApplicationVersion和DO转换器
 *
 * @author zhuxueliang
 */
@Mapper(uses = {
        JsonConverter.class,
        VersionStateConverter.class,
})
public interface ApplicationVersionDoConvert extends
        BaseConvert<ApplicationVersion, ApplicationVersionDO> {

    ApplicationVersionDoConvert INSTANCE = Mappers.getMapper(ApplicationVersionDoConvert.class);
}
