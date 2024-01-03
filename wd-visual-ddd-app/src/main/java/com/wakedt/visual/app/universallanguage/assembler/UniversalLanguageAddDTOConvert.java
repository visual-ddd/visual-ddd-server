package com.wakedt.visual.app.universallanguage.assembler;

import com.wakedt.visual.client.universallanguage.dto.UniversalLanguageAddDTO;
import com.wakedt.visual.domain.universallanguage.universallanguage.LanguageTypeConverter;
import com.wakedt.visual.domain.universallanguage.universallanguage.create.UniversalLanguageAddCmd;
import com.wakedt.visual.infrastructure.BaseConvert;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * UniversalLanguageAddCmd和DTO转换器
 *
 * @author zhuxueliang
 */
@Mapper(uses = {
        LanguageTypeConverter.class,
})
public interface UniversalLanguageAddDTOConvert extends
        BaseConvert<UniversalLanguageAddDTO, UniversalLanguageAddCmd> {

    UniversalLanguageAddDTOConvert INSTANCE = Mappers.getMapper(UniversalLanguageAddDTOConvert.class);
}