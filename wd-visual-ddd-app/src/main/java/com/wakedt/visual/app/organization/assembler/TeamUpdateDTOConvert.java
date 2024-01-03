package com.wakedt.visual.app.organization.assembler;

import com.wakedt.visual.client.organization.dto.TeamUpdateDTO;
import com.wakedt.visual.domain.organization.team.update.TeamUpdateCmd;
import com.wakedt.visual.infrastructure.BaseConvert;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * TeamUpdateCmd和DTO转换器
 *
 * @author zhuxueliang
 */
@Mapper
public interface TeamUpdateDTOConvert extends
    BaseConvert<TeamUpdateDTO, TeamUpdateCmd> {

        TeamUpdateDTOConvert INSTANCE = Mappers.getMapper(TeamUpdateDTOConvert.class);
}