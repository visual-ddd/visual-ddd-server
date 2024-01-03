package com.wakedt.visual.app.businessscene;

import com.wakedata.common.core.dto.ResultDTO;
import com.wakedt.visual.app.businessscene.assembler.BusinessSceneCreateDTOConvert;
import com.wakedt.visual.app.businessscene.assembler.BusinessSceneRemoveDTOConvert;
import com.wakedt.visual.app.businessscene.assembler.BusinessSceneUpdateDTOConvert;
import com.wakedt.visual.app.businessscene.view.BusinessSceneDetailQueryExe;
import com.wakedt.visual.app.businessscene.view.BusinessSceneListQueryExe;
import com.wakedt.visual.app.businessscene.view.BusinessScenePageQueryExe;
import com.wakedt.visual.client.businessscene.BusinessSceneRpcService;
import com.wakedt.visual.client.businessscene.dto.BusinessSceneCreateDTO;
import com.wakedt.visual.client.businessscene.dto.BusinessSceneDTO;
import com.wakedt.visual.client.businessscene.dto.BusinessSceneRemoveDTO;
import com.wakedt.visual.client.businessscene.dto.BusinessSceneUpdateDTO;
import com.wakedt.visual.client.businessscene.query.BusinessSceneDetailQuery;
import com.wakedt.visual.client.businessscene.query.BusinessSceneListQuery;
import com.wakedt.visual.client.businessscene.query.BusinessScenePageQuery;
import com.wakedt.visual.domain.businessscene.businessscene.create.BusinessSceneCreateCmdHandler;
import com.wakedt.visual.domain.businessscene.businessscene.remove.BusinessSceneRemoveCmd;
import com.wakedt.visual.domain.businessscene.businessscene.remove.BusinessSceneRemoveCmdHandler;
import com.wakedt.visual.domain.businessscene.businessscene.update.BusinessSceneUpdateCmd;
import com.wakedt.visual.domain.businessscene.businessscene.update.BusinessSceneUpdateCmdHandler;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 业务场景-聚合根-RPC能力接口实现
 *
 * @author zhuxueliang
 */
@Service
public class BusinessSceneRpcServiceImpl implements BusinessSceneRpcService {

    @Resource
    private BusinessSceneCreateCmdHandler businessSceneCreateCmdHandler;
    @Resource
    private BusinessSceneUpdateCmdHandler businessSceneUpdateCmdHandler;
    @Resource
    private BusinessSceneRemoveCmdHandler businessSceneRemoveCmdHandler;
    @Resource
    private BusinessSceneDetailQueryExe businessSceneDetailQueryExe;
    @Resource
    private BusinessSceneListQueryExe businessSceneListQueryExe;
    @Resource
    private BusinessScenePageQueryExe businessScenePageQueryExe;


    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResultDTO<Long> businessSceneCreate(BusinessSceneCreateDTO dto) {
        Long id = businessSceneCreateCmdHandler.handle(BusinessSceneCreateDTOConvert.INSTANCE.dto2Do(dto));
        return ResultDTO.success(id);
    }

    @Override
    public ResultDTO<Boolean> businessSceneUpdate(BusinessSceneUpdateDTO businessSceneUpdateDto) {
        BusinessSceneUpdateCmd businessSceneUpdateCmd =
            BusinessSceneUpdateDTOConvert.INSTANCE.dto2Do(businessSceneUpdateDto);
        businessSceneUpdateCmdHandler.handle(businessSceneUpdateCmd);
        return ResultDTO.success(Boolean.TRUE);
    }

    @Override
    public ResultDTO<Boolean> businessSceneRemove(BusinessSceneRemoveDTO businessSceneRemoveDto) {
        BusinessSceneRemoveCmd businessSceneRemoveCmd =
            BusinessSceneRemoveDTOConvert.INSTANCE.dto2Do(businessSceneRemoveDto);
        businessSceneRemoveCmdHandler.handle(businessSceneRemoveCmd);
        return ResultDTO.success(Boolean.TRUE);
    }

    @Override
    public ResultDTO<BusinessSceneDTO> businessSceneDetailQuery(BusinessSceneDetailQuery query) {
        return businessSceneDetailQueryExe.execute(query);
    }

    @Override
    public ResultDTO<List<BusinessSceneDTO>> businessSceneListQuery(BusinessSceneListQuery query) {
        return businessSceneListQueryExe.execute(query);
    }

    @Override
    public ResultDTO<List<BusinessSceneDTO>> businessScenePageQuery(BusinessScenePageQuery pageQuery) {
        return businessScenePageQueryExe.execute(pageQuery);
    }

}