package com.wakedt.visual.app.domaindesign.view;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.wakedata.common.core.dto.ResultDTO;
import com.wakedt.visual.app.domaindesign.assembler.DomainDesignDTO2DOConvert;
import com.wakedt.visual.app.domaindesign.assembler.DomainDesignVersionDTO2DOConvert;
import com.wakedt.visual.client.domaindesign.dto.DomainDesignDTO;
import com.wakedt.visual.client.domaindesign.dto.DomainDesignVersionDTO;
import com.wakedt.visual.client.domaindesign.query.DomainDesignDetailQuery;
import com.wakedt.visual.domain.common.constant.MsgCodeEnum;
import com.wakedt.visual.domain.common.constant.VisualException;
import com.wakedt.visual.domain.common.util.version.VersionSortUtil;
import com.wakedt.visual.infrastructure.domaindesign.repository.mapper.DomainDesignMapper;
import com.wakedt.visual.infrastructure.domaindesign.repository.mapper.DomainDesignVersionMapper;
import com.wakedt.visual.infrastructure.domaindesign.repository.model.DomainDesignDO;
import com.wakedt.visual.infrastructure.domaindesign.repository.model.DomainDesignVersionDO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 查询业务域详情-查询器
 *
 * @author zhuxueliang
 */
@Component
public class DomainDesignDetailQueryExe {

    @Resource
    private DomainDesignMapper domaindesignMapper;
    @Resource
    private DomainDesignVersionMapper domainDesignVersionMapper;

    public ResultDTO<DomainDesignDTO> execute(DomainDesignDetailQuery query) {
        DomainDesignDO domaindesignDO = Optional.ofNullable(domaindesignMapper.domainDesignDetailQuery(query))
                .orElseThrow(() -> new VisualException(MsgCodeEnum.NO_FIND_RESOURCE));
        DomainDesignDTO domainDesignDTO = DomainDesignDTO2DOConvert.INSTANCE.do2Dto(domaindesignDO);

        DomainDesignVersionDTO domainDesignVersionDTO = DomainDesignVersionDTO2DOConvert.INSTANCE.do2Dto(
                getDomainDesignLatestVersionDO(query));
        domainDesignDTO.setDomainDesignLatestVersion(domainDesignVersionDTO);

        return ResultDTO.success(domainDesignDTO);
    }

    private DomainDesignVersionDO getDomainDesignLatestVersionDO(DomainDesignDetailQuery query) {
        List<DomainDesignVersionDO> domainDesignVersionList = domainDesignVersionMapper.selectList(
                new LambdaQueryWrapper<DomainDesignVersionDO>().eq(DomainDesignVersionDO::getDomainDesignId, query.getId()));

        Map<String, DomainDesignVersionDO> versionMap = domainDesignVersionList.stream()
                .collect(Collectors.toMap(DomainDesignVersionDO::getCurrentVersion, data -> data, (a, b) -> b));
        return VersionSortUtil.getLatestVersionData(versionMap);
    }
}
