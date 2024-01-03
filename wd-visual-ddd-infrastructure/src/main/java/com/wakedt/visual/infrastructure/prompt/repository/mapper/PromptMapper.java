package com.wakedt.visual.infrastructure.prompt.repository.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wakedt.visual.client.prompt.query.PromptPageQuery;
import com.wakedt.visual.client.prompt.query.PromptQuery;
import com.wakedt.visual.infrastructure.prompt.repository.model.PromptDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * PromptMapper接口
 */
@Mapper
public interface PromptMapper extends BaseMapper<PromptDO> {

    /** 查询提示词详情 */
    PromptDO promptQuery(PromptQuery query);

    /** 分页查询提示词 */
    List<PromptDO> promptPageQuery(PromptPageQuery pageQuery);

}