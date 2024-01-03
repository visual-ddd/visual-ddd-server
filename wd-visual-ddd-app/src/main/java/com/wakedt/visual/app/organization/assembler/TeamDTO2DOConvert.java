package com.wakedt.visual.app.organization.assembler;

import com.wakedt.visual.client.organization.dto.TeamDTO;
import com.wakedt.visual.infrastructure.BaseConvert;
import com.wakedt.visual.infrastructure.organization.repository.model.TeamDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * TeamDTO和DO转换器
 *
 * @author zhuxueliang
 */
@Mapper
public interface TeamDTO2DOConvert extends
    BaseConvert<TeamDTO, TeamDO> {

    TeamDTO2DOConvert INSTANCE = Mappers.getMapper(TeamDTO2DOConvert.class);
}