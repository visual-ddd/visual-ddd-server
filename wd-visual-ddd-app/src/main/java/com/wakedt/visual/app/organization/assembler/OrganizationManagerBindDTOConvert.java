package com.wakedt.visual.app.organization.assembler;

import com.wakedt.visual.client.organization.dto.OrganizationManagerBindDTO;
import com.wakedt.visual.domain.organization.organization.managerbind.OrganizationManagerBindCmd;
import com.wakedt.visual.infrastructure.BaseConvert;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * OrganizationManagerBindCmd和DTO转换器
 *
 * @author zhuxueliang
 */
@Mapper
public interface OrganizationManagerBindDTOConvert extends
    BaseConvert<OrganizationManagerBindDTO, OrganizationManagerBindCmd> {

        OrganizationManagerBindDTOConvert INSTANCE = Mappers.getMapper(OrganizationManagerBindDTOConvert.class);
}