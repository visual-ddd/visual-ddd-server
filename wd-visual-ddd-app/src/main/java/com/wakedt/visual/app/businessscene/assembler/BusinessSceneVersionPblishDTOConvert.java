package com.wakedt.visual.app.businessscene.assembler;

import com.wakedt.visual.client.businessscene.dto.BusinessSceneVersionPublishDTO;
import com.wakedt.visual.domain.businessscene.businesssceneversion.VersionStateConverter;
import com.wakedt.visual.domain.businessscene.businesssceneversion.versionpblish.BusinessSceneVersionPublishCmd;
import com.wakedt.visual.infrastructure.BaseConvert;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * BusinessSceneVersionPblishCmd和DTO转换器
 *
 * @author zhuxueliang
 */
@Mapper(uses = {
        VersionStateConverter.class,
})
public interface BusinessSceneVersionPblishDTOConvert extends
        BaseConvert<BusinessSceneVersionPublishDTO, BusinessSceneVersionPublishCmd> {

    BusinessSceneVersionPblishDTOConvert INSTANCE = Mappers.getMapper(BusinessSceneVersionPblishDTOConvert.class);
}