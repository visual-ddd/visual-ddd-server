package com.wakedt.visual.infrastructure.businessscene.assembler;

import com.wakedt.visual.domain.businessscene.businesssceneversion.BusinessSceneVersion;
import com.wakedt.visual.domain.businessscene.businesssceneversion.VersionStateConverter;
import com.wakedt.visual.infrastructure.BaseConvert;
import com.wakedt.visual.infrastructure.businessscene.repository.model.BusinessSceneVersionDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * BusinessSceneVersion和DO转换器
 *
 * @author zhuxueliang
 */
@Mapper(uses = {
        VersionStateConverter.class,
})
public interface BusinessSceneVersionDoConvert extends
        BaseConvert<BusinessSceneVersion, BusinessSceneVersionDO> {

    BusinessSceneVersionDoConvert INSTANCE = Mappers.getMapper(BusinessSceneVersionDoConvert.class);
}
