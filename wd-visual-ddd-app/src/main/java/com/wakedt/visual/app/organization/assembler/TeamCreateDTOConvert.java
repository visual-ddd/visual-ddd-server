package com.wakedt.visual.app.organization.assembler;

import com.wakedt.visual.client.organization.dto.TeamCreateDTO;
import com.wakedt.visual.domain.organization.team.create.TeamCreateCmd;
import com.wakedt.visual.infrastructure.BaseConvert;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * TeamCreateCmd和DTO转换器
 *
 * @author zhuxueliang
 */
@Mapper
public interface TeamCreateDTOConvert extends
    BaseConvert<TeamCreateDTO, TeamCreateCmd> {

        TeamCreateDTOConvert INSTANCE = Mappers.getMapper(TeamCreateDTOConvert.class);
}