package com.wakedt.visual.app.businessscene.assembler;

import com.wakedt.visual.client.businessscene.dto.BusinessSceneVersionUpdateDTO;
import com.wakedt.visual.domain.businessscene.businesssceneversion.VersionStateConverter;
import com.wakedt.visual.domain.businessscene.businesssceneversion.update.BusinessSceneVersionUpdateCmd;
import com.wakedt.visual.infrastructure.BaseConvert;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * BusinessSceneVersionUpdateCmd和DTO转换器
 *
 * @author zhuxueliang
 */
@Mapper(uses = {
        VersionStateConverter.class,
})
public interface BusinessSceneVersionUpdateDTOConvert extends
        BaseConvert<BusinessSceneVersionUpdateDTO, BusinessSceneVersionUpdateCmd> {

    BusinessSceneVersionUpdateDTOConvert INSTANCE = Mappers.getMapper(BusinessSceneVersionUpdateDTOConvert.class);
}