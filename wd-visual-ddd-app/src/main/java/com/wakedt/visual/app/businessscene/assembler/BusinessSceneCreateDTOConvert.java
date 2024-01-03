package com.wakedt.visual.app.businessscene.assembler;

import com.wakedt.visual.client.businessscene.dto.BusinessSceneCreateDTO;
import com.wakedt.visual.domain.businessscene.businessscene.create.BusinessSceneCreateCmd;
import com.wakedt.visual.infrastructure.BaseConvert;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * BusinessSceneCreateCmd和DTO转换器
 *
 * @author zhuxueliang
 */
@Mapper(uses = {
})
public interface BusinessSceneCreateDTOConvert extends
        BaseConvert<BusinessSceneCreateDTO, BusinessSceneCreateCmd> {

    BusinessSceneCreateDTOConvert INSTANCE = Mappers.getMapper(BusinessSceneCreateDTOConvert.class);
}