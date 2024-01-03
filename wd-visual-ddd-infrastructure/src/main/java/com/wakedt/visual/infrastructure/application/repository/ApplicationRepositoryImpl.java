package com.wakedt.visual.infrastructure.application.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.wakedata.common.core.exception.BizException;
import com.wakedt.visual.domain.application.application.Application;
import com.wakedt.visual.domain.application.application.ApplicationRepository;
import com.wakedt.visual.infrastructure.application.assembler.ApplicationDoConvert;
import com.wakedt.visual.infrastructure.application.repository.mapper.ApplicationMapper;
import com.wakedt.visual.infrastructure.application.repository.mapper.ApplicationVersionMapper;
import com.wakedt.visual.infrastructure.application.repository.model.ApplicationDO;
import com.wakedt.visual.infrastructure.application.repository.model.ApplicationVersionDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.Resource;

/**
 * 应用存储接口实现类
 *
 * @author zhuxueliang
 */
@Slf4j
@Component
public class ApplicationRepositoryImpl implements ApplicationRepository {

    @Resource
    private ApplicationMapper applicationMapper;
    @Resource
    private ApplicationVersionMapper applicationVersionMapper;

    @Override
    public Application save(Application application) {
        ApplicationDO applicationDO = ApplicationDoConvert.INSTANCE.dto2Do(application);
        int insert = applicationMapper.insert(applicationDO);
        Assert.isTrue(insert == 1, "插入数据库异常，请联系管理员");
        return ApplicationDoConvert.INSTANCE.do2Dto(applicationDO);
    }

    @Override
    public Application update(Application application) {
        ApplicationDO applicationDO = ApplicationDoConvert.INSTANCE.dto2Do(application);
        int update = applicationMapper.updateById(applicationDO);
        Assert.isTrue(update == 1, "更新数据库异常，请联系管理员");
        return ApplicationDoConvert.INSTANCE.do2Dto(applicationDO);
    }

    @Override
    public void remove(Application application) {
        ApplicationDO applicationDO = ApplicationDoConvert.INSTANCE.dto2Do(application);
        applicationMapper.deleteById(applicationDO.getId());
    }

    @Override
    public Application find(Long id) {
        ApplicationDO application = applicationMapper.selectById(id);
        return ApplicationDoConvert.INSTANCE.do2Dto(application);
    }

    @Override
    public void checkRepeatedIdentity(Application application) {
        Integer count = applicationMapper.selectCount(
                new LambdaQueryWrapper<ApplicationDO>()
                        .eq(ApplicationDO::getTeamId, application.getTeamId())
                        .eq(ApplicationDO::getIdentity, application.getIdentity()));
        if (count > 0) {
            throw new BizException("应用标识符重复！");
        }
    }

    @Override
    public void checkExistApplicationVersion(Application application) {
        Integer count = applicationVersionMapper.selectCount(
                new LambdaQueryWrapper<ApplicationVersionDO>()
                        .eq(ApplicationVersionDO::getApplicationId, application.getId()));
        if (count > 0) {
            throw new BizException("应用下存在版本, 不允许操作！");
        }
    }
}
