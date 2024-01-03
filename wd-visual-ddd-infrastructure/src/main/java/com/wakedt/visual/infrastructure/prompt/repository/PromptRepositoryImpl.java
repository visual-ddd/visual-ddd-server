package com.wakedt.visual.infrastructure.prompt.repository;

import com.wakedata.common.core.exception.BizException;
import com.wakedt.visual.domain.prompt.prompt.Prompt;
import com.wakedt.visual.domain.prompt.prompt.PromptRepository;
import com.wakedt.visual.infrastructure.prompt.assembler.Prompt2PromptDOConvert;
import com.wakedt.visual.infrastructure.prompt.repository.mapper.PromptMapper;
import com.wakedt.visual.infrastructure.prompt.repository.model.PromptDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.Resource;

/**
 * prompt-聚合仓储实现类
 */
@Slf4j
@Component
public class PromptRepositoryImpl implements PromptRepository {

    @Resource
    private PromptMapper promptMapper;

    @Override
    public Prompt save(Prompt prompt) {
        PromptDO promptDO = Prompt2PromptDOConvert.INSTANCE.dto2Do(prompt);
        int insert = promptMapper.insert(promptDO);
        Assert.isTrue(insert == 1, "插入数据库异常，请联系管理员");
        return Prompt2PromptDOConvert.INSTANCE.do2Dto(promptDO);
    }

    @Override
    public Prompt update(Prompt prompt) {
        PromptDO promptDO = Prompt2PromptDOConvert.INSTANCE.dto2Do(prompt);
        int update = promptMapper.updateById(promptDO);
        Assert.isTrue(update == 1, "更新数据库异常，请联系管理员");
        return Prompt2PromptDOConvert.INSTANCE.do2Dto(promptDO);
    }

    @Override
    public void remove(Prompt prompt) {
        PromptDO promptDO = Prompt2PromptDOConvert.INSTANCE.dto2Do(prompt);
        promptMapper.deleteById(promptDO.getId());
    }

    @Override
    public Prompt find(Long id) {
        PromptDO result = promptMapper.selectById(id);
        if (result == null) throw new BizException("id不存在!");
        return Prompt2PromptDOConvert.INSTANCE.do2Dto(result);
    }
}
