package com.wakedt.visual.app.application.view;

import cn.hutool.core.collection.CollUtil;
import com.wakedata.common.core.dto.ResultDTO;
import com.wakedt.visual.app.application.assembler.ApplicationVersionDTO2DOConvert;
import com.wakedt.visual.app.businessscene.assembler.BusinessSceneDTO2DOConvert;
import com.wakedt.visual.app.businessscene.assembler.BusinessSceneVersionDTO2DOConvert;
import com.wakedt.visual.app.domaindesign.assembler.DomainDesignDTO2DOConvert;
import com.wakedt.visual.app.domaindesign.assembler.DomainDesignVersionDTO2DOConvert;
import com.wakedt.visual.client.application.dto.ApplicationVersionDTO;
import com.wakedt.visual.client.application.query.ApplicationVersionDetailQuery;
import com.wakedt.visual.client.businessscene.dto.BusinessSceneVersionDTO;
import com.wakedt.visual.client.domaindesign.dto.DomainDesignVersionDTO;
import com.wakedt.visual.domain.common.constant.MsgCodeEnum;
import com.wakedt.visual.domain.common.constant.VisualException;
import com.wakedt.visual.infrastructure.application.repository.mapper.ApplicationVersionMapper;
import com.wakedt.visual.infrastructure.application.repository.model.ApplicationVersionDO;
import com.wakedt.visual.infrastructure.businessscene.repository.mapper.BusinessSceneMapper;
import com.wakedt.visual.infrastructure.businessscene.repository.mapper.BusinessSceneVersionMapper;
import com.wakedt.visual.infrastructure.businessscene.repository.model.BusinessSceneDO;
import com.wakedt.visual.infrastructure.businessscene.repository.model.BusinessSceneVersionDO;
import com.wakedt.visual.infrastructure.domaindesign.repository.mapper.DomainDesignMapper;
import com.wakedt.visual.infrastructure.domaindesign.repository.mapper.DomainDesignVersionMapper;
import com.wakedt.visual.infrastructure.domaindesign.repository.model.DomainDesignDO;
import com.wakedt.visual.infrastructure.domaindesign.repository.model.DomainDesignVersionDO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * 查询应用版本详情,不包含DSL - 查询器
 *
 * @author zhuxueliang
 */
@Component
public class ApplicationVersionDetailExcludeDslQueryExe {

    @Resource
    private ApplicationVersionMapper applicationversionMapper;
    @Resource
    private BusinessSceneVersionMapper businessSceneVersionMapper;
    @Resource
    private DomainDesignVersionMapper domainDesignVersionMapper;
    @Resource
    private BusinessSceneMapper businessSceneMapper;
    @Resource
    private DomainDesignMapper domainDesignMapper;

    public ResultDTO<ApplicationVersionDTO> execute(ApplicationVersionDetailQuery query) {
        ApplicationVersionDO applicationversionDO = Optional.ofNullable(applicationversionMapper.applicationVersionDetailQuery(query))
                .orElseThrow(() -> new VisualException(MsgCodeEnum.NO_FIND_RESOURCE));
        ApplicationVersionDTO applicationVersionDTO = ApplicationVersionDTO2DOConvert.INSTANCE.do2Dto(applicationversionDO);

        // 填充应用关联的业务域和业务场景版本信息
        List<Long> businessSceneVersionIds = applicationVersionDTO.getBusinessSceneVersionIds();
        if (CollUtil.isNotEmpty(businessSceneVersionIds)) {
            applicationVersionDTO.setBusinessSceneVersionDTOList(businessSceneVersionQueryByBatchIds(businessSceneVersionIds));
        }
        List<Long> domainDesignVersionIds = applicationVersionDTO.getDomainDesignVersionIds();
        if (CollUtil.isNotEmpty(domainDesignVersionIds)) {
            applicationVersionDTO.setDomainDesignVersionDTOList(domainDesignVersionQueryByBatchIds(domainDesignVersionIds));
        }

        return ResultDTO.success(applicationVersionDTO);
    }

    private List<DomainDesignVersionDTO> domainDesignVersionQueryByBatchIds(List<Long> domainDesignVersionIds) {
        List<DomainDesignVersionDO> domainDesignVersionDOS = domainDesignVersionMapper.selectBatchIdsExcludeDsl(domainDesignVersionIds);
        List<DomainDesignVersionDTO> domainDesignVersionDTOList = DomainDesignVersionDTO2DOConvert.INSTANCE.doList2DtoList(domainDesignVersionDOS);

        // 填充业务域信息
        for (DomainDesignVersionDTO domainDesignVersionDTO : domainDesignVersionDTOList) {
            DomainDesignDO domainDesignDO = domainDesignMapper.selectById(domainDesignVersionDTO.getDomainDesignId());
            domainDesignVersionDTO.setDomainDesignDTO(DomainDesignDTO2DOConvert.INSTANCE.do2Dto(domainDesignDO));
        }

        return domainDesignVersionDTOList;
    }

    private List<BusinessSceneVersionDTO> businessSceneVersionQueryByBatchIds(List<Long> businessSceneVersionIds) {
        List<BusinessSceneVersionDO> businessSceneVersionDOS = businessSceneVersionMapper.selectBatchIdsExcludeDsl(businessSceneVersionIds);
        List<BusinessSceneVersionDTO> businessSceneVersionDTOList = BusinessSceneVersionDTO2DOConvert.INSTANCE.doList2DtoList(businessSceneVersionDOS);

        // 填充业务场景信息
        for (BusinessSceneVersionDTO businessSceneVersionDTO : businessSceneVersionDTOList) {
            BusinessSceneDO businessSceneDO = businessSceneMapper.selectById(businessSceneVersionDTO.getBusinessSceneId());
            businessSceneVersionDTO.setBusinessSceneDTO(BusinessSceneDTO2DOConvert.INSTANCE.do2Dto(businessSceneDO));
        }

        return businessSceneVersionDTOList;
    }
}
