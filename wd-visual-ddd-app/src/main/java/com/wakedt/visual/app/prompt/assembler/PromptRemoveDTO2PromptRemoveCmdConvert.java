package com.wakedt.visual.app.prompt.assembler;

import com.wakedt.visual.client.prompt.query.PromptRemoveDTO;
import com.wakedt.visual.domain.prompt.prompt.remove.PromptRemoveCmd;
import com.wakedt.visual.infrastructure.BaseConvert;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {
        JsonConverter.class,
})
public interface PromptRemoveDTO2PromptRemoveCmdConvert extends BaseConvert<PromptRemoveDTO, PromptRemoveCmd> {

    PromptRemoveDTO2PromptRemoveCmdConvert INSTANCE = Mappers.getMapper(PromptRemoveDTO2PromptRemoveCmdConvert.class);
}