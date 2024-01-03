package com.wakedt.visual.app.businessscene.assembler;

import com.wakedt.visual.client.businessscene.dto.BusinessSceneRemoveDTO;
import com.wakedt.visual.domain.businessscene.businessscene.remove.BusinessSceneRemoveCmd;
import com.wakedt.visual.infrastructure.BaseConvert;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * BusinessSceneRemoveCmd和DTO转换器
 *
 * @author zhuxueliang
 */
@Mapper(uses = {
})
public interface BusinessSceneRemoveDTOConvert extends
        BaseConvert<BusinessSceneRemoveDTO, BusinessSceneRemoveCmd> {

    BusinessSceneRemoveDTOConvert INSTANCE = Mappers.getMapper(BusinessSceneRemoveDTOConvert.class);
}