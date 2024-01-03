package com.wakedt.visual.app.organization.assembler;

import com.wakedt.visual.client.organization.dto.OrganizationManagerUnbindDTO;
import com.wakedt.visual.domain.organization.organization.managerunbind.OrganizationManagerUnbindCmd;
import com.wakedt.visual.infrastructure.BaseConvert;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * OrganizationManagerUnbindCmd和DTO转换器
 *
 * @author zhuxueliang
 */
@Mapper
public interface OrganizationManagerUnbindDTOConvert extends
    BaseConvert<OrganizationManagerUnbindDTO, OrganizationManagerUnbindCmd> {

        OrganizationManagerUnbindDTOConvert INSTANCE = Mappers.getMapper(OrganizationManagerUnbindDTOConvert.class);
}