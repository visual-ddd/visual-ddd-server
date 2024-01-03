package com.wakedt.visual.app.organization.assembler;

import com.wakedt.visual.client.organization.dto.TeamMemberDTO;
import com.wakedt.visual.infrastructure.BaseConvert;
import com.wakedt.visual.infrastructure.organization.repository.model.TeamMemberDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * TeamMemberDTO和DO转换器
 *
 * @author zhuxueliang
 */
@Mapper(uses = {
        JsonConverter.class,
})
public interface TeamMemberDTO2DOConvert extends
        BaseConvert<TeamMemberDTO, TeamMemberDO> {

    TeamMemberDTO2DOConvert INSTANCE = Mappers.getMapper(TeamMemberDTO2DOConvert.class);
}