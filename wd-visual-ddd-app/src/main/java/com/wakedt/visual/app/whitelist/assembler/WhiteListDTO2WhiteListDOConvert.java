package com.wakedt.visual.app.whitelist.assembler;

import com.wakedt.visual.client.whitelist.dto.WhiteListDTO;
import com.wakedt.visual.infrastructure.BaseConvert;
import com.wakedt.visual.infrastructure.whitelist.repository.model.WhiteListDO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {
        JsonConverter.class,
})
public interface WhiteListDTO2WhiteListDOConvert extends BaseConvert<WhiteListDTO, WhiteListDO> {

    WhiteListDTO2WhiteListDOConvert INSTANCE = Mappers.getMapper(WhiteListDTO2WhiteListDOConvert.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "accountNo", target = "accountNo")
    @Mapping(source = "description", target = "description")
    @Override
    WhiteListDO dto2Do(WhiteListDTO dto);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "accountNo", target = "accountNo")
    @Mapping(source = "description", target = "description")
    @Override
    WhiteListDTO do2Dto(WhiteListDO d);
}