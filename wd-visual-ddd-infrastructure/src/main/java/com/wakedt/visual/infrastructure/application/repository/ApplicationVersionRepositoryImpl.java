package com.wakedt.visual.infrastructure.application.repository;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.wakedata.common.core.exception.BizException;
import com.wakedt.visual.domain.application.applicationversion.ApplicationVersion;
import com.wakedt.visual.domain.application.applicationversion.ApplicationVersionRepository;
import com.wakedt.visual.infrastructure.application.assembler.ApplicationVersionDoConvert;
import com.wakedt.visual.infrastructure.application.gateway.ApplicationVersionGateway;
import com.wakedt.visual.infrastructure.application.repository.mapper.ApplicationMapper;
import com.wakedt.visual.infrastructure.application.repository.mapper.ApplicationVersionMapper;
import com.wakedt.visual.infrastructure.application.repository.model.ApplicationDO;
import com.wakedt.visual.infrastructure.application.repository.model.ApplicationVersionDO;
import com.wakedt.visual.infrastructure.businessscene.repository.mapper.BusinessSceneMapper;
import com.wakedt.visual.infrastructure.businessscene.repository.mapper.BusinessSceneVersionMapper;
import com.wakedt.visual.infrastructure.businessscene.repository.model.BusinessSceneDO;
import com.wakedt.visual.infrastructure.businessscene.repository.model.BusinessSceneVersionDO;
import com.wakedt.visual.infrastructure.domaindesign.repository.mapper.DomainDesignMapper;
import com.wakedt.visual.infrastructure.domaindesign.repository.mapper.DomainDesignVersionMapper;
import com.wakedt.visual.infrastructure.domaindesign.repository.model.DomainDesignDO;
import com.wakedt.visual.infrastructure.domaindesign.repository.model.DomainDesignVersionDO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.*;
import java.util.zip.ZipOutputStream;

/**
 * 应用版本存储接口实现类
 *
 * @author zhuxueliang
 */
@Slf4j
@Component
public class ApplicationVersionRepositoryImpl implements ApplicationVersionRepository {

    @Resource
    private ApplicationVersionMapper applicationVersionMapper;
    @Resource
    private ApplicationMapper applicationMapper;
    @Resource
    private BusinessSceneVersionMapper businessSceneVersionMapper;
    @Resource
    private BusinessSceneMapper businessSceneMapper;
    @Resource
    private DomainDesignVersionMapper domainDesignVersionMapper;
    @Resource
    private DomainDesignMapper domainDesignMapper;
    @Resource
    private ApplicationVersionGateway applicationVersionGateway;

    @Override
    public ApplicationVersion save(ApplicationVersion applicationVersion) {
        ApplicationVersionDO applicationVersionDO = ApplicationVersionDoConvert.INSTANCE.dto2Do(applicationVersion);
        int insert = applicationVersionMapper.insert(applicationVersionDO);
        Assert.isTrue(insert == 1, "插入数据库异常，请联系管理员");
        return ApplicationVersionDoConvert.INSTANCE.do2Dto(applicationVersionDO);
    }

    @Override
    public ApplicationVersion update(ApplicationVersion applicationVersion) {
        ApplicationVersionDO applicationVersionDO = ApplicationVersionDoConvert.INSTANCE.dto2Do(applicationVersion);
        int update = applicationVersionMapper.updateById(applicationVersionDO);
        Assert.isTrue(update == 1, "更新数据库异常，请联系管理员");
        return ApplicationVersionDoConvert.INSTANCE.do2Dto(applicationVersionDO);
    }

    @Override
    public void remove(ApplicationVersion applicationVersion) {
        ApplicationVersionDO applicationVersionDO = ApplicationVersionDoConvert.INSTANCE.dto2Do(applicationVersion);
        applicationVersionMapper.deleteById(applicationVersionDO.getId());
    }

    @Override
    public ApplicationVersion find(Long id) {
        ApplicationVersionDO applicationVersion = applicationVersionMapper.selectById(id);
        return ApplicationVersionDoConvert.INSTANCE.do2Dto(applicationVersion);
    }

    @Override
    public void checkRepeatedApplicationVersion(ApplicationVersion applicationVersion) {
        ApplicationVersionDO applicationVersionDO = applicationVersionMapper.selectOne(
                new LambdaQueryWrapper<ApplicationVersionDO>()
                        .eq(ApplicationVersionDO::getApplicationId, applicationVersion.getApplicationId())
                        .eq(ApplicationVersionDO::getCurrentVersion, applicationVersion.getCurrentVersion()));
        if (applicationVersionDO != null) {
            throw new BizException("当前版本号已存在！");
        }
    }

    @Override
    public void checkExistApplicationId(ApplicationVersion applicationVersion) {
        ApplicationDO applicationDO = applicationMapper.selectById(applicationVersion.getApplicationId());
        if (applicationDO == null) {
            throw new BizException("应用ID错误，应用不存在！");
        }
    }

    @Override
    public void checkBindRepeatedDomainDesignVersion(ApplicationVersion applicationVersion) {
        Set<Long> domainDesignVersionIds = applicationVersion.getDomainDesignVersionIds();
        if (domainDesignVersionIds.isEmpty()) {
            return;
        }
        List<DomainDesignVersionDO> domainDesignVersionDOList = domainDesignVersionMapper.selectList(
                new LambdaQueryWrapper<DomainDesignVersionDO>()
                        .in(DomainDesignVersionDO::getId, domainDesignVersionIds));
        long count = domainDesignVersionDOList.stream()
                .map(DomainDesignVersionDO::getDomainDesignId)
                .distinct().count();
        if (count != domainDesignVersionDOList.size()) {
            throw new BizException("不能关联业务域,同一业务域只能关联一个版本号");
        }
    }

    @Override
    public void checkBindRepeatedBusinessSceneVersion(ApplicationVersion applicationVersion) {
        Set<Long> businessSceneVersionIds = applicationVersion.getBusinessSceneVersionIds();
        if (businessSceneVersionIds.isEmpty()) {
            return;
        }
        List<BusinessSceneVersionDO> businessSceneDOList = businessSceneVersionMapper.selectList(
                new LambdaQueryWrapper<BusinessSceneVersionDO>()
                        .in(BusinessSceneVersionDO::getId, businessSceneVersionIds));
        long count = businessSceneDOList.stream()
                .map(BusinessSceneVersionDO::getBusinessSceneId)
                .distinct().count();
        if (count != businessSceneDOList.size()) {
            throw new BizException("不能关联业务场景,同一业务场景只能关联一个版本号");
        }
    }

    @Override
    public void checkExistBusinessSceneVersionVersionIds(ApplicationVersion applicationVersion) {
        Collection<Long> businessSceneVersionIds = applicationVersion.getBusinessSceneVersionIds();
        if (businessSceneVersionIds.isEmpty()) {
            return;
        }
        Integer count = businessSceneVersionMapper.selectCount(
                new LambdaQueryWrapper<BusinessSceneVersionDO>()
                        .in(BusinessSceneVersionDO::getId, businessSceneVersionIds));
        if (count != businessSceneVersionIds.size()) {
            throw new BizException("关联业务场景ID不存在！");
        }
    }

    @Override
    public void checkExistDomainDesignVersionIds(ApplicationVersion applicationVersion) {
        Collection<Long> domainDesignVersionIds = applicationVersion.getDomainDesignVersionIds();
        if (domainDesignVersionIds.isEmpty()) {
            return;
        }
        Integer count = domainDesignVersionMapper.selectCount(
                new LambdaQueryWrapper<DomainDesignVersionDO>()
                        .in(DomainDesignVersionDO::getId, domainDesignVersionIds));
        if (count != domainDesignVersionIds.size()) {
            throw new BizException("关联业务域ID不存在！");
        }
    }

    @Override
    public void checkUnpublishedBSVersionHasBindOther(ApplicationVersion applicationVersion, Set<Long> oldBusinessSceneVersionIds) {
        Set<Long> businessSceneVersionIds = applicationVersion.getBusinessSceneVersionIds();
        Collection<Long> compareIds = CollectionUtils.subtract(businessSceneVersionIds, oldBusinessSceneVersionIds);
        if (compareIds.isEmpty()) {
            return;
        }
        List<ApplicationVersionDO> applicationVersionDOList =
                applicationVersionMapper.selectUnpublishedBSVersionBindCount(compareIds);
        if (applicationVersionDOList.size() > 1 || notMyself(applicationVersion.getId(), applicationVersionDOList)) {
            throw new BizException("其他应用已绑定的未发布业务场景版本，不能进行操作！");
        }
    }

    @Override
    public void checkUnpublishedDDVersionHasBindOther(ApplicationVersion applicationVersion, Set<Long> oldDomainDesignIds) {
        Set<Long> domainDesignVersionIds = applicationVersion.getDomainDesignVersionIds();
        Collection<Long> compareIds = CollectionUtils.subtract(domainDesignVersionIds, oldDomainDesignIds);
        if (compareIds.isEmpty()) {
            return;
        }
        List<ApplicationVersionDO> applicationVersionDOList =
                applicationVersionMapper.selectUnpublishedDDVersionBindCount(compareIds);
        if (applicationVersionDOList.size() > 1 || notMyself(applicationVersion.getId(), applicationVersionDOList)) {
            throw new BizException("其他应用已绑定的未发布业务域版本，不能进行操作！");
        }
    }

    @Override
    public void generateCode(ApplicationVersion applicationVersion, ZipOutputStream outputStream) {
        Long applicationId = applicationVersion.getApplicationId();
        ApplicationDO applicationDO = applicationMapper.selectById(applicationId);

        List<DomainDesignVersionDO> domainDesignVersionDOList =
                domainDesignVersionMapper.selectBindDomainDesignList(applicationVersion.getId());
        List<BusinessSceneVersionDO> businessSceneVersionDOList =
                businessSceneVersionMapper.selectBindBusinessSceneList(applicationVersion.getId());

        JSONObject applicationJson = JSONUtil.createObj();
        applicationJson.putAll(getApplicationInfoMap(applicationVersion, applicationDO));

        JSONArray domainDesignArray = JSONUtil.createArray();
        for (DomainDesignVersionDO domainDesignVersionDO : domainDesignVersionDOList) {
            JSONObject domainDesignJson = JSONUtil.parseObj(domainDesignVersionDO.getDomainDesignDsl());
            DomainDesignDO domainDesignDO = domainDesignMapper.selectById(domainDesignVersionDO.getDomainDesignId());
            domainDesignJson.putAll(getDomainDesignInfoMap(domainDesignVersionDO, domainDesignDO));
            domainDesignArray.add(domainDesignJson);
        }

        JSONArray businessSceneArray = JSONUtil.createArray();
        for (BusinessSceneVersionDO businessSceneVersionDO : businessSceneVersionDOList) {
            JSONObject jsonObject = JSONUtil.parseObj(businessSceneVersionDO.getDsl());
            BusinessSceneDO businessSceneDO = businessSceneMapper.selectById(businessSceneVersionDO.getBusinessSceneId());
            jsonObject.putAll(getBusinessSceneInfoMap(businessSceneVersionDO, businessSceneDO));
            businessSceneArray.add(jsonObject);
        }

        applicationJson.remove("businessDomains");
        applicationJson.putOnce("businessDomains", domainDesignArray);
        applicationJson.remove("businessScenarios");
        applicationJson.putOnce("businessScenarios", businessSceneArray);
        applicationVersionGateway.generateCode(applicationJson.toString(), outputStream);
    }

    private static Map<String, Object> getDomainDesignInfoMap(DomainDesignVersionDO domainDesignVersionDO, DomainDesignDO domainDesignDO) {
        Map<String, Object> map = new HashMap<>();
        map.put("name", domainDesignDO.getIdentity());
        map.put("title", domainDesignDO.getName());
        map.put("version", domainDesignVersionDO.getCurrentVersion());
        map.put("description", domainDesignDO.getDescription());
        return map;
    }

    private static Map<String, Object> getBusinessSceneInfoMap(BusinessSceneVersionDO businessSceneVersionDO, BusinessSceneDO businessSceneDO) {
        Map<String, Object> map = new HashMap<>();
        map.put("name", businessSceneDO.getIdentity());
        map.put("title", businessSceneDO.getName());
        map.put("version", businessSceneVersionDO.getCurrentVersion());
        map.put("description", businessSceneDO.getDescription());
        return map;
    }

    private static HashMap<String, Object> getApplicationInfoMap(ApplicationVersion applicationVersion, ApplicationDO applicationDO) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", applicationDO.getIdentity());
        map.put("title", applicationDO.getName());
        map.put("description", applicationDO.getDescription());
        map.put("package", applicationDO.getPackageName());
        map.put("version", applicationVersion.getCurrentVersion());
        return map;
    }

    private static boolean notMyself(Long id, List<ApplicationVersionDO> applicationVersionDOList) {
        return applicationVersionDOList.size() == 1
                && !Objects.equals(applicationVersionDOList.get(0).getApplicationId(), id);
    }
}
