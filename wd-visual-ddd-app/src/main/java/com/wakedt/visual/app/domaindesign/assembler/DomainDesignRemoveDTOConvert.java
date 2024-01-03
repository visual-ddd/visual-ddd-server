package com.wakedt.visual.app.domaindesign.assembler;

import com.wakedt.visual.client.domaindesign.dto.DomainDesignRemoveDTO;
import com.wakedt.visual.domain.domaindesign.domaindesign.remove.DomainDesignRemoveCmd;
import com.wakedt.visual.infrastructure.BaseConvert;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * DomainDesignRemoveCmd和DTO转换器
 *
 * @author zhuxueliang
 */
@Mapper(uses = {
})
public interface DomainDesignRemoveDTOConvert extends
        BaseConvert<DomainDesignRemoveDTO, DomainDesignRemoveCmd> {

    DomainDesignRemoveDTOConvert INSTANCE = Mappers.getMapper(DomainDesignRemoveDTOConvert.class);
}