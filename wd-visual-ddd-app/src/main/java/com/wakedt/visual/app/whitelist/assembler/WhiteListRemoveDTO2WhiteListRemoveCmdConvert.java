package com.wakedt.visual.app.whitelist.assembler;

import com.wakedt.visual.client.whitelist.query.WhiteListRemoveDTO;
import com.wakedt.visual.domain.whitelist.whitelist.remove.WhiteListRemoveCmd;
import com.wakedt.visual.infrastructure.BaseConvert;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {
        JsonConverter.class,
})
public interface WhiteListRemoveDTO2WhiteListRemoveCmdConvert extends BaseConvert<WhiteListRemoveDTO, WhiteListRemoveCmd> {

    WhiteListRemoveDTO2WhiteListRemoveCmdConvert INSTANCE = Mappers.getMapper(WhiteListRemoveDTO2WhiteListRemoveCmdConvert.class);
}