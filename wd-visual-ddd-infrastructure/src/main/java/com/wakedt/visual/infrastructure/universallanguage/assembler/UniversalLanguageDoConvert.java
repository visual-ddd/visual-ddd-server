package com.wakedt.visual.infrastructure.universallanguage.assembler;

import com.wakedt.visual.domain.universallanguage.universallanguage.LanguageTypeConverter;
import com.wakedt.visual.domain.universallanguage.universallanguage.UniversalLanguage;
import com.wakedt.visual.infrastructure.BaseConvert;
import com.wakedt.visual.infrastructure.universallanguage.repository.model.UniversalLanguageDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * UniversalLanguage和DO转换器
 *
 * @author zhuxueliang
 */
@Mapper(uses = {
        LanguageTypeConverter.class,
})
public interface UniversalLanguageDoConvert extends
        BaseConvert<UniversalLanguage, UniversalLanguageDO> {

    UniversalLanguageDoConvert INSTANCE = Mappers.getMapper(UniversalLanguageDoConvert.class);
}
