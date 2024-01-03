package com.wakedt.visual.app.application;

import com.wakedata.common.core.dto.ResultDTO;
import com.wakedt.visual.app.application.assembler.ApplicationCreateDTOConvert;
import com.wakedt.visual.app.application.assembler.ApplicationRemoveDTOConvert;
import com.wakedt.visual.app.application.assembler.ApplicationUpdateDTOConvert;
import com.wakedt.visual.app.application.view.ApplicationDetailQueryExe;
import com.wakedt.visual.app.application.view.ApplicationListQueryExe;
import com.wakedt.visual.app.application.view.ApplicationPageQueryExe;
import com.wakedt.visual.client.application.ApplicationRpcService;
import com.wakedt.visual.client.application.dto.ApplicationCreateDTO;
import com.wakedt.visual.client.application.dto.ApplicationDTO;
import com.wakedt.visual.client.application.dto.ApplicationRemoveDTO;
import com.wakedt.visual.client.application.dto.ApplicationUpdateDTO;
import com.wakedt.visual.client.application.query.ApplicationDetailQuery;
import com.wakedt.visual.client.application.query.ApplicationListQuery;
import com.wakedt.visual.client.application.query.ApplicationPageQuery;
import com.wakedt.visual.domain.application.application.create.ApplicationCreateCmdHandler;
import com.wakedt.visual.domain.application.application.remove.ApplicationRemoveCmd;
import com.wakedt.visual.domain.application.application.remove.ApplicationRemoveCmdHandler;
import com.wakedt.visual.domain.application.application.update.ApplicationUpdateCmd;
import com.wakedt.visual.domain.application.application.update.ApplicationUpdateCmdHandler;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 应用-聚合根-RPC能力接口实现
 *
 * @author zhuxueliang
 */
@Service
public class ApplicationRpcServiceImpl implements ApplicationRpcService {

    @Resource
    private ApplicationCreateCmdHandler applicationCreateCmdHandler;
    @Resource
    private ApplicationUpdateCmdHandler applicationUpdateCmdHandler;
    @Resource
    private ApplicationRemoveCmdHandler applicationRemoveCmdHandler;
    @Resource
    private ApplicationDetailQueryExe applicationDetailQueryExe;
    @Resource
    private ApplicationListQueryExe applicationListQueryExe;
    @Resource
    private ApplicationPageQueryExe applicationPageQueryExe;


    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResultDTO<Long> applicationCreate(ApplicationCreateDTO dto) {
        Long id = applicationCreateCmdHandler.handle(ApplicationCreateDTOConvert.INSTANCE.dto2Do(dto));
        return ResultDTO.success(id);
    }

    @Override
    public ResultDTO<Boolean> applicationUpdate(ApplicationUpdateDTO applicationUpdateDto) {
        ApplicationUpdateCmd applicationUpdateCmd =
                ApplicationUpdateDTOConvert.INSTANCE.dto2Do(applicationUpdateDto);
        applicationUpdateCmdHandler.handle(applicationUpdateCmd);
        return ResultDTO.success(Boolean.TRUE);
    }

    @Override
    public ResultDTO<Boolean> applicationRemove(ApplicationRemoveDTO applicationRemoveDto) {
        ApplicationRemoveCmd applicationRemoveCmd =
                ApplicationRemoveDTOConvert.INSTANCE.dto2Do(applicationRemoveDto);
        applicationRemoveCmdHandler.handle(applicationRemoveCmd);
        return ResultDTO.success(Boolean.TRUE);
    }

    @Override
    public ResultDTO<ApplicationDTO> applicationDetailQuery(ApplicationDetailQuery query) {
        return applicationDetailQueryExe.execute(query);
    }

    @Override
    public ResultDTO<List<ApplicationDTO>> applicationListQuery(ApplicationListQuery query) {
        return applicationListQueryExe.execute(query);
    }

    @Override
    public ResultDTO<List<ApplicationDTO>> applicationPageQuery(ApplicationPageQuery pageQuery) {
        return applicationPageQueryExe.execute(pageQuery);
    }

}