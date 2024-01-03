package com.wakedt.visual.infrastructure.organization.assembler;

import com.wakedt.visual.domain.organization.organization.Organization;
import com.wakedt.visual.infrastructure.BaseConvert;
import com.wakedt.visual.infrastructure.organization.repository.model.OrganizationDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Organization和DO转换器
 *
 * @author zhuxueliang
 */
@Mapper
public interface OrganizationDoConvert extends
    BaseConvert<Organization, OrganizationDO> {

    OrganizationDoConvert INSTANCE = Mappers.getMapper(OrganizationDoConvert.class);
}
