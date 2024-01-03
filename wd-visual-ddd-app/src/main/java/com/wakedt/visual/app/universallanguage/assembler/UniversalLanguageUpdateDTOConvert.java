package com.wakedt.visual.app.universallanguage.assembler;

import com.wakedt.visual.client.universallanguage.dto.UniversalLanguageUpdateDTO;
import com.wakedt.visual.domain.universallanguage.universallanguage.LanguageTypeConverter;
import com.wakedt.visual.domain.universallanguage.universallanguage.update.UniversalLanguageUpdateCmd;
import com.wakedt.visual.infrastructure.BaseConvert;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * UniversalLanguageUpdateCmd和DTO转换器
 *
 * @author zhuxueliang
 */
@Mapper(uses = {
        LanguageTypeConverter.class,
})
public interface UniversalLanguageUpdateDTOConvert extends
        BaseConvert<UniversalLanguageUpdateDTO, UniversalLanguageUpdateCmd> {

    UniversalLanguageUpdateDTOConvert INSTANCE = Mappers.getMapper(UniversalLanguageUpdateDTOConvert.class);
}