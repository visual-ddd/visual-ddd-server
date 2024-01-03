package com.wakedt.visual.app.domaindesign.assembler;

import com.wakedt.visual.client.domaindesign.dto.DomainDesignVersionPublishDTO;
import com.wakedt.visual.domain.domaindesign.domaindesignversion.VersionStateConverter;
import com.wakedt.visual.domain.domaindesign.domaindesignversion.versionpblish.DomainDesignVersionPublishCmd;
import com.wakedt.visual.infrastructure.BaseConvert;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * DomainDesignVersionPublishCmd和DTO转换器
 *
 * @author zhuxueliang
 */
@Mapper(uses = {
        VersionStateConverter.class,
})
public interface DomainDesignVersionPublishDTOConvert extends
        BaseConvert<DomainDesignVersionPublishDTO, DomainDesignVersionPublishCmd> {

    DomainDesignVersionPublishDTOConvert INSTANCE = Mappers.getMapper(DomainDesignVersionPublishDTOConvert.class);
}