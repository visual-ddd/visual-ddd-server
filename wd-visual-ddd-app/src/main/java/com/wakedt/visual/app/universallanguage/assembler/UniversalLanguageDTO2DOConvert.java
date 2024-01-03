package com.wakedt.visual.app.universallanguage.assembler;

import com.wakedt.visual.client.universallanguage.dto.UniversalLanguageDTO;
import com.wakedt.visual.infrastructure.BaseConvert;
import com.wakedt.visual.infrastructure.universallanguage.repository.model.UniversalLanguageDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * UniversalLanguageDTO和DO转换器
 *
 * @author zhuxueliang
 */
@Mapper(uses = {
        JsonConverter.class,
})
public interface UniversalLanguageDTO2DOConvert extends
        BaseConvert<UniversalLanguageDTO, UniversalLanguageDO> {

    UniversalLanguageDTO2DOConvert INSTANCE = Mappers.getMapper(UniversalLanguageDTO2DOConvert.class);
}