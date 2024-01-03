package com.wakedt.visual.app.user.assembler;

import com.wakedt.visual.client.user.dto.AccountDeleteDTO;
import com.wakedt.visual.domain.user.account.delete.AccountDeleteCmd;
import com.wakedt.visual.infrastructure.BaseConvert;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * AccountDeleteCmd和DTO转换器
 *
 * @author zhuxueliang
 */
@Mapper
public interface AccountDeleteDTOConvert extends
    BaseConvert<AccountDeleteDTO, AccountDeleteCmd> {

        AccountDeleteDTOConvert INSTANCE = Mappers.getMapper(AccountDeleteDTOConvert.class);
}