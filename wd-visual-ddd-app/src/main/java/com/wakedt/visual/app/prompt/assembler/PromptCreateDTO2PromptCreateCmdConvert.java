package com.wakedt.visual.app.prompt.assembler;

import com.wakedt.visual.client.prompt.query.PromptCreateDTO;
import com.wakedt.visual.domain.prompt.prompt.create.PromptCreateCmd;
import com.wakedt.visual.infrastructure.BaseConvert;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {
        JsonConverter.class,
})
public interface PromptCreateDTO2PromptCreateCmdConvert extends BaseConvert<PromptCreateDTO, PromptCreateCmd> {

    PromptCreateDTO2PromptCreateCmdConvert INSTANCE = Mappers.getMapper(PromptCreateDTO2PromptCreateCmdConvert.class);
}