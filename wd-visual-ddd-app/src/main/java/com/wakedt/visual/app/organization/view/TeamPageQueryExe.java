package com.wakedt.visual.app.organization.view;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wakedata.common.core.dto.PageResultDTO;
import com.wakedt.visual.app.organization.assembler.TeamDTO2DOConvert;
import com.wakedt.visual.client.organization.dto.TeamDTO;
import com.wakedt.visual.client.organization.query.TeamPageQuery;
import com.wakedt.visual.infrastructure.organization.repository.mapper.TeamMapper;
import com.wakedt.visual.infrastructure.organization.repository.model.TeamDO;
import com.wakedt.visual.infrastructure.user.repository.mapper.AccountMapper;
import com.wakedt.visual.infrastructure.user.repository.model.AccountDO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * 分页查询团队信息-分页查询器
 *
 * @author zhuxueliang
 */
@Component
public class TeamPageQueryExe {

    @Resource
    private TeamMapper teamMapper;
    @Resource
    private AccountMapper accountMapper;

    public PageResultDTO<List<TeamDTO>> execute(TeamPageQuery pageQuery) {
        PageHelper.startPage(pageQuery.getPageNo(), pageQuery.getPageSize());

        List<TeamDO> teamdoList = teamMapper.teamPageQuery(pageQuery);
        PageInfo<TeamDO> pageInfo = new PageInfo<>(teamdoList);
        List<TeamDTO> teamDTOList = TeamDTO2DOConvert.INSTANCE.doList2DtoList(pageInfo.getList());

        teamDTOList.forEach(this::putManagerName);

        PageResultDTO<List<TeamDTO>> pageResultDTO = new PageResultDTO<>();
        pageResultDTO.setData(teamDTOList);
        pageResultDTO.setPageNo(pageInfo.getPageNum());
        pageResultDTO.setPageSize(pageInfo.getSize());
        pageResultDTO.setTotalCount(pageInfo.getTotal());
        return pageResultDTO;
    }

    private void putManagerName(TeamDTO teamDTO) {
        Long teamManagerId = teamDTO.getTeamManagerId();
        AccountDO accountDO = accountMapper.selectById(teamManagerId);
        String userName = Optional.ofNullable(accountDO).map(AccountDO::getUserName).orElse(StringUtils.EMPTY);
        teamDTO.setTeamManagerName(userName);
    }
}
