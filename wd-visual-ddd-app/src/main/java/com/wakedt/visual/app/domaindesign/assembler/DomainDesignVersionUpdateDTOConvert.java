package com.wakedt.visual.app.domaindesign.assembler;

import com.wakedt.visual.client.domaindesign.dto.DomainDesignVersionUpdateDTO;
import com.wakedt.visual.domain.domaindesign.domaindesignversion.VersionStateConverter;
import com.wakedt.visual.domain.domaindesign.domaindesignversion.update.DomainDesignVersionUpdateCmd;
import com.wakedt.visual.infrastructure.BaseConvert;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * DomainDesignVersionUpdateCmd和DTO转换器
 *
 * @author zhuxueliang
 */
@Mapper(uses = {
        VersionStateConverter.class,
})
public interface DomainDesignVersionUpdateDTOConvert extends
        BaseConvert<DomainDesignVersionUpdateDTO, DomainDesignVersionUpdateCmd> {

    DomainDesignVersionUpdateDTOConvert INSTANCE = Mappers.getMapper(DomainDesignVersionUpdateDTOConvert.class);
}