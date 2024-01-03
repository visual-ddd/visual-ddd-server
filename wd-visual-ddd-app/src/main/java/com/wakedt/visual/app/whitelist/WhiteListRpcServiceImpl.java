
package com.wakedt.visual.app.whitelist;

import com.wakedata.common.core.dto.PageResultDTO;
import com.wakedata.common.core.dto.ResultDTO;
import com.wakedt.visual.app.whitelist.assembler.WhiteListCreateDTO2WhiteListCreateCmdConvert;
import com.wakedt.visual.app.whitelist.assembler.WhiteListModifyDTO2WhiteListModifyCmdConvert;
import com.wakedt.visual.app.whitelist.assembler.WhiteListRemoveDTO2WhiteListRemoveCmdConvert;
import com.wakedt.visual.app.whitelist.view.WhiteListPageQueryExe;
import com.wakedt.visual.app.whitelist.view.WhiteListQueryExe;
import com.wakedt.visual.client.whitelist.WhiteListRpcService;
import com.wakedt.visual.client.whitelist.dto.WhiteListDTO;
import com.wakedt.visual.client.whitelist.query.*;
import com.wakedt.visual.domain.whitelist.whitelist.create.WhiteListCreateCmdHandler;
import com.wakedt.visual.domain.whitelist.whitelist.modify.WhiteListModifyCmdHandler;
import com.wakedt.visual.domain.whitelist.whitelist.remove.WhiteListRemoveCmdHandler;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 描述账号白名单领域-RPC能力接口实现
 */
@Service
public class WhiteListRpcServiceImpl implements WhiteListRpcService {

    @Resource
    private WhiteListCreateCmdHandler whiteListCreateCmdHandler;
    @Resource
    private WhiteListModifyCmdHandler whiteListModifyCmdHandler;
    @Resource
    private WhiteListRemoveCmdHandler whiteListRemoveCmdHandler;
    @Resource
    private WhiteListQueryExe whiteListQueryExe;
    @Resource
    private WhiteListPageQueryExe whiteListPageQueryExe;


    @Override
    public ResultDTO<Long> create(WhiteListCreateDTO dto) {
        Long id = whiteListCreateCmdHandler.handle(WhiteListCreateDTO2WhiteListCreateCmdConvert.INSTANCE.dto2Do(dto));
        return ResultDTO.success(id);
    }

    @Override
    public ResultDTO<Boolean> modify(WhiteListModifyDTO dto) {
        whiteListModifyCmdHandler.handle(WhiteListModifyDTO2WhiteListModifyCmdConvert.INSTANCE.dto2Do(dto));
        return ResultDTO.success(Boolean.TRUE);
    }

    @Override
    public ResultDTO<Boolean> remove(WhiteListRemoveDTO dto) {
        whiteListRemoveCmdHandler.handle(WhiteListRemoveDTO2WhiteListRemoveCmdConvert.INSTANCE.dto2Do(dto));
        return ResultDTO.success(Boolean.TRUE);
    }

    @Override
    public ResultDTO<WhiteListDTO> whiteListQuery(WhiteListQuery query) {
        return whiteListQueryExe.execute(query);
    }

    @Override
    public PageResultDTO<List<WhiteListDTO>> whiteListPageQuery(WhiteListPageQuery pageQuery) {
        return whiteListPageQueryExe.execute(pageQuery);
    }
}