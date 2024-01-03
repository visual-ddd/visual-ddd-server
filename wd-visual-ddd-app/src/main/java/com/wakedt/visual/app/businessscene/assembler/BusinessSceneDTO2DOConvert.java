package com.wakedt.visual.app.businessscene.assembler;

import com.wakedt.visual.client.businessscene.dto.BusinessSceneDTO;
import com.wakedt.visual.infrastructure.BaseConvert;
import com.wakedt.visual.infrastructure.businessscene.repository.model.BusinessSceneDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * BusinessSceneDTO和DO转换器
 *
 * @author zhuxueliang
 */
@Mapper(uses = {
        JsonConverter.class,
})
public interface BusinessSceneDTO2DOConvert extends
        BaseConvert<BusinessSceneDTO, BusinessSceneDO> {

    BusinessSceneDTO2DOConvert INSTANCE = Mappers.getMapper(BusinessSceneDTO2DOConvert.class);
}