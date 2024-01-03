package com.wakedt.visual.app.user.assembler;

import com.wakedt.visual.client.user.dto.AccountVerificationDTO;
import com.wakedt.visual.infrastructure.BaseConvert;
import com.wakedt.visual.infrastructure.user.repository.model.AccountVerificationDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * AccountCreateCmd和DTO转换器
 */
@Mapper
public interface AccountVerificationDTOConvert extends
    BaseConvert<AccountVerificationDTO, AccountVerificationDO> {

        AccountVerificationDTOConvert INSTANCE = Mappers.getMapper(AccountVerificationDTOConvert.class);
}