package com.wakedt.visual.infrastructure.organization.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.wakedata.common.core.exception.BizException;
import com.wakedt.visual.domain.organization.team.Team;
import com.wakedt.visual.domain.organization.team.TeamRepository;
import com.wakedt.visual.infrastructure.application.repository.mapper.ApplicationMapper;
import com.wakedt.visual.infrastructure.application.repository.model.ApplicationDO;
import com.wakedt.visual.infrastructure.businessscene.repository.mapper.BusinessSceneMapper;
import com.wakedt.visual.infrastructure.businessscene.repository.model.BusinessSceneDO;
import com.wakedt.visual.infrastructure.domaindesign.repository.mapper.DomainDesignMapper;
import com.wakedt.visual.infrastructure.domaindesign.repository.model.DomainDesignDO;
import com.wakedt.visual.infrastructure.organization.assembler.TeamDoConvert;
import com.wakedt.visual.infrastructure.organization.repository.mapper.TeamMapper;
import com.wakedt.visual.infrastructure.organization.repository.model.TeamDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * 团队存储接口实现类
 *
 * @author zhuxueliang
 */
@Slf4j
@Component
public class TeamRepositoryImpl implements TeamRepository {

    @Resource
    private TeamMapper teamMapper;
    @Resource
    private ApplicationMapper applicationMapper;
    @Resource
    private BusinessSceneMapper businessSceneMapper;
    @Resource
    private DomainDesignMapper domainDesignMapper;

    @CacheEvict(value = "teamListCache", key = "#team.teamManagerId")
    @Override
    public Team save(Team team) {
        TeamDO teamDO = TeamDoConvert.INSTANCE.dto2Do(team);
        int insert = teamMapper.insert(teamDO);
        Assert.isTrue(insert == 1, "插入数据库异常，请联系管理员");
        return TeamDoConvert.INSTANCE.do2Dto(teamDO);
    }

    @CacheEvict(value = "teamListCache", key = "#team.teamManagerId")
    @Override
    public Team update(Team team) {
        TeamDO teamDO = TeamDoConvert.INSTANCE.dto2Do(team);
        int update = teamMapper.updateById(teamDO);
        Assert.isTrue(update == 1, "更新数据库异常，请联系管理员");
        return TeamDoConvert.INSTANCE.do2Dto(teamDO);
    }

    @CacheEvict(value = "teamListCache", key = "#team.teamManagerId")
    @Override
    public void remove(Team team) {
        TeamDO teamDO = TeamDoConvert.INSTANCE.dto2Do(team);
        teamMapper.deleteById(teamDO.getId());
    }

    @Override
    public Team find(Long id) {
        TeamDO team = teamMapper.selectById(id);
        return TeamDoConvert.INSTANCE.do2Dto(team);
    }

    @Override
    public void checkRepeatedName(Team team) {
        List<TeamDO> teamDOList = teamMapper.selectList(new LambdaQueryWrapper<TeamDO>()
                        .eq(TeamDO::getName, team.getName())
                        .eq(TeamDO::getOrganizationId, team.getOrganizationId()));
        if (teamDOList.size() > 1 || notMyself(team, teamDOList)) {
            throw new BizException("团队名称重复!");
        }
    }

    @Override
    public void checkExistApplication(Team team) {
        Integer count = applicationMapper.selectCount(
                new LambdaQueryWrapper<ApplicationDO>().eq(ApplicationDO::getTeamId, team.getId()));
        if (count > 0) {
            throw new BizException("团队下有应用，不能删除！");
        }
    }

    @Override
    public void checkExistBusinessScene(Team team) {
        Integer count = businessSceneMapper.selectCount(
                new LambdaQueryWrapper<BusinessSceneDO>().eq(BusinessSceneDO::getTeamId, team.getId()));
        if (count > 0) {
            throw new BizException("团队下有业务场景，不能删除！");
        }
    }

    @Override
    public void checkExistDomainDesign(Team team) {
        Integer count = domainDesignMapper.selectCount(
                new LambdaQueryWrapper<DomainDesignDO>().eq(DomainDesignDO::getTeamId, team.getId()));
        if (count > 0) {
            throw new BizException("团队下有业务域，不能删除！");
        }
    }

    private static boolean notMyself(Team team, List<TeamDO> doList) {
        return doList.size() == 1 && !Objects.equals(doList.get(0).getId(), team.getId());
    }
}
