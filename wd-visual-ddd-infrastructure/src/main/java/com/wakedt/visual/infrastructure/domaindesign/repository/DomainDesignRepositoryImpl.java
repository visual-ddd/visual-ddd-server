package com.wakedt.visual.infrastructure.domaindesign.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.wakedata.common.core.exception.BizException;
import com.wakedt.visual.domain.domaindesign.domaindesign.DomainDesign;
import com.wakedt.visual.domain.domaindesign.domaindesign.DomainDesignRepository;
import com.wakedt.visual.infrastructure.domaindesign.assembler.DomainDesignDoConvert;
import com.wakedt.visual.infrastructure.domaindesign.repository.mapper.DomainDesignMapper;
import com.wakedt.visual.infrastructure.domaindesign.repository.mapper.DomainDesignVersionMapper;
import com.wakedt.visual.infrastructure.domaindesign.repository.model.DomainDesignDO;
import com.wakedt.visual.infrastructure.domaindesign.repository.model.DomainDesignVersionDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * 业务域存储接口实现类
 *
 * @author zhuxueliang
 */
@Slf4j
@Component
public class DomainDesignRepositoryImpl implements DomainDesignRepository {

    @Resource
    private DomainDesignMapper domainDesignMapper;
    @Resource
    private DomainDesignVersionMapper domainDesignVersionMapper;

    @Override
    public DomainDesign save(DomainDesign domainDesign) {
        DomainDesignDO domainDesignDO = DomainDesignDoConvert.INSTANCE.dto2Do(domainDesign);
        int insert = domainDesignMapper.insert(domainDesignDO);
        Assert.isTrue(insert == 1, "插入数据库异常，请联系管理员");
        return DomainDesignDoConvert.INSTANCE.do2Dto(domainDesignDO);
    }

    @Override
    public DomainDesign update(DomainDesign domainDesign) {
        DomainDesignDO domainDesignDO = DomainDesignDoConvert.INSTANCE.dto2Do(domainDesign);
        int update = domainDesignMapper.updateById(domainDesignDO);
        Assert.isTrue(update == 1, "更新数据库异常，请联系管理员");
        return DomainDesignDoConvert.INSTANCE.do2Dto(domainDesignDO);
    }

    @Override
    public void remove(DomainDesign domainDesign) {
        DomainDesignDO domainDesignDO = DomainDesignDoConvert.INSTANCE.dto2Do(domainDesign);
        domainDesignMapper.deleteById(domainDesignDO.getId());
    }

    @Override
    public DomainDesign find(Long id) {
        DomainDesignDO domainDesign = domainDesignMapper.selectById(id);
        if (Objects.isNull(domainDesign)) {
            throw new BizException("获取不到该业务域");
        }
        return DomainDesignDoConvert.INSTANCE.do2Dto(domainDesign);
    }

    @Override
    public void checkRepeatedIdentity(DomainDesign domainDesign) {
        Integer count = domainDesignMapper.selectCount(
                new LambdaQueryWrapper<DomainDesignDO>()
                        .eq(DomainDesignDO::getIdentity, domainDesign.getIdentity())
                        .eq(DomainDesignDO::getTeamId, domainDesign.getTeamId()));
        if (count > 0) {
            throw new BizException("业务域唯一标识重复!");
        }
    }

    @Override
    public void checkExistDomainDesignVersion(DomainDesign domainDesign) {
        Integer count = domainDesignVersionMapper.selectCount(
                new LambdaQueryWrapper<DomainDesignVersionDO>()
                        .eq(DomainDesignVersionDO::getDomainDesignId, domainDesign.getId()));
        if (count > 0) {
            throw new BizException("当前业务域下存在业务域版本,不允许操作");
        }
    }
}
