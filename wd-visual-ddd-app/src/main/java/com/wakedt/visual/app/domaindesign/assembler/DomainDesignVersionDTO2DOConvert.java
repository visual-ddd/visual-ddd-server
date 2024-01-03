package com.wakedt.visual.app.domaindesign.assembler;

import com.wakedt.visual.client.domaindesign.dto.DomainDesignVersionDTO;
import com.wakedt.visual.infrastructure.BaseConvert;
import com.wakedt.visual.infrastructure.domaindesign.repository.model.DomainDesignVersionDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * DomainDesignVersionDTO和DO转换器
 *
 * @author zhuxueliang
 */
@Mapper(uses = {
        JsonConverter.class,
})
public interface DomainDesignVersionDTO2DOConvert extends
        BaseConvert<DomainDesignVersionDTO, DomainDesignVersionDO> {

    DomainDesignVersionDTO2DOConvert INSTANCE = Mappers.getMapper(DomainDesignVersionDTO2DOConvert.class);
}