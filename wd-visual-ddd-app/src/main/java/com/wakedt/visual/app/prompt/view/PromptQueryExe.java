package com.wakedt.visual.app.prompt.view;

import com.wakedata.common.core.dto.ResultDTO;
import com.wakedt.visual.app.prompt.assembler.PromptDTO2PromptDOConvert;
import com.wakedt.visual.client.prompt.dto.PromptDTO;
import com.wakedt.visual.client.prompt.query.PromptQuery;
import com.wakedt.visual.infrastructure.prompt.repository.mapper.PromptMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 查询提示词详情-查询器
 */
@Component
public class PromptQueryExe {

    @Resource
    private PromptMapper mapper;

    public ResultDTO<PromptDTO> execute(PromptQuery query) {
        return ResultDTO.success(
                PromptDTO2PromptDOConvert.INSTANCE.do2Dto(mapper.promptQuery(query)));
    }
}
