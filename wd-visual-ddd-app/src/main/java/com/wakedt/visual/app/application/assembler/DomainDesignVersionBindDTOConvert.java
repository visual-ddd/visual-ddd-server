package com.wakedt.visual.app.application.assembler;

import com.wakedt.visual.client.application.dto.DomainDesignVersionBindDTO;
import com.wakedt.visual.domain.application.applicationversion.VersionStateConverter;
import com.wakedt.visual.domain.application.applicationversion.domaindesignversionbind.DomainDesignVersionBindCmd;
import com.wakedt.visual.infrastructure.BaseConvert;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * DomainDesignVersionBindCmd和DTO转换器
 *
 * @author zhuxueliang
 */
@Mapper(uses = {
        VersionStateConverter.class,
})
public interface DomainDesignVersionBindDTOConvert extends
        BaseConvert<DomainDesignVersionBindDTO, DomainDesignVersionBindCmd> {

    DomainDesignVersionBindDTOConvert INSTANCE = Mappers.getMapper(DomainDesignVersionBindDTOConvert.class);
}