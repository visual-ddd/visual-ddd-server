package com.wakedt.visual.app.whitelist.assembler;

import com.wakedt.visual.client.whitelist.query.WhiteListModifyDTO;
import com.wakedt.visual.domain.whitelist.whitelist.modify.WhiteListModifyCmd;
import com.wakedt.visual.infrastructure.BaseConvert;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {
        JsonConverter.class,
})
public interface WhiteListModifyDTO2WhiteListModifyCmdConvert extends BaseConvert<WhiteListModifyDTO, WhiteListModifyCmd> {

    WhiteListModifyDTO2WhiteListModifyCmdConvert INSTANCE = Mappers.getMapper(WhiteListModifyDTO2WhiteListModifyCmdConvert.class);
}