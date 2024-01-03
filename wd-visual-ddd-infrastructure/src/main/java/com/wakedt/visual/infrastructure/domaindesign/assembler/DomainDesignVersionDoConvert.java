package com.wakedt.visual.infrastructure.domaindesign.assembler;

import com.wakedt.visual.domain.domaindesign.domaindesignversion.DomainDesignVersion;
import com.wakedt.visual.domain.domaindesign.domaindesignversion.VersionStateConverter;
import com.wakedt.visual.infrastructure.BaseConvert;
import com.wakedt.visual.infrastructure.domaindesign.repository.model.DomainDesignVersionDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * DomainDesignVersion和DO转换器
 *
 * @author zhuxueliang
 */
@Mapper(uses = {
        VersionStateConverter.class,
})
public interface DomainDesignVersionDoConvert extends
        BaseConvert<DomainDesignVersion, DomainDesignVersionDO> {

    DomainDesignVersionDoConvert INSTANCE = Mappers.getMapper(DomainDesignVersionDoConvert.class);
}
