package com.wakedt.visual.app.businessscene.assembler;

import com.wakedt.visual.client.businessscene.dto.BusinessSceneUpdateDTO;
import com.wakedt.visual.domain.businessscene.businessscene.update.BusinessSceneUpdateCmd;
import com.wakedt.visual.infrastructure.BaseConvert;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * BusinessSceneUpdateCmd和DTO转换器
 *
 * @author zhuxueliang
 */
@Mapper(uses = {
})
public interface BusinessSceneUpdateDTOConvert extends
        BaseConvert<BusinessSceneUpdateDTO, BusinessSceneUpdateCmd> {

    BusinessSceneUpdateDTOConvert INSTANCE = Mappers.getMapper(BusinessSceneUpdateDTOConvert.class);
}