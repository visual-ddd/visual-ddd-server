package com.wakedt.visual.app.domaindesign.assembler;

import com.wakedt.visual.client.domaindesign.dto.DomainDesignVersionCreateDTO;
import com.wakedt.visual.domain.domaindesign.domaindesignversion.VersionStateConverter;
import com.wakedt.visual.domain.domaindesign.domaindesignversion.create.DomainDesignVersionCreateCmd;
import com.wakedt.visual.infrastructure.BaseConvert;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * DomainDesignVersionCreateCmd和DTO转换器
 *
 * @author zhuxueliang
 */
@Mapper(uses = {
        VersionStateConverter.class,
})
public interface DomainDesignVersionCreateDTOConvert extends
        BaseConvert<DomainDesignVersionCreateDTO, DomainDesignVersionCreateCmd> {

    DomainDesignVersionCreateDTOConvert INSTANCE = Mappers.getMapper(DomainDesignVersionCreateDTOConvert.class);
}