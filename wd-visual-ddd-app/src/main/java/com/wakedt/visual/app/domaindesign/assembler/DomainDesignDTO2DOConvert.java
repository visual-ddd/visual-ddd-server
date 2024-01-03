package com.wakedt.visual.app.domaindesign.assembler;

import com.wakedt.visual.client.domaindesign.dto.DomainDesignDTO;
import com.wakedt.visual.infrastructure.BaseConvert;
import com.wakedt.visual.infrastructure.domaindesign.repository.model.DomainDesignDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * DomainDesignDTO和DO转换器
 *
 * @author zhuxueliang
 */
@Mapper(uses = {
        JsonConverter.class,
})
public interface DomainDesignDTO2DOConvert extends
        BaseConvert<DomainDesignDTO, DomainDesignDO> {

    DomainDesignDTO2DOConvert INSTANCE = Mappers.getMapper(DomainDesignDTO2DOConvert.class);
}