package com.wakedt.visual.infrastructure.organization.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.wakedata.common.core.exception.BizException;
import com.wakedt.visual.domain.organization.teammember.TeamMember;
import com.wakedt.visual.domain.organization.teammember.TeamMemberRepository;
import com.wakedt.visual.infrastructure.organization.assembler.TeamMemberDoConvert;
import com.wakedt.visual.infrastructure.organization.repository.mapper.TeamMemberMapper;
import com.wakedt.visual.infrastructure.organization.repository.model.TeamMemberDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.Resource;

/**
 * 团队成员存储接口实现类
 *
 * @author zhuxueliang
 */
@Slf4j
@Component
public class TeamMemberRepositoryImpl implements TeamMemberRepository {

    @Resource
    private TeamMemberMapper teamMemberMapper;

    @CacheEvict(value = "teamListCache", key = "#teamMember.accountId")
    @Override
    public TeamMember save(TeamMember teamMember) {
        TeamMemberDO teamMemberDO = TeamMemberDoConvert.INSTANCE.dto2Do(teamMember);
        int insert = teamMemberMapper.insert(teamMemberDO);
        Assert.isTrue(insert == 1, "插入数据库异常，请联系管理员");
        return TeamMemberDoConvert.INSTANCE.do2Dto(teamMemberDO);
    }

    @CacheEvict(value = "teamListCache", key = "#teamMember.accountId")
    @Override
    public TeamMember update(TeamMember teamMember) {
        TeamMemberDO teamMemberDO = TeamMemberDoConvert.INSTANCE.dto2Do(teamMember);
        int update = teamMemberMapper.updateById(teamMemberDO);
        Assert.isTrue(update == 1, "更新数据库异常，请联系管理员");
        return TeamMemberDoConvert.INSTANCE.do2Dto(teamMemberDO);
    }

    @CacheEvict(value = "teamListCache", key = "#teamMember.accountId")
    @Override
    public void remove(TeamMember teamMember) {
        TeamMemberDO teamMemberDO = TeamMemberDoConvert.INSTANCE.dto2Do(teamMember);
        teamMemberMapper.deleteById(teamMemberDO.getId());
    }

    @Override
    public TeamMember find(Long id) {
        TeamMemberDO teamMember = teamMemberMapper.selectById(id);
        return TeamMemberDoConvert.INSTANCE.do2Dto(teamMember);
    }

    @Override
    public void checkRepeatedTeamMember(TeamMember teamMember) {
        Integer count = teamMemberMapper.selectCount(
                new LambdaQueryWrapper<TeamMemberDO>()
                        .eq(TeamMemberDO::getAccountId, teamMember.getAccountId())
                        .eq(TeamMemberDO::getTeamId, teamMember.getTeamId())
        );
        if (count > 0) {
            throw new BizException("团队成员已存在!");
        }
    }
}
