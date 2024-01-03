package com.wakedt.visual.infrastructure.whitelist.assembler;

import com.wakedt.visual.domain.whitelist.whitelist.WhiteList;
import com.wakedt.visual.infrastructure.BaseConvert;
import com.wakedt.visual.infrastructure.whitelist.repository.model.WhiteListDO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {
})
public interface WhiteList2WhiteListDOConvert extends BaseConvert<WhiteList, WhiteListDO> {

    WhiteList2WhiteListDOConvert INSTANCE = Mappers.getMapper(WhiteList2WhiteListDOConvert.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "accountNo", target = "accountNo")
    @Mapping(source = "description", target = "description")
    @Override
    WhiteListDO dto2Do(WhiteList dto);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "accountNo", target = "accountNo")
    @Mapping(source = "description", target = "description")
    @Override
    WhiteList do2Dto(WhiteListDO d);
}
