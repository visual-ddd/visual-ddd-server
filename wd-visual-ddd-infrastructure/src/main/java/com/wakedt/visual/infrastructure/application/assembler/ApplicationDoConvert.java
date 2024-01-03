package com.wakedt.visual.infrastructure.application.assembler;

import com.wakedt.visual.domain.application.application.Application;
import com.wakedt.visual.infrastructure.BaseConvert;
import com.wakedt.visual.infrastructure.application.repository.model.ApplicationDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Application和DO转换器
 *
 * @author zhuxueliang
 */
@Mapper(uses = {
})
public interface ApplicationDoConvert extends
        BaseConvert<Application, ApplicationDO> {

    ApplicationDoConvert INSTANCE = Mappers.getMapper(ApplicationDoConvert.class);
}
