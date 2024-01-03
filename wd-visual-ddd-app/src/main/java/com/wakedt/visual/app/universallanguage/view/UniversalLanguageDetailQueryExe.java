package com.wakedt.visual.app.universallanguage.view;

import com.wakedata.common.core.dto.ResultDTO;
import com.wakedt.visual.app.universallanguage.assembler.UniversalLanguageDTO2DOConvert;
import com.wakedt.visual.client.universallanguage.dto.UniversalLanguageDTO;
import com.wakedt.visual.client.universallanguage.query.UniversalLanguageDetailQuery;
import com.wakedt.visual.domain.common.constant.MsgCodeEnum;
import com.wakedt.visual.domain.common.constant.VisualException;
import com.wakedt.visual.infrastructure.universallanguage.repository.mapper.UniversalLanguageMapper;
import com.wakedt.visual.infrastructure.universallanguage.repository.model.UniversalLanguageDO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * 查询统一语言详情-查询器
 *
 * @author zhuxueliang
 */
@Component
public class UniversalLanguageDetailQueryExe {

    @Resource
    private UniversalLanguageMapper universallanguageMapper;

    public ResultDTO<UniversalLanguageDTO> execute(UniversalLanguageDetailQuery query) {
        UniversalLanguageDO universallanguageDO = Optional.ofNullable(universallanguageMapper.universalLanguageDetailQuery(query))
                .orElseThrow(() -> new VisualException(MsgCodeEnum.NO_FIND_RESOURCE));
        UniversalLanguageDTO universalLanguageDTO = UniversalLanguageDTO2DOConvert.INSTANCE.do2Dto(universallanguageDO);
        return ResultDTO.success(universalLanguageDTO);
    }
}
