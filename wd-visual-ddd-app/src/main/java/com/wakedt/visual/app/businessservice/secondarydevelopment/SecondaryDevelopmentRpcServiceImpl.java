package com.wakedt.visual.app.businessservice.secondarydevelopment;

import com.wakedata.common.core.dto.ResultDTO;
import com.wakedata.common.core.util.BeanUtil;
import com.wakedt.visual.app.application.view.ApplicationDetailQueryExe;
import com.wakedt.visual.app.application.view.ApplicationVersionDetailQueryExe;
import com.wakedt.visual.app.businessscene.view.BusinessSceneDetailQueryExe;
import com.wakedt.visual.app.businessscene.view.BusinessSceneVersionDetailQueryExe;
import com.wakedt.visual.app.domaindesign.view.DomainDesignDetailQueryExe;
import com.wakedt.visual.app.domaindesign.view.DomainDesignVersionDetailQueryExe;
import com.wakedt.visual.client.application.dto.ApplicationDTO;
import com.wakedt.visual.client.application.dto.ApplicationVersionDTO;
import com.wakedt.visual.client.application.query.ApplicationDetailQuery;
import com.wakedt.visual.client.application.query.ApplicationVersionDetailQuery;
import com.wakedt.visual.client.businessscene.dto.BusinessSceneDTO;
import com.wakedt.visual.client.businessscene.dto.BusinessSceneVersionDTO;
import com.wakedt.visual.client.businessscene.query.BusinessSceneDetailQuery;
import com.wakedt.visual.client.businessscene.query.BusinessSceneVersionDetailQuery;
import com.wakedt.visual.client.businessservice.secondarydevelopment.SecondaryDevelopmentRpcService;
import com.wakedt.visual.client.businessservice.secondarydevelopment.dto.*;
import com.wakedt.visual.client.businessservice.secondarydevelopment.query.GetApplicationBindModelInfo;
import com.wakedt.visual.client.businessservice.secondarydevelopment.query.GetBusinessSceneVersionNoAuth;
import com.wakedt.visual.client.businessservice.secondarydevelopment.query.GetDomainDesignVersionNoAuth;
import com.wakedt.visual.client.domaindesign.dto.DomainDesignDTO;
import com.wakedt.visual.client.domaindesign.dto.DomainDesignVersionDTO;
import com.wakedt.visual.client.domaindesign.query.DomainDesignDetailQuery;
import com.wakedt.visual.client.domaindesign.query.DomainDesignVersionDetailQuery;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 描述快速进行二开场景-RPC能力接口实现
 */
@Service
public class SecondaryDevelopmentRpcServiceImpl implements SecondaryDevelopmentRpcService {

    @Resource
    private DomainDesignVersionDetailQueryExe domainDesignVersionDetailQueryExe;
    @Resource
    private DomainDesignDetailQueryExe domainDesignDetailQueryExe;
    @Resource
    private ApplicationDetailQueryExe applicationDetailQueryExe;
    @Resource
    private ApplicationVersionDetailQueryExe applicationVersionDetailQueryExe;
    @Resource
    private BusinessSceneDetailQueryExe businessSceneDetailQueryExe;
    @Resource
    private BusinessSceneVersionDetailQueryExe businessSceneVersionDetailQueryExe;

    @Override
    public ResultDTO<DomainDesignVersionInfoDTO> getDomainDesignVersionNoAuth(GetDomainDesignVersionNoAuth request) {
        DomainDesignVersionDetailQuery domainDesignVersionDetailQuery = new DomainDesignVersionDetailQuery(request.getId());
        DomainDesignVersionDTO domainDesignVersionDTO = domainDesignVersionDetailQueryExe.execute(domainDesignVersionDetailQuery).getData();

        DomainDesignDetailQuery domainDesignDetailQuery = new DomainDesignDetailQuery(domainDesignVersionDTO.getDomainDesignId());
        DomainDesignDTO domainDesignDTO = domainDesignDetailQueryExe.execute(domainDesignDetailQuery).getData();

        DomainDesignVersionInfoDTO result = BeanUtil.copy(domainDesignVersionDTO, DomainDesignVersionInfoDTO.class);
        com.wakedt.visual.client.businessservice.secondarydevelopment.dto.DomainDesignDTO designDTO =
                BeanUtil.copy(domainDesignDTO, com.wakedt.visual.client.businessservice.secondarydevelopment.dto.DomainDesignDTO.class);
        result.setDomainDesignDTO(designDTO);
        return ResultDTO.success(result);
    }

    @Override
    public ResultDTO<ApplicationBindModelInfoDTO> getApplicationBindModelInfo(GetApplicationBindModelInfo request) {
        ApplicationVersionDTO applicationVersionDTO = applicationVersionDetailQueryExe.execute(new ApplicationVersionDetailQuery(request.getId())).getData();
        ApplicationDTO applicationDTO = applicationDetailQueryExe.execute(new ApplicationDetailQuery(applicationVersionDTO.getApplicationId())).getData();

        ApplicationBindModelInfoDTO result = BeanUtil.copy(applicationVersionDTO, ApplicationBindModelInfoDTO.class);
        result.setApplicationDTO(BeanUtil.copy(applicationDTO,
                com.wakedt.visual.client.businessservice.secondarydevelopment.dto.ApplicationDTO.class));

        // 填充业务域信息
        List<Long> domainDesignVersionIds = applicationVersionDTO.getDomainDesignVersionIds();
        List<DomainDesignVersionBaseInfoDTO> designVersionInfoDTOS = new ArrayList<>();
        for (Long domainDesignVersionId : domainDesignVersionIds) {
            DomainDesignVersionDTO domainDesignVersionDTO = domainDesignVersionDetailQueryExe.execute(new DomainDesignVersionDetailQuery(domainDesignVersionId)).getData();
            DomainDesignVersionBaseInfoDTO domainDesignVersionBaseInfoDTO = BeanUtil.copy(domainDesignVersionDTO, DomainDesignVersionBaseInfoDTO.class);

            DomainDesignDTO domainDesignDTO = domainDesignDetailQueryExe.execute(new DomainDesignDetailQuery(domainDesignVersionDTO.getDomainDesignId())).getData();
            domainDesignVersionBaseInfoDTO.setDomainDesignDTO(
                    BeanUtil.copy(domainDesignDTO, com.wakedt.visual.client.businessservice.secondarydevelopment.dto.DomainDesignDTO.class));
            designVersionInfoDTOS.add(domainDesignVersionBaseInfoDTO);
        }
        result.setDomainDesignVersionInfos(designVersionInfoDTOS);

        // 填充业务场景信息
        List<Long> businessSceneVersionIds = applicationVersionDTO.getBusinessSceneVersionIds();
        List<BusinessScenarioVersionBaseInfoDTO> scenarioVersionInfoDTOS = new ArrayList<>();
        for (Long domainDesignVersionId : businessSceneVersionIds) {
            BusinessSceneVersionDTO businessSceneVersionDTO = businessSceneVersionDetailQueryExe.execute(new BusinessSceneVersionDetailQuery(domainDesignVersionId)).getData();
            BusinessScenarioVersionBaseInfoDTO businessScenarioVersionBaseInfoDTO = BeanUtil.copy(businessSceneVersionDTO, BusinessScenarioVersionBaseInfoDTO.class);

            BusinessSceneDTO businessSceneDTO = businessSceneDetailQueryExe.execute(new BusinessSceneDetailQuery(businessSceneVersionDTO.getBusinessSceneId())).getData();
            businessScenarioVersionBaseInfoDTO.setBusinessScenarioDTO(
                    BeanUtil.copy(businessSceneDTO, BusinessScenarioDTO.class));
            scenarioVersionInfoDTOS.add(businessScenarioVersionBaseInfoDTO);
        }
        result.setBusinessScenarioVersionInfos(scenarioVersionInfoDTOS);
        return ResultDTO.success(result);
    }

    @Override
    public ResultDTO<BusinessSceneVersionInfoDTO> getBusinessSceneVersionNoAuth(GetBusinessSceneVersionNoAuth request) {
        BusinessSceneVersionDetailQuery businessSceneVersionDetailQuery = new BusinessSceneVersionDetailQuery(request.getId());
        BusinessSceneVersionDTO businessSceneVersionDTO = businessSceneVersionDetailQueryExe.execute(businessSceneVersionDetailQuery).getData();

        BusinessSceneDetailQuery businessSceneDetailQuery = new BusinessSceneDetailQuery(businessSceneVersionDTO.getBusinessSceneId());
        BusinessSceneDTO businessSceneDTO = businessSceneDetailQueryExe.execute(businessSceneDetailQuery).getData();

        BusinessSceneVersionInfoDTO result = BeanUtil.copy(businessSceneVersionDTO, BusinessSceneVersionInfoDTO.class);
        result.setBusinessSceneDTO(BeanUtil.copy(businessSceneDTO, BusinessScenarioDTO.class));
        return ResultDTO.success(result);
    }
}