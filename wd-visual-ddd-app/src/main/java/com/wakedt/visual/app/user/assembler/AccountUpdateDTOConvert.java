package com.wakedt.visual.app.user.assembler;

import com.wakedt.visual.client.user.dto.AccountUpdateDTO;
import com.wakedt.visual.domain.user.account.update.AccountUpdateCmd;
import com.wakedt.visual.infrastructure.BaseConvert;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * AccountUpdateCmd和DTO转换器
 *
 * @author zhuxueliang
 */
@Mapper
public interface AccountUpdateDTOConvert extends
    BaseConvert<AccountUpdateDTO, AccountUpdateCmd> {

        AccountUpdateDTOConvert INSTANCE = Mappers.getMapper(AccountUpdateDTOConvert.class);
}