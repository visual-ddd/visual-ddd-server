package com.wakedt.visual.app.domaindesign;

import com.wakedata.common.core.dto.ResultDTO;
import com.wakedt.visual.app.domaindesign.assembler.DomainDesignCreateDTOConvert;
import com.wakedt.visual.app.domaindesign.assembler.DomainDesignRemoveDTOConvert;
import com.wakedt.visual.app.domaindesign.assembler.DomainDesignUpdateDTOConvert;
import com.wakedt.visual.app.domaindesign.view.DomainDesignDetailQueryExe;
import com.wakedt.visual.app.domaindesign.view.DomainDesignListQueryExe;
import com.wakedt.visual.app.domaindesign.view.DomainDesignPageQueryExe;
import com.wakedt.visual.client.domaindesign.DomainDesignRpcService;
import com.wakedt.visual.client.domaindesign.dto.DomainDesignCreateDTO;
import com.wakedt.visual.client.domaindesign.dto.DomainDesignDTO;
import com.wakedt.visual.client.domaindesign.dto.DomainDesignRemoveDTO;
import com.wakedt.visual.client.domaindesign.dto.DomainDesignUpdateDTO;
import com.wakedt.visual.client.domaindesign.query.DomainDesignDetailQuery;
import com.wakedt.visual.client.domaindesign.query.DomainDesignListQuery;
import com.wakedt.visual.client.domaindesign.query.DomainDesignPageQuery;
import com.wakedt.visual.domain.domaindesign.domaindesign.create.DomainDesignCreateCmdHandler;
import com.wakedt.visual.domain.domaindesign.domaindesign.remove.DomainDesignRemoveCmd;
import com.wakedt.visual.domain.domaindesign.domaindesign.remove.DomainDesignRemoveCmdHandler;
import com.wakedt.visual.domain.domaindesign.domaindesign.update.DomainDesignUpdateCmd;
import com.wakedt.visual.domain.domaindesign.domaindesign.update.DomainDesignUpdateCmdHandler;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 业务域-聚合根-RPC能力接口实现
 *
 * @author zhuxueliang
 */
@Service
public class DomainDesignRpcServiceImpl implements DomainDesignRpcService {

    @Resource
    private DomainDesignCreateCmdHandler domainDesignCreateCmdHandler;
    @Resource
    private DomainDesignUpdateCmdHandler domainDesignUpdateCmdHandler;
    @Resource
    private DomainDesignRemoveCmdHandler domainDesignRemoveCmdHandler;
    @Resource
    private DomainDesignDetailQueryExe domainDesignDetailQueryExe;
    @Resource
    private DomainDesignListQueryExe domainDesignListQueryExe;
    @Resource
    private DomainDesignPageQueryExe domainDesignPageQueryExe;


    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResultDTO<Long> domainDesignCreate(DomainDesignCreateDTO dto) {
        Long id = domainDesignCreateCmdHandler.handle(DomainDesignCreateDTOConvert.INSTANCE.dto2Do(dto));
        return ResultDTO.success(id);
    }

    @Override
    public ResultDTO<Boolean> domainDesignUpdate(DomainDesignUpdateDTO domainDesignUpdateDto) {
        DomainDesignUpdateCmd domainDesignUpdateCmd = DomainDesignUpdateDTOConvert.INSTANCE.dto2Do(domainDesignUpdateDto);
        domainDesignUpdateCmdHandler.handle(domainDesignUpdateCmd);
        return ResultDTO.success(Boolean.TRUE);
    }

    @Override
    public ResultDTO<Boolean> domainDesignRemove(DomainDesignRemoveDTO domainDesignRemoveDto) {
        DomainDesignRemoveCmd domainDesignRemoveCmd = DomainDesignRemoveDTOConvert.INSTANCE.dto2Do(domainDesignRemoveDto);
        domainDesignRemoveCmdHandler.handle(domainDesignRemoveCmd);
        return ResultDTO.success(Boolean.TRUE);
    }

    @Override
    public ResultDTO<DomainDesignDTO> domainDesignDetailQuery(DomainDesignDetailQuery query) {
        return domainDesignDetailQueryExe.execute(query);
    }

    @Override
    public ResultDTO<List<DomainDesignDTO>> domainDesignListQuery(DomainDesignListQuery query) {
        return domainDesignListQueryExe.execute(query);
    }

    @Override
    public ResultDTO<List<DomainDesignDTO>> domainDesignPageQuery(DomainDesignPageQuery pageQuery) {
        return domainDesignPageQueryExe.execute(pageQuery);
    }

}