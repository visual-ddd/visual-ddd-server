package com.wakedt.visual.app.businessscene.assembler;

import com.wakedt.visual.client.businessscene.dto.BusinessSceneVersionRemoveDTO;
import com.wakedt.visual.domain.businessscene.businesssceneversion.VersionStateConverter;
import com.wakedt.visual.domain.businessscene.businesssceneversion.remove.BusinessSceneVersionRemoveCmd;
import com.wakedt.visual.infrastructure.BaseConvert;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * BusinessSceneVersionRemoveCmd和DTO转换器
 *
 * @author zhuxueliang
 */
@Mapper(uses = {
        VersionStateConverter.class,
})
public interface BusinessSceneVersionRemoveDTOConvert extends
        BaseConvert<BusinessSceneVersionRemoveDTO, BusinessSceneVersionRemoveCmd> {

    BusinessSceneVersionRemoveDTOConvert INSTANCE = Mappers.getMapper(BusinessSceneVersionRemoveDTOConvert.class);
}