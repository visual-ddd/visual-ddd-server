package com.wakedt.visual.adapter.universallanguage.web.conver;

import com.wakedata.common.mybatis.convert.BaseConvert;
import com.wakedt.visual.client.universallanguage.dto.UniversalLanguageDTO;
import com.wakedt.visual.client.universallanguage.dto.UniversalLanguageExcelDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UniversalLanguageDto2ExcelConvert extends
    BaseConvert<UniversalLanguageDTO, UniversalLanguageExcelDTO> {

    UniversalLanguageDto2ExcelConvert INSTANCE = Mappers.getMapper(UniversalLanguageDto2ExcelConvert.class);

}
