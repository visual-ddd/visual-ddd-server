package com.wakedt.visual.app.whitelist.assembler;

import com.wakedt.visual.client.whitelist.query.WhiteListCreateDTO;
import com.wakedt.visual.domain.whitelist.whitelist.create.WhiteListCreateCmd;
import com.wakedt.visual.infrastructure.BaseConvert;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {
        JsonConverter.class,
})
public interface WhiteListCreateDTO2WhiteListCreateCmdConvert extends BaseConvert<WhiteListCreateDTO, WhiteListCreateCmd> {

    WhiteListCreateDTO2WhiteListCreateCmdConvert INSTANCE = Mappers.getMapper(WhiteListCreateDTO2WhiteListCreateCmdConvert.class);
}