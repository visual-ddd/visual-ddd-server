package com.wakedt.visual.app.universallanguage.assembler;

import com.wakedt.visual.client.universallanguage.dto.UniversalLanguageDeleteDTO;
import com.wakedt.visual.domain.universallanguage.universallanguage.LanguageTypeConverter;
import com.wakedt.visual.domain.universallanguage.universallanguage.delete.UniversalLanguageDeleteCmd;
import com.wakedt.visual.infrastructure.BaseConvert;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * UniversalLanguageDeleteCmd和DTO转换器
 *
 * @author zhuxueliang
 */
@Mapper(uses = {
        LanguageTypeConverter.class,
})
public interface UniversalLanguageDeleteDTOConvert extends
        BaseConvert<UniversalLanguageDeleteDTO, UniversalLanguageDeleteCmd> {

    UniversalLanguageDeleteDTOConvert INSTANCE = Mappers.getMapper(UniversalLanguageDeleteDTOConvert.class);
}