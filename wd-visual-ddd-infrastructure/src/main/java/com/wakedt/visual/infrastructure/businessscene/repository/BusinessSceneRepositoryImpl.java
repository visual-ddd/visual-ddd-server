package com.wakedt.visual.infrastructure.businessscene.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.wakedata.common.core.exception.BizException;
import com.wakedt.visual.domain.businessscene.businessscene.BusinessScene;
import com.wakedt.visual.domain.businessscene.businessscene.BusinessSceneRepository;
import com.wakedt.visual.infrastructure.businessscene.assembler.BusinessSceneDoConvert;
import com.wakedt.visual.infrastructure.businessscene.repository.mapper.BusinessSceneMapper;
import com.wakedt.visual.infrastructure.businessscene.repository.mapper.BusinessSceneVersionMapper;
import com.wakedt.visual.infrastructure.businessscene.repository.model.BusinessSceneDO;
import com.wakedt.visual.infrastructure.businessscene.repository.model.BusinessSceneVersionDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.Resource;

/**
 * 业务场景存储接口实现类
 *
 * @author zhuxueliang
 */
@Slf4j
@Component
public class BusinessSceneRepositoryImpl implements BusinessSceneRepository {

    @Resource
    private BusinessSceneMapper businessSceneMapper;
    @Resource
    private BusinessSceneVersionMapper businessSceneVersionMapper;

    @Override
    public BusinessScene save(BusinessScene businessScene) {
        BusinessSceneDO businessSceneDO = BusinessSceneDoConvert.INSTANCE.dto2Do(businessScene);
        int insert = businessSceneMapper.insert(businessSceneDO);
        Assert.isTrue(insert == 1, "插入数据库异常，请联系管理员");
        return BusinessSceneDoConvert.INSTANCE.do2Dto(businessSceneDO);
    }

    @Override
    public BusinessScene update(BusinessScene businessScene) {
        BusinessSceneDO businessSceneDO = BusinessSceneDoConvert.INSTANCE.dto2Do(businessScene);
        int update = businessSceneMapper.updateById(businessSceneDO);
        Assert.isTrue(update == 1, "更新数据库异常，请联系管理员");
        return BusinessSceneDoConvert.INSTANCE.do2Dto(businessSceneDO);
    }

    @Override
    public void remove(BusinessScene businessScene) {
        BusinessSceneDO businessSceneDO = BusinessSceneDoConvert.INSTANCE.dto2Do(businessScene);
        businessSceneMapper.deleteById(businessSceneDO.getId());
    }

    @Override
    public BusinessScene find(Long id) {
        BusinessSceneDO businessScene = businessSceneMapper.selectById(id);
        return BusinessSceneDoConvert.INSTANCE.do2Dto(businessScene);
    }

    @Override
    public void checkRepeatedIdentity(BusinessScene businessScene) {
        Integer count = businessSceneMapper.selectCount(
                new LambdaQueryWrapper<BusinessSceneDO>()
                        .eq(BusinessSceneDO::getTeamId, businessScene.getTeamId())
                        .eq(BusinessSceneDO::getIdentity, businessScene.getIdentity()));
        if (count > 0) {
            throw new BizException("业务场景标识符重复！");
        }
    }

    @Override
    public void checkExistBusinessSceneVersion(BusinessScene businessScene) {
        Integer count = businessSceneVersionMapper.selectCount(
                new LambdaQueryWrapper<BusinessSceneVersionDO>()
                        .eq(BusinessSceneVersionDO::getBusinessSceneId, businessScene.getId()));
        if (count > 0) {
            throw new BizException("业务场景下存在版本, 不允许操作！！");
        }
    }
}
