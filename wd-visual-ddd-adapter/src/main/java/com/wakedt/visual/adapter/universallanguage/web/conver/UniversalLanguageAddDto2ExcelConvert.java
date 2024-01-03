package com.wakedt.visual.adapter.universallanguage.web.conver;

import com.wakedata.common.mybatis.convert.BaseConvert;
import com.wakedt.visual.client.universallanguage.dto.UniversalLanguageAddDTO;
import com.wakedt.visual.client.universallanguage.dto.UniversalLanguageExcelDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UniversalLanguageAddDto2ExcelConvert extends
    BaseConvert<UniversalLanguageAddDTO, UniversalLanguageExcelDTO> {

    UniversalLanguageAddDto2ExcelConvert INSTANCE = Mappers.getMapper(UniversalLanguageAddDto2ExcelConvert.class);

}
