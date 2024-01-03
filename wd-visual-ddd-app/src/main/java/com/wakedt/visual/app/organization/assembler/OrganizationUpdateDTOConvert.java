package com.wakedt.visual.app.organization.assembler;

import com.wakedt.visual.client.organization.dto.OrganizationUpdateDTO;
import com.wakedt.visual.domain.organization.organization.update.OrganizationUpdateCmd;
import com.wakedt.visual.infrastructure.BaseConvert;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * OrganizationUpdateCmd和DTO转换器
 *
 * @author zhuxueliang
 */
@Mapper
public interface OrganizationUpdateDTOConvert extends
    BaseConvert<OrganizationUpdateDTO, OrganizationUpdateCmd> {

        OrganizationUpdateDTOConvert INSTANCE = Mappers.getMapper(OrganizationUpdateDTOConvert.class);
}