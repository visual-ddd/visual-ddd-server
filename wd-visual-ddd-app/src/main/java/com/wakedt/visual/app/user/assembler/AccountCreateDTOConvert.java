package com.wakedt.visual.app.user.assembler;

import com.wakedt.visual.client.user.dto.AccountCreateDTO;
import com.wakedt.visual.domain.user.account.create.AccountCreateCmd;
import com.wakedt.visual.infrastructure.BaseConvert;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * AccountCreateCmd和DTO转换器
 *
 * @author zhuxueliang
 */
@Mapper
public interface AccountCreateDTOConvert extends
    BaseConvert<AccountCreateDTO, AccountCreateCmd> {

        AccountCreateDTOConvert INSTANCE = Mappers.getMapper(AccountCreateDTOConvert.class);
}