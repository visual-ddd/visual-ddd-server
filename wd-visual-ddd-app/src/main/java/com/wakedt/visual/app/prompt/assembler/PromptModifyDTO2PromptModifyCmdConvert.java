package com.wakedt.visual.app.prompt.assembler;

import com.wakedt.visual.client.prompt.query.PromptModifyDTO;
import com.wakedt.visual.domain.prompt.prompt.modify.PromptModifyCmd;
import com.wakedt.visual.infrastructure.BaseConvert;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {
        JsonConverter.class,
})
public interface PromptModifyDTO2PromptModifyCmdConvert extends BaseConvert<PromptModifyDTO, PromptModifyCmd> {

    PromptModifyDTO2PromptModifyCmdConvert INSTANCE = Mappers.getMapper(PromptModifyDTO2PromptModifyCmdConvert.class);
}