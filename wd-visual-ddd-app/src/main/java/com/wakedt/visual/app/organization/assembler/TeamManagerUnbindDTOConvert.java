package com.wakedt.visual.app.organization.assembler;

import com.wakedt.visual.client.organization.dto.TeamManagerUnbindDTO;
import com.wakedt.visual.domain.organization.team.managerunbind.TeamManagerUnbindCmd;
import com.wakedt.visual.infrastructure.BaseConvert;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * TeamManagerUnbindCmd和DTO转换器
 *
 * @author zhuxueliang
 */
@Mapper
public interface TeamManagerUnbindDTOConvert extends
    BaseConvert<TeamManagerUnbindDTO, TeamManagerUnbindCmd> {

        TeamManagerUnbindDTOConvert INSTANCE = Mappers.getMapper(TeamManagerUnbindDTOConvert.class);
}