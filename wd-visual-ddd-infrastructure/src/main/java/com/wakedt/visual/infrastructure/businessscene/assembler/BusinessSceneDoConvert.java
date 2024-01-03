package com.wakedt.visual.infrastructure.businessscene.assembler;

import com.wakedt.visual.domain.businessscene.businessscene.BusinessScene;
import com.wakedt.visual.infrastructure.BaseConvert;
import com.wakedt.visual.infrastructure.businessscene.repository.model.BusinessSceneDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * BusinessScene和DO转换器
 *
 * @author zhuxueliang
 */
@Mapper(uses = {
})
public interface BusinessSceneDoConvert extends
        BaseConvert<BusinessScene, BusinessSceneDO> {

    BusinessSceneDoConvert INSTANCE = Mappers.getMapper(BusinessSceneDoConvert.class);
}
