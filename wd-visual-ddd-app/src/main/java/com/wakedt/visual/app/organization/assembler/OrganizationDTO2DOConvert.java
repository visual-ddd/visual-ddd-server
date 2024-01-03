package com.wakedt.visual.app.organization.assembler;

import com.wakedt.visual.client.organization.dto.OrganizationDTO;
import com.wakedt.visual.infrastructure.BaseConvert;
import com.wakedt.visual.infrastructure.organization.repository.model.OrganizationDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * OrganizationDTO和DO转换器
 *
 * @author zhuxueliang
 */
@Mapper
public interface OrganizationDTO2DOConvert extends
    BaseConvert<OrganizationDTO, OrganizationDO> {

    OrganizationDTO2DOConvert INSTANCE = Mappers.getMapper(OrganizationDTO2DOConvert.class);
}