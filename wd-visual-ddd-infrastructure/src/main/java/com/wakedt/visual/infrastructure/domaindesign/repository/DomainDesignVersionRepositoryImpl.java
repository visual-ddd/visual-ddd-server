package com.wakedt.visual.infrastructure.domaindesign.repository;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.wakedata.common.core.exception.BizException;
import com.wakedt.visual.domain.domaindesign.domaindesignversion.DomainDesignVersion;
import com.wakedt.visual.domain.domaindesign.domaindesignversion.DomainDesignVersionRepository;
import com.wakedt.visual.infrastructure.application.repository.mapper.ApplicationVersionMapper;
import com.wakedt.visual.infrastructure.application.repository.model.ApplicationVersionDO;
import com.wakedt.visual.infrastructure.domaindesign.assembler.DomainDesignVersionDoConvert;
import com.wakedt.visual.infrastructure.domaindesign.repository.mapper.DomainDesignMapper;
import com.wakedt.visual.infrastructure.domaindesign.repository.mapper.DomainDesignVersionMapper;
import com.wakedt.visual.infrastructure.domaindesign.repository.model.DomainDesignDO;
import com.wakedt.visual.infrastructure.domaindesign.repository.model.DomainDesignVersionDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * 业务域版本存储接口实现类
 *
 * @author zhuxueliang
 */
@Slf4j
@Component
public class DomainDesignVersionRepositoryImpl implements DomainDesignVersionRepository {

    public static final String DOMAIN_VERSION_BIND_APPLICATION = "该业务域被应用ID【%S】绑定";
    public static final String JSON_ARRAY_QUERY_CONDITION = "JSON_CONTAINS(domain_design_version_ids,JSON_ARRAY({0}))";

    @Resource
    private DomainDesignVersionMapper domainDesignVersionMapper;
    @Resource
    private DomainDesignMapper domainDesignMapper;
    @Resource
    private ApplicationVersionMapper applicationVersionMapper;

    @Override
    public DomainDesignVersion save(DomainDesignVersion domainDesignVersion) {
        DomainDesignVersionDO domainDesignVersionDO = DomainDesignVersionDoConvert.INSTANCE.dto2Do(domainDesignVersion);
        int insert = domainDesignVersionMapper.insert(domainDesignVersionDO);
        Assert.isTrue(insert == 1, "插入数据库异常，请联系管理员");
        return DomainDesignVersionDoConvert.INSTANCE.do2Dto(domainDesignVersionDO);
    }

    @Override
    public DomainDesignVersion update(DomainDesignVersion domainDesignVersion) {
        DomainDesignVersionDO domainDesignVersionDO = DomainDesignVersionDoConvert.INSTANCE.dto2Do(domainDesignVersion);
        int update = domainDesignVersionMapper.updateById(domainDesignVersionDO);
        Assert.isTrue(update == 1, "更新数据库异常，请联系管理员");
        return DomainDesignVersionDoConvert.INSTANCE.do2Dto(domainDesignVersionDO);
    }

    @Override
    public void remove(DomainDesignVersion domainDesignVersion) {
        DomainDesignVersionDO domainDesignVersionDO = DomainDesignVersionDoConvert.INSTANCE.dto2Do(domainDesignVersion);
        domainDesignVersionMapper.deleteById(domainDesignVersionDO.getId());
    }

    @Override
    public DomainDesignVersion find(Long id) {
        LambdaQueryWrapper<DomainDesignVersionDO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(DomainDesignVersionDO::getId, id)
                .select(DomainDesignVersionDO.class, info ->
                        !info.getProperty().equals("domainDesignDsl") && !info.getProperty().equals("graphDsl"));
        DomainDesignVersionDO domainDesignVersion = domainDesignVersionMapper.selectOne(queryWrapper);
        if (Objects.isNull(domainDesignVersion)){
            throw new BizException("当前业务域版本不存在");
        }
        return DomainDesignVersionDoConvert.INSTANCE.do2Dto(domainDesignVersion);
    }

    @Override
    public void checkDomainVersionIdentityUnique(DomainDesignVersion domainDesignVersion) {
        Integer count = domainDesignVersionMapper.selectCount(
                new LambdaQueryWrapper<DomainDesignVersionDO>()
                        .eq(DomainDesignVersionDO::getDomainDesignId, domainDesignVersion.getDomainDesignId())
                        .eq(DomainDesignVersionDO::getCurrentVersion, domainDesignVersion.getCurrentVersion()));
        if (count != 0) {
            throw new BizException("当前业务域的业务域版本唯一标识重复!");
        }
    }

    @Override
    public void checkCurrentDomainDesignExit(DomainDesignVersion domainDesignVersion) {
        DomainDesignDO domainDesignDO = domainDesignMapper.selectById(domainDesignVersion.getDomainDesignId());
        if (Objects.isNull(domainDesignDO)){
            throw new BizException("当前业务域不存在");
        }
    }

    @Override
    public void checkDomainVersionBindApplication(DomainDesignVersion domainDesignVersion) {
        List<ApplicationVersionDO> applicationVersionDOList = applicationVersionMapper.selectList(new LambdaQueryWrapper<ApplicationVersionDO>()
                .apply(JSON_ARRAY_QUERY_CONDITION, domainDesignVersion.getId()));
        if (CollectionUtil.isNotEmpty(applicationVersionDOList)){
            for (ApplicationVersionDO applicationVersionDO : applicationVersionDOList) {
                log.error(String.format(DOMAIN_VERSION_BIND_APPLICATION,applicationVersionDO.getApplicationId()));
                throw new BizException("该业务域版本被应用绑定,不允许删除");
            }
        }
    }
}
