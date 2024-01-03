package com.wakedt.visual.app.domaindesign.assembler;

import com.wakedt.visual.client.domaindesign.dto.DomainDesignDSLUpdateDTO;
import com.wakedt.visual.domain.domaindesign.domaindesignversion.VersionStateConverter;
import com.wakedt.visual.domain.domaindesign.domaindesignversion.dslupdate.DomainDesignDslUpdateCmd;
import com.wakedt.visual.infrastructure.BaseConvert;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * DomainDesignDSLUpdateCmd和DTO转换器
 *
 * @author zhuxueliang
 */
@Mapper(uses = {
        VersionStateConverter.class,
})
public interface DomainDesignDSLUpdateDTOConvert extends
        BaseConvert<DomainDesignDSLUpdateDTO, DomainDesignDslUpdateCmd> {

    DomainDesignDSLUpdateDTOConvert INSTANCE = Mappers.getMapper(DomainDesignDSLUpdateDTOConvert.class);
}