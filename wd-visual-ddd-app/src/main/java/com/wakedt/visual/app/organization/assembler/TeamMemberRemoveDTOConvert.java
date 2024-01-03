package com.wakedt.visual.app.organization.assembler;

import com.wakedt.visual.client.organization.dto.TeamMemberRemoveDTO;
import com.wakedt.visual.domain.organization.teammember.memberremove.TeamMemberRemoveCmd;
import com.wakedt.visual.infrastructure.BaseConvert;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * TeamMemberRemoveCmd和DTO转换器
 *
 * @author zhuxueliang
 */
@Mapper
public interface TeamMemberRemoveDTOConvert extends
    BaseConvert<TeamMemberRemoveDTO, TeamMemberRemoveCmd> {

        TeamMemberRemoveDTOConvert INSTANCE = Mappers.getMapper(TeamMemberRemoveDTOConvert.class);
}