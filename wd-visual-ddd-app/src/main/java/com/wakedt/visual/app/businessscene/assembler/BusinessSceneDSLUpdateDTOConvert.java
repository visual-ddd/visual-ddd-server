package com.wakedt.visual.app.businessscene.assembler;

import com.wakedt.visual.client.businessscene.dto.BusinessSceneDSLUpdateDTO;
import com.wakedt.visual.domain.businessscene.businesssceneversion.VersionStateConverter;
import com.wakedt.visual.domain.businessscene.businesssceneversion.dslupdate.BusinessSceneDSLUpdateCmd;
import com.wakedt.visual.infrastructure.BaseConvert;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * BusinessSceneDSLUpdateCmd和DTO转换器
 *
 * @author zhuxueliang
 */
@Mapper(uses = {
        VersionStateConverter.class,
})
public interface BusinessSceneDSLUpdateDTOConvert extends
        BaseConvert<BusinessSceneDSLUpdateDTO, BusinessSceneDSLUpdateCmd> {

    BusinessSceneDSLUpdateDTOConvert INSTANCE = Mappers.getMapper(BusinessSceneDSLUpdateDTOConvert.class);
}