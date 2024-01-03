package com.wakedt.visual.app.user.assembler;

import com.wakedt.visual.client.user.dto.AccountVerificationCreateDTO;
import com.wakedt.visual.domain.user.verifycode.create.AccountVerificationCreateCmd;
import com.wakedt.visual.infrastructure.BaseConvert;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * AccountCreateCmd和DTO转换器
 */
@Mapper
public interface AccountVerificationCreateDTOConvert extends
    BaseConvert<AccountVerificationCreateDTO, AccountVerificationCreateCmd> {

        AccountVerificationCreateDTOConvert INSTANCE = Mappers.getMapper(AccountVerificationCreateDTOConvert.class);
}