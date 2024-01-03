package com.wakedt.visual.app.domaindesign.assembler;

import com.wakedt.visual.client.domaindesign.dto.DomainDesignCreateDTO;
import com.wakedt.visual.domain.domaindesign.domaindesign.create.DomainDesignCreateCmd;
import com.wakedt.visual.infrastructure.BaseConvert;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * DomainDesignCreateCmd和DTO转换器
 *
 * @author zhuxueliang
 */
@Mapper(uses = {
})
public interface DomainDesignCreateDTOConvert extends
        BaseConvert<DomainDesignCreateDTO, DomainDesignCreateCmd> {

    DomainDesignCreateDTOConvert INSTANCE = Mappers.getMapper(DomainDesignCreateDTOConvert.class);
}