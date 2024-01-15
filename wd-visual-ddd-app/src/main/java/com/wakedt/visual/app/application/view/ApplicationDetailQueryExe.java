package com.wakedt.visual.app.application.view;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.wakedata.common.core.dto.ResultDTO;
import com.wakedt.visual.app.application.assembler.ApplicationDTO2DOConvert;
import com.wakedt.visual.client.application.dto.ApplicationDTO;
import com.wakedt.visual.client.application.dto.ApplicationVersionDTO;
import com.wakedt.visual.client.application.query.ApplicationDetailQuery;
import com.wakedt.visual.client.application.query.ApplicationVersionDetailQuery;
import com.wakedt.visual.domain.common.constant.MsgCodeEnum;
import com.wakedt.visual.domain.common.constant.VisualException;
import com.wakedt.visual.domain.common.util.version.VersionSortUtil;
import com.wakedt.visual.infrastructure.application.repository.mapper.ApplicationMapper;
import com.wakedt.visual.infrastructure.application.repository.mapper.ApplicationVersionMapper;
import com.wakedt.visual.infrastructure.application.repository.model.ApplicationDO;
import com.wakedt.visual.infrastructure.application.repository.model.ApplicationVersionDO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 查询应用详情-查询器
 *
 * @author zhuxueliang
 */
@Component
public class ApplicationDetailQueryExe {

    @Resource
    private ApplicationMapper applicationMapper;
    @Resource
    private ApplicationVersionMapper applicationVersionMapper;
    @Resource
    private ApplicationVersionDetailExcludeDslQueryExe applicationVersionDetailQueryExe;

    public ResultDTO<ApplicationDTO> execute(ApplicationDetailQuery query) {
        ApplicationDO applicationDO = Optional.ofNullable(applicationMapper.applicationDetailQuery(query))
                .orElseThrow(() -> new VisualException(MsgCodeEnum.NO_FIND_RESOURCE));
        ApplicationDTO applicationDTO = ApplicationDTO2DOConvert.INSTANCE.do2Dto(applicationDO);
        applicationDTO.setApplicationLatestVersion(getApplicationLatestVersionDTO(query));
        return ResultDTO.success(applicationDTO);
    }

    private ApplicationVersionDTO getApplicationLatestVersionDTO(ApplicationDetailQuery query) {
        ApplicationVersionDO applicationLatestVersionDO = getApplicationLatestVersionDO(query);
        ApplicationVersionDetailQuery detailQuery = new ApplicationVersionDetailQuery();
        detailQuery.setId(applicationLatestVersionDO.getId());
        ResultDTO<ApplicationVersionDTO> resultDTO = applicationVersionDetailQueryExe.execute(detailQuery);
        return resultDTO.getData();
    }

    private ApplicationVersionDO getApplicationLatestVersionDO(ApplicationDetailQuery query) {
        List<ApplicationVersionDO> applicationVersionList = applicationVersionMapper.selectList(
                new LambdaQueryWrapper<ApplicationVersionDO>().eq(ApplicationVersionDO::getApplicationId, query.getId()));

        Map<String, ApplicationVersionDO> versionMap = applicationVersionList.stream()
                .collect(Collectors.toMap(ApplicationVersionDO::getCurrentVersion, data -> data, (a, b) -> b));
        return VersionSortUtil.getLatestVersionData(versionMap);
    }
}
