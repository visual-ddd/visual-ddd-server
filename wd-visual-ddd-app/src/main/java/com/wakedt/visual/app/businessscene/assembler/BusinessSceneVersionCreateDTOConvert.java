package com.wakedt.visual.app.businessscene.assembler;

import com.wakedt.visual.client.businessscene.dto.BusinessSceneVersionCreateDTO;
import com.wakedt.visual.domain.businessscene.businesssceneversion.VersionStateConverter;
import com.wakedt.visual.domain.businessscene.businesssceneversion.create.BusinessSceneVersionCreateCmd;
import com.wakedt.visual.infrastructure.BaseConvert;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * BusinessSceneVersionCreateCmd和DTO转换器
 *
 * @author zhuxueliang
 */
@Mapper(uses = {
        VersionStateConverter.class,
})
public interface BusinessSceneVersionCreateDTOConvert extends
        BaseConvert<BusinessSceneVersionCreateDTO, BusinessSceneVersionCreateCmd> {

    BusinessSceneVersionCreateDTOConvert INSTANCE = Mappers.getMapper(BusinessSceneVersionCreateDTOConvert.class);
}