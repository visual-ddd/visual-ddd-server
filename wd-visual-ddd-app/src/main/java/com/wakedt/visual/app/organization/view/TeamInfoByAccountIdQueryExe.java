package com.wakedt.visual.app.organization.view;

import com.wakedata.common.core.dto.ResultDTO;
import com.wakedata.common.core.util.BeanUtil;
import com.wakedt.visual.app.organization.assembler.TeamDTO2DOConvert;
import com.wakedt.visual.client.organization.dto.OrganizationDTO;
import com.wakedt.visual.client.organization.dto.TeamDTO;
import com.wakedt.visual.infrastructure.organization.repository.mapper.OrganizationMapper;
import com.wakedt.visual.infrastructure.organization.repository.mapper.TeamMapper;
import com.wakedt.visual.infrastructure.organization.repository.model.OrganizationDO;
import com.wakedt.visual.infrastructure.organization.repository.model.TeamDO;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 分页查询团队信息-分页查询器
 *
 * @author zhuxueliang
 */
@Component
public class TeamInfoByAccountIdQueryExe {

    @Resource
    private TeamMapper teamMapper;
    @Resource
    private OrganizationMapper organizationMapper;

    @Cacheable(value = "teamListCache", key = "#accountId")
    public ResultDTO<List<TeamDTO>> execute(Long accountId) {
        List<TeamDO> teamdoList = teamMapper.teamInfoByAccountId(accountId);
        List<TeamDTO> teamDTOList = TeamDTO2DOConvert.INSTANCE.doList2DtoList(teamdoList);

        // 填充组织信息
        for (TeamDTO teamDTO : teamDTOList) {
            OrganizationDO organizationDO = organizationMapper.selectById(teamDTO.getOrganizationId());
            OrganizationDTO organizationDTO = BeanUtil.copy(organizationDO, OrganizationDTO.class);
            teamDTO.setOrganizationDTO(organizationDTO);
        }

        return ResultDTO.success(teamDTOList);
    }
}
