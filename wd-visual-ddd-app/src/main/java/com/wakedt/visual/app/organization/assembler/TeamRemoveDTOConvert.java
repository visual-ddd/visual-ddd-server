package com.wakedt.visual.app.organization.assembler;

import com.wakedt.visual.client.organization.dto.TeamRemoveDTO;
import com.wakedt.visual.domain.organization.team.remove.TeamRemoveCmd;
import com.wakedt.visual.infrastructure.BaseConvert;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * TeamRemoveCmd和DTO转换器
 *
 * @author zhuxueliang
 */
@Mapper
public interface TeamRemoveDTOConvert extends
    BaseConvert<TeamRemoveDTO, TeamRemoveCmd> {

        TeamRemoveDTOConvert INSTANCE = Mappers.getMapper(TeamRemoveDTOConvert.class);
}