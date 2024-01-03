package com.wakedt.visual.app.organization.assembler;

import com.wakedt.visual.client.organization.dto.OrganizationCreateDTO;
import com.wakedt.visual.domain.organization.organization.create.OrganizationCreateCmd;
import com.wakedt.visual.infrastructure.BaseConvert;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * OrganizationCreateCmd和DTO转换器
 *
 * @author zhuxueliang
 */
@Mapper
public interface OrganizationCreateDTOConvert extends
    BaseConvert<OrganizationCreateDTO, OrganizationCreateCmd> {

        OrganizationCreateDTOConvert INSTANCE = Mappers.getMapper(OrganizationCreateDTOConvert.class);
}