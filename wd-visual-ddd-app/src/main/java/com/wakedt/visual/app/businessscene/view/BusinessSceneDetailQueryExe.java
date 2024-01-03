package com.wakedt.visual.app.businessscene.view;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.wakedata.common.core.dto.ResultDTO;
import com.wakedt.visual.app.businessscene.assembler.BusinessSceneDTO2DOConvert;
import com.wakedt.visual.app.businessscene.assembler.BusinessSceneVersionDTO2DOConvert;
import com.wakedt.visual.client.businessscene.dto.BusinessSceneDTO;
import com.wakedt.visual.client.businessscene.dto.BusinessSceneVersionDTO;
import com.wakedt.visual.client.businessscene.query.BusinessSceneDetailQuery;
import com.wakedt.visual.domain.common.constant.MsgCodeEnum;
import com.wakedt.visual.domain.common.constant.VisualException;
import com.wakedt.visual.domain.common.util.version.VersionSortUtil;
import com.wakedt.visual.infrastructure.businessscene.repository.mapper.BusinessSceneMapper;
import com.wakedt.visual.infrastructure.businessscene.repository.mapper.BusinessSceneVersionMapper;
import com.wakedt.visual.infrastructure.businessscene.repository.model.BusinessSceneDO;
import com.wakedt.visual.infrastructure.businessscene.repository.model.BusinessSceneVersionDO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 查询业务场景详情-查询器
 *
 * @author zhuxueliang
 */
@Component
public class BusinessSceneDetailQueryExe {

    @Resource
    private BusinessSceneMapper businesssceneMapper;
    @Resource
    private BusinessSceneVersionMapper businessSceneVersionMapper;

    public ResultDTO<BusinessSceneDTO> execute(BusinessSceneDetailQuery query) {
        BusinessSceneDO businesssceneDO = Optional.ofNullable(businesssceneMapper.businessSceneDetailQuery(query))
                .orElseThrow(() -> new VisualException(MsgCodeEnum.NO_FIND_RESOURCE));
        BusinessSceneDTO businessSceneDTO = BusinessSceneDTO2DOConvert.INSTANCE.do2Dto(businesssceneDO);

        BusinessSceneVersionDTO businessSceneVersionDTO = BusinessSceneVersionDTO2DOConvert.INSTANCE.do2Dto(
                getBusinessSceneLatestVersionDO(query));
        businessSceneDTO.setBusinessSceneLatestVersion(businessSceneVersionDTO);

        return ResultDTO.success(businessSceneDTO);
    }

    private BusinessSceneVersionDO getBusinessSceneLatestVersionDO(BusinessSceneDetailQuery query) {
        List<BusinessSceneVersionDO> businessSceneVersionList = businessSceneVersionMapper.selectList(
                new LambdaQueryWrapper<BusinessSceneVersionDO>().eq(BusinessSceneVersionDO::getBusinessSceneId, query.getId()));

        Map<String, BusinessSceneVersionDO> versionMap = businessSceneVersionList.stream()
                .collect(Collectors.toMap(BusinessSceneVersionDO::getCurrentVersion, data -> data, (a, b) -> b));
        return VersionSortUtil.getLatestVersionData(versionMap);
    }

}
