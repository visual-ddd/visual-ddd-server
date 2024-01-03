package com.wakedt.visual.infrastructure.domaindesign.assembler;

import com.wakedt.visual.domain.domaindesign.domaindesign.DomainDesign;
import com.wakedt.visual.infrastructure.BaseConvert;
import com.wakedt.visual.infrastructure.domaindesign.repository.model.DomainDesignDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * DomainDesign和DO转换器
 *
 * @author zhuxueliang
 */
@Mapper(uses = {
})
public interface DomainDesignDoConvert extends
        BaseConvert<DomainDesign, DomainDesignDO> {

    DomainDesignDoConvert INSTANCE = Mappers.getMapper(DomainDesignDoConvert.class);
}
