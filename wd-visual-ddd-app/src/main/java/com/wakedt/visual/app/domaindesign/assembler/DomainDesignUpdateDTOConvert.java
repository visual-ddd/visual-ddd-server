package com.wakedt.visual.app.domaindesign.assembler;

import com.wakedt.visual.client.domaindesign.dto.DomainDesignUpdateDTO;
import com.wakedt.visual.domain.domaindesign.domaindesign.update.DomainDesignUpdateCmd;
import com.wakedt.visual.infrastructure.BaseConvert;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * DomainDesignUpdateCmd和DTO转换器
 *
 * @author zhuxueliang
 */
@Mapper(uses = {
})
public interface DomainDesignUpdateDTOConvert extends
        BaseConvert<DomainDesignUpdateDTO, DomainDesignUpdateCmd> {

    DomainDesignUpdateDTOConvert INSTANCE = Mappers.getMapper(DomainDesignUpdateDTOConvert.class);
}