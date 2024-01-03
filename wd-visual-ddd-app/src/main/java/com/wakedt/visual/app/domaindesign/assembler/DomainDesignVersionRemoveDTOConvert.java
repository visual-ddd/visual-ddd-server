package com.wakedt.visual.app.domaindesign.assembler;

import com.wakedt.visual.client.domaindesign.dto.DomainDesignVersionRemoveDTO;
import com.wakedt.visual.domain.domaindesign.domaindesignversion.VersionStateConverter;
import com.wakedt.visual.domain.domaindesign.domaindesignversion.remove.DomainDesignVersionRemoveCmd;
import com.wakedt.visual.infrastructure.BaseConvert;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * DomainDesignVersionRemoveCmd和DTO转换器
 *
 * @author zhuxueliang
 */
@Mapper(uses = {
        VersionStateConverter.class,
})
public interface DomainDesignVersionRemoveDTOConvert extends
        BaseConvert<DomainDesignVersionRemoveDTO, DomainDesignVersionRemoveCmd> {

    DomainDesignVersionRemoveDTOConvert INSTANCE = Mappers.getMapper(DomainDesignVersionRemoveDTOConvert.class);
}