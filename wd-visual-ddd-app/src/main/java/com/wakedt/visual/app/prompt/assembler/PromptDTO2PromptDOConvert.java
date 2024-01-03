package com.wakedt.visual.app.prompt.assembler;

import com.wakedt.visual.client.prompt.dto.PromptDTO;
import com.wakedt.visual.infrastructure.BaseConvert;
import com.wakedt.visual.infrastructure.prompt.repository.model.PromptDO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {
        JsonConverter.class,
})
public interface PromptDTO2PromptDOConvert extends BaseConvert<PromptDTO, PromptDO> {

    PromptDTO2PromptDOConvert INSTANCE = Mappers.getMapper(PromptDTO2PromptDOConvert.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "introduction", target = "introduction")
    @Mapping(source = "system", target = "systemPrompt")
    @Mapping(source = "author", target = "author")
    @Mapping(source = "date", target = "date")
    @Mapping(source = "temperature", target = "temperature")
    @Mapping(source = "maxContextLength", target = "maxContextLength")
    @Override
    PromptDO dto2Do(PromptDTO dto);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "introduction", target = "introduction")
    @Mapping(source = "systemPrompt", target = "system")
    @Mapping(source = "author", target = "author")
    @Mapping(source = "date", target = "date")
    @Mapping(source = "temperature", target = "temperature")
    @Mapping(source = "maxContextLength", target = "maxContextLength")
    @Override
    PromptDTO do2Dto(PromptDO d);
}