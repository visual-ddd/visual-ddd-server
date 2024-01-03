package com.wakedt.visual.infrastructure.organization.assembler;

import com.wakedt.visual.domain.organization.teammember.MemberTypeConverter;
import com.wakedt.visual.domain.organization.teammember.TeamMember;
import com.wakedt.visual.infrastructure.BaseConvert;
import com.wakedt.visual.infrastructure.organization.repository.model.TeamMemberDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * TeamMember和DO转换器
 *
 * @author zhuxueliang
 */
@Mapper(
        uses = MemberTypeConverter.class
)
public interface TeamMemberDoConvert extends
        BaseConvert<TeamMember, TeamMemberDO> {

    TeamMemberDoConvert INSTANCE = Mappers.getMapper(TeamMemberDoConvert.class);
}
