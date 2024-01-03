package com.wakedt.visual.app.organization;

import com.wakedata.common.core.dto.ResultDTO;
import com.wakedt.visual.app.organization.assembler.*;
import com.wakedt.visual.app.organization.view.OrganizationDetailQueryExe;
import com.wakedt.visual.app.organization.view.OrganizationPageQueryExe;
import com.wakedt.visual.client.organization.OrganizationRpcService;
import com.wakedt.visual.client.organization.dto.*;
import com.wakedt.visual.client.organization.query.OrganizationDetailQuery;
import com.wakedt.visual.client.organization.query.OrganizationPageQuery;
import com.wakedt.visual.domain.organization.organization.create.OrganizationCreateCmdHandler;
import com.wakedt.visual.domain.organization.organization.managerbind.OrganizationManagerBindCmd;
import com.wakedt.visual.domain.organization.organization.managerbind.OrganizationManagerBindCmdHandler;
import com.wakedt.visual.domain.organization.organization.managerunbind.OrganizationManagerUnbindCmd;
import com.wakedt.visual.domain.organization.organization.managerunbind.OrganizationManagerUnbindCmdHandler;
import com.wakedt.visual.domain.organization.organization.remove.OrganizationRemoveCmd;
import com.wakedt.visual.domain.organization.organization.remove.OrganizationRemoveCmdHandler;
import com.wakedt.visual.domain.organization.organization.update.OrganizationUpdateCmdHandler;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * 组织-聚合根-RPC能力接口实现
 *
 * @author zhuxueliang
 */
@Service
public class OrganizationRpcServiceImpl implements OrganizationRpcService {

    @Resource
    private OrganizationCreateCmdHandler organizationCreateCmdHandler;
    @Resource
    private OrganizationUpdateCmdHandler organizationUpdateCmdHandler;
    @Resource
    private OrganizationRemoveCmdHandler organizationRemoveCmdHandler;
    @Resource
    private OrganizationManagerBindCmdHandler organizationManagerBindCmdHandler;
    @Resource
    private OrganizationManagerUnbindCmdHandler organizationManagerUnbindCmdHandler;
    @Resource
    private OrganizationPageQueryExe organizationPageQueryExe;
    @Resource
    private OrganizationDetailQueryExe organizationDetailQueryExe;


    @Override
    public ResultDTO<Boolean> organizationCreate(OrganizationCreateDTO dto) {
        organizationCreateCmdHandler.handle(OrganizationCreateDTOConvert.INSTANCE.dto2Do(dto));
        return ResultDTO.success(Boolean.TRUE);
    }

    @Override
    public ResultDTO<Boolean> organizationUpdate(OrganizationUpdateDTO dto) {
        organizationUpdateCmdHandler.handle(OrganizationUpdateDTOConvert.INSTANCE.dto2Do(dto));
        return ResultDTO.success(Boolean.TRUE);
    }

    @Override
    public ResultDTO<Boolean> organizationRemove(OrganizationRemoveDTO organizationRemoveDto) {
        OrganizationRemoveCmd organizationRemoveCmd =
            OrganizationRemoveDTOConvert.INSTANCE.dto2Do(organizationRemoveDto);
        organizationRemoveCmdHandler.handle(organizationRemoveCmd);
        return ResultDTO.success(Boolean.TRUE);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResultDTO<Boolean> organizationBatchRemove(OrganizationBatchRemoveDTO dto) {
        List<Long> idList = Optional.ofNullable(dto.getIdList()).orElse(Collections.emptyList());
        idList.forEach(id -> organizationRemoveCmdHandler.handle(new OrganizationRemoveCmd(id)));
        return ResultDTO.success(Boolean.TRUE);
    }

    @Override
    public ResultDTO<Boolean> organizationManagerBind(OrganizationManagerBindDTO organizationManagerBindDto) {
        OrganizationManagerBindCmd organizationManagerBindCmd =
            OrganizationManagerBindDTOConvert.INSTANCE.dto2Do(organizationManagerBindDto);
        organizationManagerBindCmdHandler.handle(organizationManagerBindCmd);
        return ResultDTO.success(Boolean.TRUE);
    }

    @Override
    public ResultDTO<Boolean> organizationManagerUnbind(OrganizationManagerUnbindDTO organizationManagerUnbindDto) {
        OrganizationManagerUnbindCmd organizationManagerUnbindCmd =
            OrganizationManagerUnbindDTOConvert.INSTANCE.dto2Do(organizationManagerUnbindDto);
        organizationManagerUnbindCmdHandler.handle(organizationManagerUnbindCmd);
        return ResultDTO.success(Boolean.TRUE);
    }

    @Override
    public ResultDTO<List<OrganizationDTO>> organizationPageQuery(OrganizationPageQuery pageQuery) {
        return organizationPageQueryExe.execute(pageQuery);
    }

    @Override
    public ResultDTO<OrganizationDTO> organizationDetailQuery(OrganizationDetailQuery query) {
        return organizationDetailQueryExe.execute(query);
    }

}