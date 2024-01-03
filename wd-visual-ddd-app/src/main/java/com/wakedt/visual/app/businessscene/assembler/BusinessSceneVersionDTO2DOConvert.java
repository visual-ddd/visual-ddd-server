package com.wakedt.visual.app.businessscene.assembler;

import com.wakedt.visual.client.businessscene.dto.BusinessSceneVersionDTO;
import com.wakedt.visual.infrastructure.BaseConvert;
import com.wakedt.visual.infrastructure.businessscene.repository.model.BusinessSceneVersionDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * BusinessSceneVersionDTO和DO转换器
 *
 * @author zhuxueliang
 */
@Mapper(uses = {
        JsonConverter.class,
})
public interface BusinessSceneVersionDTO2DOConvert extends
        BaseConvert<BusinessSceneVersionDTO, BusinessSceneVersionDO> {

    BusinessSceneVersionDTO2DOConvert INSTANCE = Mappers.getMapper(BusinessSceneVersionDTO2DOConvert.class);
}