package com.wakedt.visual.app.organization.view;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wakedata.common.core.dto.PageResultDTO;
import com.wakedt.visual.app.organization.assembler.TeamMemberDTO2DOConvert;
import com.wakedt.visual.client.organization.dto.TeamMemberDTO;
import com.wakedt.visual.client.organization.query.TeamMemberByTeamIdPageQuery;
import com.wakedt.visual.infrastructure.organization.repository.mapper.TeamMemberMapper;
import com.wakedt.visual.infrastructure.organization.repository.model.TeamMemberDO;
import com.wakedt.visual.infrastructure.user.repository.mapper.AccountMapper;
import com.wakedt.visual.infrastructure.user.repository.model.AccountDO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * 查询团队下的成员信息-分页查询器
 *
 * @author zhuxueliang
 */
@Component
public class TeamMemberByTeamIdPageQueryExe {

    @Resource
    private TeamMemberMapper teammemberMapper;
    @Resource
    private AccountMapper accountMapper;

    public PageResultDTO<List<TeamMemberDTO>> execute(TeamMemberByTeamIdPageQuery pageQuery) {
        PageHelper.startPage(pageQuery.getPageNo(), pageQuery.getPageSize());

        List<TeamMemberDO> teammemberdoList = teammemberMapper.teamMemberByTeamIdPageQuery(pageQuery);
        PageInfo<TeamMemberDO> pageInfo = new PageInfo<>(teammemberdoList);
        List<TeamMemberDTO> teamMemberDTOList = TeamMemberDTO2DOConvert.INSTANCE.doList2DtoList(pageInfo.getList());

        teamMemberDTOList.forEach(this::putTeamMemberName);

        PageResultDTO<List<TeamMemberDTO>> pageResultDTO = new PageResultDTO<>();
        pageResultDTO.setData(teamMemberDTOList);
        pageResultDTO.setPageNo(pageInfo.getPageNum());
        pageResultDTO.setPageSize(pageInfo.getSize());
        pageResultDTO.setTotalCount(pageInfo.getTotal());
        return pageResultDTO;
    }

    private void putTeamMemberName(TeamMemberDTO teamMemberDTO) {
        Long teamManagerId = teamMemberDTO.getAccountId();
        AccountDO accountDO = accountMapper.selectById(teamManagerId);
        teamMemberDTO.setTeamMemberName(Optional.ofNullable(accountDO).map(AccountDO::getUserName).orElse(StringUtils.EMPTY));
        teamMemberDTO.setAccountNo(Optional.ofNullable(accountDO).map(AccountDO::getAccountNo).orElse(StringUtils.EMPTY));
    }
}
