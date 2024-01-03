package com.wakedt.visual.app.organization.assembler;

import com.wakedt.visual.client.organization.dto.TeamMemberRoleBindDTO;
import com.wakedt.visual.domain.organization.teammember.MemberTypeConverter;
import com.wakedt.visual.domain.organization.teammember.memberrolebind.TeamMemberRoleBindCmd;
import com.wakedt.visual.infrastructure.BaseConvert;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * TeamMemberRoleBindCmd和DTO转换器
 *
 * @author zhuxueliang
 */
@Mapper(
        uses = MemberTypeConverter.class
)
public interface TeamMemberRoleBindDTOConvert extends
        BaseConvert<TeamMemberRoleBindDTO, TeamMemberRoleBindCmd> {

    TeamMemberRoleBindDTOConvert INSTANCE = Mappers.getMapper(TeamMemberRoleBindDTOConvert.class);
}