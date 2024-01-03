package com.wakedt.visual.app.organization.assembler;

import com.wakedt.visual.client.organization.dto.TeamManagerBindDTO;
import com.wakedt.visual.domain.organization.team.managerbind.TeamManagerBindCmd;
import com.wakedt.visual.infrastructure.BaseConvert;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * TeamManagerBindCmd和DTO转换器
 *
 * @author zhuxueliang
 */
@Mapper
public interface TeamManagerBindDTOConvert extends
    BaseConvert<TeamManagerBindDTO, TeamManagerBindCmd> {

        TeamManagerBindDTOConvert INSTANCE = Mappers.getMapper(TeamManagerBindDTOConvert.class);
}