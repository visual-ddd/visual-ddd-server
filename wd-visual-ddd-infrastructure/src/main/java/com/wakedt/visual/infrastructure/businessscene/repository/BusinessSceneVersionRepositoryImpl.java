package com.wakedt.visual.infrastructure.businessscene.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.wakedata.common.core.exception.BizException;
import com.wakedt.visual.domain.businessscene.businesssceneversion.BusinessSceneVersion;
import com.wakedt.visual.domain.businessscene.businesssceneversion.BusinessSceneVersionRepository;
import com.wakedt.visual.infrastructure.application.repository.mapper.ApplicationVersionMapper;
import com.wakedt.visual.infrastructure.application.repository.model.ApplicationVersionDO;
import com.wakedt.visual.infrastructure.businessscene.assembler.BusinessSceneVersionDoConvert;
import com.wakedt.visual.infrastructure.businessscene.repository.mapper.BusinessSceneMapper;
import com.wakedt.visual.infrastructure.businessscene.repository.mapper.BusinessSceneVersionMapper;
import com.wakedt.visual.infrastructure.businessscene.repository.model.BusinessSceneDO;
import com.wakedt.visual.infrastructure.businessscene.repository.model.BusinessSceneVersionDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.Resource;

/**
 * 业务场景版本存储接口实现类
 *
 * @author zhuxueliang
 */
@Slf4j
@Component
public class BusinessSceneVersionRepositoryImpl implements BusinessSceneVersionRepository {

    @Resource
    private BusinessSceneVersionMapper businessSceneVersionMapper;
    @Resource
    private BusinessSceneMapper businessSceneMapper;
    @Resource
    private ApplicationVersionMapper applicationVersionMapper;

    @Override
    public BusinessSceneVersion save(BusinessSceneVersion businessSceneVersion) {
        BusinessSceneVersionDO businessSceneVersionDO = BusinessSceneVersionDoConvert.INSTANCE.dto2Do(businessSceneVersion);
        int insert = businessSceneVersionMapper.insert(businessSceneVersionDO);
        Assert.isTrue(insert == 1, "插入数据库异常，请联系管理员");
        return BusinessSceneVersionDoConvert.INSTANCE.do2Dto(businessSceneVersionDO);
    }

    @Override
    public BusinessSceneVersion update(BusinessSceneVersion businessSceneVersion) {
        BusinessSceneVersionDO businessSceneVersionDO = BusinessSceneVersionDoConvert.INSTANCE.dto2Do(businessSceneVersion);
        int update = businessSceneVersionMapper.updateById(businessSceneVersionDO);
        Assert.isTrue(update == 1, "更新数据库异常，请联系管理员");
        return BusinessSceneVersionDoConvert.INSTANCE.do2Dto(businessSceneVersionDO);
    }

    @Override
    public void remove(BusinessSceneVersion businessSceneVersion) {
        BusinessSceneVersionDO businessSceneVersionDO = BusinessSceneVersionDoConvert.INSTANCE.dto2Do(businessSceneVersion);
        businessSceneVersionMapper.deleteById(businessSceneVersionDO.getId());
    }

    @Override
    public BusinessSceneVersion find(Long id) {
        LambdaQueryWrapper<BusinessSceneVersionDO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(BusinessSceneVersionDO::getId, id)
                .select(BusinessSceneVersionDO.class, info ->
                        !info.getProperty().equals("dsl") && !info.getProperty().equals("graphDsl"));
        BusinessSceneVersionDO businessSceneVersion = businessSceneVersionMapper.selectOne(queryWrapper);
        return BusinessSceneVersionDoConvert.INSTANCE.do2Dto(businessSceneVersion);
    }

    @Override
    public void checkRepeatedBusinessSceneVersion(BusinessSceneVersion businessSceneVersion) {
        BusinessSceneVersionDO businessSceneVersionDO = businessSceneVersionMapper.selectOne(
                new LambdaQueryWrapper<BusinessSceneVersionDO>()
                        .eq(BusinessSceneVersionDO::getBusinessSceneId, businessSceneVersion.getBusinessSceneId())
                        .eq(BusinessSceneVersionDO::getCurrentVersion, businessSceneVersion.getCurrentVersion()));
        if (businessSceneVersionDO != null) {
            throw new BizException("当前版本号已存在！");
        }
    }

    @Override
    public void checkExistBusinessSceneId(BusinessSceneVersion businessSceneVersion) {
        BusinessSceneDO businessSceneDO = businessSceneMapper.selectById(businessSceneVersion.getBusinessSceneId());
        if (businessSceneDO == null) {
            throw new BizException("业务场景ID错误，业务场景不存在！");
        }
    }

    @Override
    public void checkBSVersionBindApplication(BusinessSceneVersion businessSceneVersion) {
        Integer count = applicationVersionMapper.selectCount(new LambdaQueryWrapper<ApplicationVersionDO>()
                .apply("JSON_CONTAINS(business_scene_version_ids,JSON_ARRAY({0}))", businessSceneVersion.getId()));
        if (count > 0){
            throw new BizException("该业务场景版本被应用绑定,不允许删除");
        }
    }
}
