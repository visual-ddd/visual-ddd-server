package com.wakedt.visual.app.domaindesign;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.wakedata.common.core.dto.ResultDTO;
import com.wakedt.visual.app.domaindesign.assembler.*;
import com.wakedt.visual.app.domaindesign.view.DomainDesignDetailQueryExe;
import com.wakedt.visual.app.domaindesign.view.DomainDesignVersionDetailQueryExe;
import com.wakedt.visual.app.domaindesign.view.DomainDesignVersionPageQueryExe;
import com.wakedt.visual.app.domaindesign.view.DomainDesignVersionSimpleQueryExe;
import com.wakedt.visual.client.domaindesign.DomainDesignVersionRpcService;
import com.wakedt.visual.client.domaindesign.dto.*;
import com.wakedt.visual.client.domaindesign.query.DomainDesignVersionDetailQuery;
import com.wakedt.visual.client.domaindesign.query.DomainDesignVersionPageQuery;
import com.wakedt.visual.domain.domaindesign.domaindesignversion.create.DomainDesignVersionCreateCmd;
import com.wakedt.visual.domain.domaindesign.domaindesignversion.create.DomainDesignVersionCreateCmdHandler;
import com.wakedt.visual.domain.domaindesign.domaindesignversion.dslupdate.DomainDesignDslUpdateCmd;
import com.wakedt.visual.domain.domaindesign.domaindesignversion.dslupdate.DomainDesignDslUpdateCmdHandler;
import com.wakedt.visual.domain.domaindesign.domaindesignversion.remove.DomainDesignVersionRemoveCmd;
import com.wakedt.visual.domain.domaindesign.domaindesignversion.remove.DomainDesignVersionRemoveCmdHandler;
import com.wakedt.visual.domain.domaindesign.domaindesignversion.update.DomainDesignVersionUpdateCmd;
import com.wakedt.visual.domain.domaindesign.domaindesignversion.update.DomainDesignVersionUpdateCmdHandler;
import com.wakedt.visual.domain.domaindesign.domaindesignversion.versionpblish.DomainDesignVersionPublishCmd;
import com.wakedt.visual.domain.domaindesign.domaindesignversion.versionpblish.DomainDesignVersionPublishCmdHandler;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * 业务域版本-聚合根-RPC能力接口实现
 *
 * @author zhuxueliang
 */
@Service
public class DomainDesignVersionRpcServiceImpl implements DomainDesignVersionRpcService {

    @Resource
    private DomainDesignVersionCreateCmdHandler domainDesignVersionCreateCmdHandler;
    @Resource
    private DomainDesignVersionUpdateCmdHandler domainDesignVersionUpdateCmdHandler;
    @Resource
    private DomainDesignVersionRemoveCmdHandler domainDesignVersionRemoveCmdHandler;
    @Resource
    private DomainDesignVersionPublishCmdHandler domainDesignVersionPublishCmdHandler;
    @Resource
    private DomainDesignDslUpdateCmdHandler domainDesignDslUpdateCmdHandler;
    @Resource
    private DomainDesignVersionDetailQueryExe domainDesignVersionDetailQueryExe;
    @Resource
    private DomainDesignVersionPageQueryExe domainDesignVersionPageQueryExe;
    @Resource
    private DomainDesignVersionSimpleQueryExe domainDesignVersionSimpleQueryExe;


    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResultDTO<Long> domainDesignVersionCreate(DomainDesignVersionCreateDTO dto) {
        DomainDesignVersionDTO startVersionDTO = getStartVersionById(dto.getStartVersionId());

        // 1.根据起始版本，新增业务域版本
        String startVersion = Optional.ofNullable(startVersionDTO.getCurrentVersion()).orElse(StringUtils.EMPTY);
        DomainDesignVersionCreateCmd createCmd = DomainDesignVersionCreateDTOConvert.INSTANCE.dto2Do(dto);
        createCmd.setStartVersion(startVersion);
        Long newVersionId = domainDesignVersionCreateCmdHandler.handle(createCmd);

        // 2.拷贝起始版本的DSL
        domainDesignDslUpdateCmdHandler.handle(
                new DomainDesignDslUpdateCmd(newVersionId, startVersionDTO.getDomainDesignDsl(), startVersionDTO.getGraphDsl()));
        return ResultDTO.success(newVersionId);
    }

    private DomainDesignVersionDTO getStartVersionById(Long id) {
        DomainDesignVersionDetailQuery detailQuery = new DomainDesignVersionDetailQuery();
        detailQuery.setId(id);
        return domainDesignVersionDetailQueryExe.execute(detailQuery).getData();
    }

    @Override
    public ResultDTO<Boolean> domainDesignVersionUpdate(DomainDesignVersionUpdateDTO domainDesignVersionUpdateDto) {
        DomainDesignVersionUpdateCmd domainDesignVersionUpdateCmd = DomainDesignVersionUpdateDTOConvert.INSTANCE.dto2Do(domainDesignVersionUpdateDto);
        domainDesignVersionUpdateCmdHandler.handle(domainDesignVersionUpdateCmd);
        return ResultDTO.success(Boolean.TRUE);
    }

    @Override
    public ResultDTO<Boolean> domainDesignVersionRemove(DomainDesignVersionRemoveDTO domainDesignVersionRemoveDto) {
        DomainDesignVersionRemoveCmd domainDesignVersionRemoveCmd = DomainDesignVersionRemoveDTOConvert.INSTANCE.dto2Do(domainDesignVersionRemoveDto);
        domainDesignVersionRemoveCmdHandler.handle(domainDesignVersionRemoveCmd);
        return ResultDTO.success(Boolean.TRUE);
    }

    @Override
    public ResultDTO<Boolean> domainDesignVersionPublish(DomainDesignVersionPublishDTO domainDesignVersionPublishDto) {
        DomainDesignVersionPublishCmd domainDesignVersionPublishCmd = DomainDesignVersionPublishDTOConvert.INSTANCE.dto2Do(domainDesignVersionPublishDto);
        domainDesignVersionPublishCmdHandler.handle(domainDesignVersionPublishCmd);
        return ResultDTO.success(Boolean.TRUE);
    }

    @Override
    public ResultDTO<Boolean> domainDesignDslUpdate(DomainDesignDSLUpdateDTO dto) {
        domainDesignDslUpdateCmdHandler.handle(DomainDesignDSLUpdateDTOConvert.INSTANCE.dto2Do(dto));
        return ResultDTO.success(Boolean.TRUE);
    }

    @Override
    public ResultDTO<DomainDesignVersionDTO> domainDesignVersionDetailQuery(DomainDesignVersionDetailQuery query) {
        return domainDesignVersionDetailQueryExe.execute(query);
    }

    @Override
    public ResultDTO<DomainDesignVersionDTO> domainDesignVersionSimpleQuery(DomainDesignVersionDetailQuery query) {
        return domainDesignVersionSimpleQueryExe.execute(query);
    }


    @Override
    public ResultDTO<List<DomainDesignVersionDTO>> domainDesignVersionPageQuery(DomainDesignVersionPageQuery pageQuery) {
        return domainDesignVersionPageQueryExe.execute(pageQuery);
    }

}