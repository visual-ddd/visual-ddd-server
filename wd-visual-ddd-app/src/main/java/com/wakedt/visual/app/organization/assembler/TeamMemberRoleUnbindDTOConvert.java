package com.wakedt.visual.app.organization.assembler;

import com.wakedt.visual.client.organization.dto.TeamMemberRoleUnbindDTO;
import com.wakedt.visual.domain.organization.teammember.MemberTypeConverter;
import com.wakedt.visual.domain.organization.teammember.memberroleunbind.TeamMemberRoleUnbindCmd;
import com.wakedt.visual.infrastructure.BaseConvert;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * TeamMemberRoleUnbindCmd和DTO转换器
 *
 * @author zhuxueliang
 */
@Mapper(
        uses = MemberTypeConverter.class
)
public interface TeamMemberRoleUnbindDTOConvert extends
        BaseConvert<TeamMemberRoleUnbindDTO, TeamMemberRoleUnbindCmd> {

    TeamMemberRoleUnbindDTOConvert INSTANCE = Mappers.getMapper(TeamMemberRoleUnbindDTOConvert.class);
}