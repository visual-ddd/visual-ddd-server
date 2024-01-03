package com.wakedt.visual.app.organization.view;

import com.wakedata.common.core.dto.PageResultDTO;
import com.wakedata.common.core.dto.ResultDTO;
import com.wakedt.visual.app.organization.assembler.OrganizationDTO2DOConvert;
import com.wakedt.visual.app.organization.assembler.TeamDTO2DOConvert;
import com.wakedt.visual.client.organization.dto.OrganizationDTO;
import com.wakedt.visual.client.organization.dto.TeamDTO;
import com.wakedt.visual.client.organization.query.TeamDetailQuery;
import com.wakedt.visual.domain.common.constant.MsgCodeEnum;
import com.wakedt.visual.domain.common.constant.VisualException;
import com.wakedt.visual.infrastructure.organization.repository.mapper.OrganizationMapper;
import com.wakedt.visual.infrastructure.organization.repository.mapper.TeamMapper;
import com.wakedt.visual.infrastructure.organization.repository.model.OrganizationDO;
import com.wakedt.visual.infrastructure.organization.repository.model.TeamDO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * 查询团队详情信息-查询器
 *
 * @author zhuxueliang
 */
@Component
public class TeamDetailQueryExe {

    @Resource
    private TeamMapper teamMapper;
    @Resource
    private OrganizationMapper organizationMapper;

    public ResultDTO<TeamDTO> execute(TeamDetailQuery query) {
        TeamDO teamDO = Optional.ofNullable(teamMapper.teamDetailQuery(query))
                .orElseThrow(() -> new VisualException(MsgCodeEnum.NO_FIND_RESOURCE));
        TeamDTO teamDTO = TeamDTO2DOConvert.INSTANCE.do2Dto(teamDO);
        Long organizationId = teamDTO.getOrganizationId();
        teamDTO.setOrganizationDTO(getOrganizationDTO(organizationId));
        return PageResultDTO.success(teamDTO);
    }

    private OrganizationDTO getOrganizationDTO(Long organizationId) {
        OrganizationDO organizationDO = organizationMapper.selectById(organizationId);
        return OrganizationDTO2DOConvert.INSTANCE.do2Dto(organizationDO);
    }

}
