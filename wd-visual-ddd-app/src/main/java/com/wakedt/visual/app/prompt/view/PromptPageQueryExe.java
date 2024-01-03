package com.wakedt.visual.app.prompt.view;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wakedata.common.core.dto.PageResultDTO;
import com.wakedt.visual.app.prompt.assembler.PromptDTO2PromptDOConvert;
import com.wakedt.visual.client.prompt.dto.PromptDTO;
import com.wakedt.visual.client.prompt.query.PromptPageQuery;
import com.wakedt.visual.infrastructure.prompt.repository.mapper.PromptMapper;
import com.wakedt.visual.infrastructure.prompt.repository.model.PromptDO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 分页查询提示词-查询器
 */
@Component
public class PromptPageQueryExe {

    @Resource
    private PromptMapper mapper;

    public PageResultDTO<List<PromptDTO>> execute(PromptPageQuery pageQuery) {
        PageHelper.startPage(pageQuery.getPageNo(),pageQuery.getPageSize());

        PageInfo<PromptDO> pageInfo = new PageInfo<>(mapper.promptPageQuery(pageQuery));
        PageResultDTO<List<PromptDTO>> pageResultDTO = new PageResultDTO<>();
        pageResultDTO.setData(PromptDTO2PromptDOConvert.INSTANCE.doList2DtoList(pageInfo.getList()));
        pageResultDTO.setPageNo(pageInfo.getPageNum());
        pageResultDTO.setPageSize(pageInfo.getSize());
        pageResultDTO.setTotalCount(pageInfo.getTotal());
        return pageResultDTO;
    }
}
