package com.wakedt.visual.infrastructure.organization.assembler;

import com.wakedt.visual.domain.organization.team.Team;
import com.wakedt.visual.infrastructure.BaseConvert;
import com.wakedt.visual.infrastructure.organization.repository.model.TeamDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Team和DO转换器
 *
 * @author zhuxueliang
 */
@Mapper
public interface TeamDoConvert extends
    BaseConvert<Team, TeamDO> {

    TeamDoConvert INSTANCE = Mappers.getMapper(TeamDoConvert.class);
}
