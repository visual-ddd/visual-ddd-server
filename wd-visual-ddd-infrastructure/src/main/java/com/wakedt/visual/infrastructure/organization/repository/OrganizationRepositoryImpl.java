package com.wakedt.visual.infrastructure.organization.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.wakedata.common.core.exception.BizException;
import com.wakedt.visual.domain.organization.organization.Organization;
import com.wakedt.visual.domain.organization.organization.OrganizationRepository;
import com.wakedt.visual.infrastructure.organization.assembler.OrganizationDoConvert;
import com.wakedt.visual.infrastructure.organization.repository.mapper.OrganizationMapper;
import com.wakedt.visual.infrastructure.organization.repository.mapper.TeamMapper;
import com.wakedt.visual.infrastructure.organization.repository.model.OrganizationDO;
import com.wakedt.visual.infrastructure.organization.repository.model.TeamDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * 组织存储接口实现类
 *
 * @author zhuxueliang
 */
@Slf4j
@Component
public class OrganizationRepositoryImpl implements OrganizationRepository {

    @Resource
    private OrganizationMapper organizationMapper;
    @Resource
    private TeamMapper teamMapper;

    @CacheEvict(value = "organizationListCache", key = "#organization.organizationManagerId")
    @Override
    public Organization save(Organization organization) {
        OrganizationDO organizationDO = OrganizationDoConvert.INSTANCE.dto2Do(organization);
        int insert = organizationMapper.insert(organizationDO);
        Assert.isTrue(insert == 1, "插入数据库异常，请联系管理员");
        return OrganizationDoConvert.INSTANCE.do2Dto(organizationDO);
    }

    @CacheEvict(value = {"organizationListCache", "teamListCache"}, key = "#organization.organizationManagerId")
    @Override
    public Organization update(Organization organization) {
        OrganizationDO organizationDO = OrganizationDoConvert.INSTANCE.dto2Do(organization);
        int update = organizationMapper.updateById(organizationDO);
        Assert.isTrue(update == 1, "更新数据库异常，请联系管理员");
        return OrganizationDoConvert.INSTANCE.do2Dto(organizationDO);
    }

    @CacheEvict(value = {"organizationListCache", "teamListCache"}, key = "#organization.organizationManagerId")
    @Override
    public void remove(Organization organization) {
        OrganizationDO organizationDO = OrganizationDoConvert.INSTANCE.dto2Do(organization);
        organizationMapper.deleteById(organizationDO.getId());
    }

    @Override
    public Organization find(Long id) {
        OrganizationDO organization = organizationMapper.selectById(id);
        if (organization == null) {
            throw new BizException("参数错误：id不存在！");
        }
        return OrganizationDoConvert.INSTANCE.do2Dto(organization);
    }

    @Override
    public void checkRepeatedName(Organization organization) {
        List<OrganizationDO> organizationDOList = organizationMapper.selectList(new LambdaQueryWrapper<OrganizationDO>()
                .eq(OrganizationDO::getName, organization.getName()));
        if (organizationDOList.size() > 1 || notMyself(organization, organizationDOList)) {
            throw new BizException("组织不能重复!");
        }
    }

    @Override
    public void checkExistTeam(Organization organization) {
        Long organizationId = organization.getId();
        int count = teamMapper.selectCount(
                new LambdaQueryWrapper<TeamDO>().eq(TeamDO::getOrganizationId, organizationId));
        if (count > 0) {
            throw new BizException("组织下存在团队，不能删除组织!");
        }
    }

    private static boolean notMyself(Organization organization, List<OrganizationDO> doList) {
        return doList.size() == 1 && !Objects.equals(doList.get(0).getId(), organization.getId());
    }
}
