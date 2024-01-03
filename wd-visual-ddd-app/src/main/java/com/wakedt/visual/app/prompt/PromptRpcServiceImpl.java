
package com.wakedt.visual.app.prompt;

import com.wakedata.common.core.dto.PageResultDTO;
import com.wakedata.common.core.dto.ResultDTO;
import com.wakedt.visual.app.prompt.assembler.PromptCreateDTO2PromptCreateCmdConvert;
import com.wakedt.visual.app.prompt.assembler.PromptModifyDTO2PromptModifyCmdConvert;
import com.wakedt.visual.app.prompt.assembler.PromptRemoveDTO2PromptRemoveCmdConvert;
import com.wakedt.visual.app.prompt.view.PromptPageQueryExe;
import com.wakedt.visual.app.prompt.view.PromptQueryExe;
import com.wakedt.visual.client.prompt.PromptRpcService;
import com.wakedt.visual.client.prompt.dto.PromptDTO;
import com.wakedt.visual.client.prompt.query.*;
import com.wakedt.visual.domain.prompt.prompt.create.PromptCreateCmdHandler;
import com.wakedt.visual.domain.prompt.prompt.modify.PromptModifyCmdHandler;
import com.wakedt.visual.domain.prompt.prompt.remove.PromptRemoveCmdHandler;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * ChatGpt提示词的领域-RPC能力接口实现
 */
@Service
public class PromptRpcServiceImpl implements PromptRpcService {

    @Resource
    private PromptCreateCmdHandler promptCreateCmdHandler;
    @Resource
    private PromptModifyCmdHandler promptModifyCmdHandler;
    @Resource
    private PromptRemoveCmdHandler promptRemoveCmdHandler;
    @Resource
    private PromptQueryExe promptQueryExe;
    @Resource
    private PromptPageQueryExe promptPageQueryExe;


    @Override
    public ResultDTO<Long> create(PromptCreateDTO dto) {
        Long id = promptCreateCmdHandler.handle(PromptCreateDTO2PromptCreateCmdConvert.INSTANCE.dto2Do(dto));
        return ResultDTO.success(id);
    }

    @Override
    public ResultDTO<Boolean> modify(PromptModifyDTO dto) {
        promptModifyCmdHandler.handle(PromptModifyDTO2PromptModifyCmdConvert.INSTANCE.dto2Do(dto));
        return ResultDTO.success(Boolean.TRUE);
    }

    @Override
    public ResultDTO<Boolean> remove(PromptRemoveDTO dto) {
        promptRemoveCmdHandler.handle(PromptRemoveDTO2PromptRemoveCmdConvert.INSTANCE.dto2Do(dto));
        return ResultDTO.success(Boolean.TRUE);
    }

    @Override
    public ResultDTO<PromptDTO> promptQuery(PromptQuery query) {
        return promptQueryExe.execute(query);
    }

    @Override
    public PageResultDTO<List<PromptDTO>> promptPageQuery(PromptPageQuery pageQuery) {
        return promptPageQueryExe.execute(pageQuery);
    }
}