package com.wakedt.visual.app.businessscene;

import com.wakedata.common.core.dto.ResultDTO;
import com.wakedata.common.core.exception.BizException;
import com.wakedt.visual.app.businessscene.assembler.*;
import com.wakedt.visual.app.businessscene.view.BusinessSceneVersionDetailQueryExe;
import com.wakedt.visual.app.businessscene.view.BusinessSceneVersionPageQueryExe;
import com.wakedt.visual.client.businessscene.BusinessSceneVersionRpcService;
import com.wakedt.visual.client.businessscene.dto.*;
import com.wakedt.visual.client.businessscene.query.BusinessSceneVersionDetailQuery;
import com.wakedt.visual.client.businessscene.query.BusinessSceneVersionPageQuery;
import com.wakedt.visual.domain.businessscene.businesssceneversion.create.BusinessSceneVersionCreateCmd;
import com.wakedt.visual.domain.businessscene.businesssceneversion.create.BusinessSceneVersionCreateCmdHandler;
import com.wakedt.visual.domain.businessscene.businesssceneversion.dslupdate.BusinessSceneDSLUpdateCmd;
import com.wakedt.visual.domain.businessscene.businesssceneversion.dslupdate.BusinessSceneDSLUpdateCmdHandler;
import com.wakedt.visual.domain.businessscene.businesssceneversion.remove.BusinessSceneVersionRemoveCmd;
import com.wakedt.visual.domain.businessscene.businesssceneversion.remove.BusinessSceneVersionRemoveCmdHandler;
import com.wakedt.visual.domain.businessscene.businesssceneversion.update.BusinessSceneVersionUpdateCmd;
import com.wakedt.visual.domain.businessscene.businesssceneversion.update.BusinessSceneVersionUpdateCmdHandler;
import com.wakedt.visual.domain.businessscene.businesssceneversion.versionpblish.BusinessSceneVersionPblishCmdHandler;
import com.wakedt.visual.domain.businessscene.businesssceneversion.versionpblish.BusinessSceneVersionPublishCmd;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * 业务场景版本-聚合根-RPC能力接口实现
 *
 * @author zhuxueliang
 */
@Service
public class BusinessSceneVersionRpcServiceImpl implements BusinessSceneVersionRpcService {

    @Resource
    private BusinessSceneVersionCreateCmdHandler businessSceneVersionCreateCmdHandler;
    @Resource
    private BusinessSceneVersionUpdateCmdHandler businessSceneVersionUpdateCmdHandler;
    @Resource
    private BusinessSceneVersionRemoveCmdHandler businessSceneVersionRemoveCmdHandler;
    @Resource
    private BusinessSceneVersionPblishCmdHandler businessSceneVersionPblishCmdHandler;
    @Resource
    private BusinessSceneDSLUpdateCmdHandler businessSceneDSLUpdateCmdHandler;
    @Resource
    private BusinessSceneVersionDetailQueryExe businessSceneVersionDetailQueryExe;
    @Resource
    private BusinessSceneVersionPageQueryExe businessSceneVersionPageQueryExe;


    @Override
    public ResultDTO<Long> businessSceneVersionCreate(BusinessSceneVersionCreateDTO dto) {
        BusinessSceneVersionDTO startVersionDTO = getStartVersionById(dto.getStartVersionId());

        // 1.根据起始版本，新增业务场景版本
        String startVersion = Optional.ofNullable(startVersionDTO.getCurrentVersion()).orElse(StringUtils.EMPTY);
        BusinessSceneVersionCreateCmd createCmd = BusinessSceneVersionCreateDTOConvert.INSTANCE.dto2Do(dto);
        createCmd.setStartVersion(startVersion);
        Long newVersionId = businessSceneVersionCreateCmdHandler.handle(createCmd);

        // 2.拷贝起始版本的DSL
        businessSceneDSLUpdateCmdHandler.handle(
                new BusinessSceneDSLUpdateCmd(newVersionId, startVersionDTO.getDsl(), startVersionDTO.getGraphDsl()));
        return ResultDTO.success(newVersionId);
    }

    private BusinessSceneVersionDTO getStartVersionById(Long id) {
        BusinessSceneVersionDetailQuery detailQuery = new BusinessSceneVersionDetailQuery();
        detailQuery.setId(id);
        BusinessSceneVersionDTO startVersionDTO = businessSceneVersionDetailQueryExe.execute(detailQuery).getData();
        if (startVersionDTO == null) {
            throw new BizException("起始版本ID不存在！");
        }
        return startVersionDTO;
    }

    @Override
    public ResultDTO<Boolean> businessSceneVersionUpdate(BusinessSceneVersionUpdateDTO businessSceneVersionUpdateDto) {
        BusinessSceneVersionUpdateCmd businessSceneVersionUpdateCmd =
            BusinessSceneVersionUpdateDTOConvert.INSTANCE.dto2Do(businessSceneVersionUpdateDto);
        businessSceneVersionUpdateCmdHandler.handle(businessSceneVersionUpdateCmd);
        return ResultDTO.success(Boolean.TRUE);
    }

    @Override
    public ResultDTO<Boolean> businessSceneVersionRemove(BusinessSceneVersionRemoveDTO businessSceneVersionRemoveDto) {
        BusinessSceneVersionRemoveCmd businessSceneVersionRemoveCmd =
            BusinessSceneVersionRemoveDTOConvert.INSTANCE.dto2Do(businessSceneVersionRemoveDto);
        businessSceneVersionRemoveCmdHandler.handle(businessSceneVersionRemoveCmd);
        return ResultDTO.success(Boolean.TRUE);
    }

    @Override
    public ResultDTO<Boolean> businessSceneVersionPblish(BusinessSceneVersionPublishDTO businessSceneVersionPublishDto) {
        BusinessSceneVersionPublishCmd businessSceneVersionPublishCmd =
            BusinessSceneVersionPblishDTOConvert.INSTANCE.dto2Do(businessSceneVersionPublishDto);
        businessSceneVersionPblishCmdHandler.handle(businessSceneVersionPublishCmd);
        return ResultDTO.success(Boolean.TRUE);
    }

    @Override
    public ResultDTO<Boolean> businessSceneDSLUpdate(BusinessSceneDSLUpdateDTO businessSceneDSLUpdateDto) {
        BusinessSceneDSLUpdateCmd businessSceneDSLUpdateCmd =
            BusinessSceneDSLUpdateDTOConvert.INSTANCE.dto2Do(businessSceneDSLUpdateDto);
        businessSceneDSLUpdateCmdHandler.handle(businessSceneDSLUpdateCmd);
        return ResultDTO.success(Boolean.TRUE);
    }

    @Override
    public ResultDTO<BusinessSceneVersionDTO> businessSceneVersionDetailQuery(BusinessSceneVersionDetailQuery query) {
        return businessSceneVersionDetailQueryExe.execute(query);
    }

    @Override
    public ResultDTO<List<BusinessSceneVersionDTO>> businessSceneVersionPageQuery(BusinessSceneVersionPageQuery pageQuery) {
        return businessSceneVersionPageQueryExe.execute(pageQuery);
    }

}