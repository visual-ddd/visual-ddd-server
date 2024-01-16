package com.wakedt.visual.app.application;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.wakedata.common.core.dto.ResultDTO;
import com.wakedata.common.core.exception.BizException;
import com.wakedt.visual.app.application.assembler.*;
import com.wakedt.visual.app.application.view.ApplicationVersionDetailExcludeDslQueryExe;
import com.wakedt.visual.app.application.view.ApplicationVersionPageQueryExe;
import com.wakedt.visual.client.application.ApplicationVersionRpcService;
import com.wakedt.visual.client.application.dto.*;
import com.wakedt.visual.client.application.query.ApplicationVersionDetailQuery;
import com.wakedt.visual.client.application.query.ApplicationVersionPageQuery;
import com.wakedt.visual.domain.application.applicationversion.businesssceneversionbind.BusinessSceneVersionBindCmd;
import com.wakedt.visual.domain.application.applicationversion.businesssceneversionbind.BusinessSceneVersionBindCmdHandler;
import com.wakedt.visual.domain.application.applicationversion.codegenerate.ApplicationCodeGenerateCmd;
import com.wakedt.visual.domain.application.applicationversion.codegenerate.ApplicationCodeGenerateCmdHandler;
import com.wakedt.visual.domain.application.applicationversion.create.ApplicationVersionCreateCmd;
import com.wakedt.visual.domain.application.applicationversion.create.ApplicationVersionCreateCmdHandler;
import com.wakedt.visual.domain.application.applicationversion.domaindesignversionbind.DomainDesignVersionBindCmd;
import com.wakedt.visual.domain.application.applicationversion.domaindesignversionbind.DomainDesignVersionBindCmdHandler;
import com.wakedt.visual.domain.application.applicationversion.remove.ApplicationVersionRemoveCmd;
import com.wakedt.visual.domain.application.applicationversion.remove.ApplicationVersionRemoveCmdHandler;
import com.wakedt.visual.domain.application.applicationversion.update.ApplicationVersionUpdateCmd;
import com.wakedt.visual.domain.application.applicationversion.update.ApplicationVersionUpdateCmdHandler;
import com.wakedt.visual.domain.application.applicationversion.versionpublish.ApplicationVersionPublishCmdHandler;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;
import java.util.zip.ZipOutputStream;

/**
 * 应用版本-聚合根-RPC能力接口实现
 *
 * @author zhuxueliang
 */
@Service
public class ApplicationVersionRpcServiceImpl implements ApplicationVersionRpcService {

    @Resource
    private ApplicationVersionCreateCmdHandler applicationVersionCreateCmdHandler;
    @Resource
    private ApplicationVersionUpdateCmdHandler applicationVersionUpdateCmdHandler;
    @Resource
    private ApplicationVersionRemoveCmdHandler applicationVersionRemoveCmdHandler;
    @Resource
    private DomainDesignVersionBindCmdHandler domainDesignVersionBindCmdHandler;
    @Resource
    private BusinessSceneVersionBindCmdHandler businessSceneVersionBindCmdHandler;
    @Resource
    private ApplicationVersionPublishCmdHandler applicationVersionPublishCmdHandler;
    @Resource
    private ApplicationCodeGenerateCmdHandler applicationCodeGenerateCmdHandler;
    @Resource
    private ApplicationVersionDetailExcludeDslQueryExe applicationVersionDetailExcludeDslQueryExe;
    @Resource
    private ApplicationVersionPageQueryExe applicationVersionPageQueryExe;


    @Override
    public ResultDTO<Long> applicationVersionCreate(ApplicationVersionCreateDTO dto) {
        ApplicationVersionDTO startVersionDTO = getStartVersionById(dto.getStartVersionId());
        String startVersion = Optional.ofNullable(startVersionDTO.getCurrentVersion()).orElse(StringUtils.EMPTY);
        ApplicationVersionCreateCmd createCmd = ApplicationVersionCreateDTOConvert.INSTANCE.dto2Do(dto);
        createCmd.setStartVersion(startVersion);
        Long newVersionId = applicationVersionCreateCmdHandler.handle(createCmd);
        return ResultDTO.success(newVersionId);
    }

    private ApplicationVersionDTO getStartVersionById(Long id) {
        ApplicationVersionDetailQuery detailQuery = new ApplicationVersionDetailQuery();
        detailQuery.setId(id);
        ApplicationVersionDTO startVersionDTO = applicationVersionDetailExcludeDslQueryExe.execute(detailQuery).getData();
        if (startVersionDTO == null) {
            throw new BizException("起始版本ID不存在！");
        }
        return startVersionDTO;
    }

    @Override
    public ResultDTO<Boolean> applicationVersionUpdate(ApplicationVersionUpdateDTO applicationVersionUpdateDto) {
        ApplicationVersionUpdateCmd applicationVersionUpdateCmd =
            ApplicationVersionUpdateDTOConvert.INSTANCE.dto2Do(applicationVersionUpdateDto);
        applicationVersionUpdateCmdHandler.handle(applicationVersionUpdateCmd);
        return ResultDTO.success(Boolean.TRUE);
    }

    @Override
    public ResultDTO<Boolean> applicationVersionRemove(ApplicationVersionRemoveDTO applicationVersionRemoveDto) {
        ApplicationVersionRemoveCmd applicationVersionRemoveCmd =
            ApplicationVersionRemoveDTOConvert.INSTANCE.dto2Do(applicationVersionRemoveDto);
        applicationVersionRemoveCmdHandler.handle(applicationVersionRemoveCmd);
        return ResultDTO.success(Boolean.TRUE);
    }

    @Override
    public ResultDTO<Boolean> domainDesignVersionBind(DomainDesignVersionBindDTO domainDesignVersionBindDto) {
        DomainDesignVersionBindCmd domainDesignVersionBindCmd =
            DomainDesignVersionBindDTOConvert.INSTANCE.dto2Do(domainDesignVersionBindDto);
        domainDesignVersionBindCmdHandler.handle(domainDesignVersionBindCmd);
        return ResultDTO.success(Boolean.TRUE);
    }

    @Override
    public ResultDTO<Boolean> businessSceneVersionBind(BusinessSceneVersionBindDTO businessSceneVersionBindDto) {
        BusinessSceneVersionBindCmd businessSceneVersionBindCmd =
            BusinessSceneVersionBindDTOConvert.INSTANCE.dto2Do(businessSceneVersionBindDto);
        businessSceneVersionBindCmdHandler.handle(businessSceneVersionBindCmd);
        return ResultDTO.success(Boolean.TRUE);
    }

    @Override
    public ResultDTO<Boolean> applicationVersionPublish(ApplicationVersionPublishDTO dto) {
        applicationVersionPublishCmdHandler.handle(ApplicationVersionPublishDTOConvert.INSTANCE.dto2Do(dto));
        return ResultDTO.success(Boolean.TRUE);
    }

    @Override
    public ResultDTO<Boolean> applicationCodeGenerate(ApplicationCodeGenerateDTO dto, ZipOutputStream outputStream) {
        ApplicationCodeGenerateCmd codeGenerateCmd = ApplicationCodeGenerateDTOConvert.INSTANCE.dto2Do(dto);
        codeGenerateCmd.setOutputStream(outputStream);
        applicationCodeGenerateCmdHandler.handle(codeGenerateCmd);
        return ResultDTO.success(Boolean.TRUE);
    }

    @Override
    public ResultDTO<ApplicationVersionDTO> applicationVersionDetailQuery(ApplicationVersionDetailQuery query) {
        return applicationVersionDetailExcludeDslQueryExe.execute(query);
    }

    @Override
    public ResultDTO<ApplicationVersionDTO> applicationVersionDetailQueryExcludeDSL(ApplicationVersionDetailQuery query) {
        return applicationVersionDetailExcludeDslQueryExe.execute(query);
    }

    @Override
    public ResultDTO<List<ApplicationVersionDTO>> applicationVersionPageQuery(ApplicationVersionPageQuery pageQuery) {
        return applicationVersionPageQueryExe.execute(pageQuery);
    }

}