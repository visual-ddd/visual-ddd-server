
package com.wakedt.visual.client.prompt;

import com.wakedata.common.core.dto.PageResultDTO;
import com.wakedata.common.core.dto.ResultDTO;
import com.wakedt.visual.client.prompt.dto.PromptDTO;
import com.wakedt.visual.client.prompt.query.*;

import java.util.List;

/**
 * ChatGpt提示词的领域-RPC能力接口
 */
public interface PromptRpcService {

    /** 新增提示词 */
    ResultDTO<Long> create(PromptCreateDTO dto);

    /** 编辑提示词 */
    ResultDTO<Boolean> modify(PromptModifyDTO dto);

    /** 删除提示词 */
    ResultDTO<Boolean> remove(PromptRemoveDTO dto);

    /** 查询提示词详情 */
    ResultDTO<PromptDTO> promptQuery(PromptQuery query);

    /** 分页查询提示词 */
    PageResultDTO<List<PromptDTO>> promptPageQuery(PromptPageQuery pageQuery);

}