package com.wakedt.visual.app.organization.assembler;

import com.wakedt.visual.client.organization.dto.OrganizationRemoveDTO;
import com.wakedt.visual.domain.organization.organization.remove.OrganizationRemoveCmd;
import com.wakedt.visual.infrastructure.BaseConvert;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * OrganizationRemoveCmd和DTO转换器
 *
 * @author zhuxueliang
 */
@Mapper
public interface OrganizationRemoveDTOConvert extends
    BaseConvert<OrganizationRemoveDTO, OrganizationRemoveCmd> {

        OrganizationRemoveDTOConvert INSTANCE = Mappers.getMapper(OrganizationRemoveDTOConvert.class);
}