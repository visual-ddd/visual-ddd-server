package com.wakedt.visual.app.organization.assembler;

import com.wakedt.visual.client.organization.dto.TeamMemberAddDTO;
import com.wakedt.visual.domain.organization.teammember.MemberTypeConverter;
import com.wakedt.visual.domain.organization.teammember.memberadd.TeamMemberAddCmd;
import com.wakedt.visual.infrastructure.BaseConvert;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * TeamMemberAddCmd和DTO转换器
 *
 * @author zhuxueliang
 */
@Mapper(
        uses = MemberTypeConverter.class
)
public interface TeamMemberAddDTOConvert extends
    BaseConvert<TeamMemberAddDTO, TeamMemberAddCmd> {

        TeamMemberAddDTOConvert INSTANCE = Mappers.getMapper(TeamMemberAddDTOConvert.class);
}