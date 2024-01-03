package com.wakedt.visual.app.user.assembler;

import com.wakedt.visual.client.user.dto.AccountLoginDTO;
import com.wakedt.visual.domain.user.account.login.AccountLoginCmd;
import com.wakedt.visual.infrastructure.BaseConvert;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * AccountLoginCmd和DTO转换器
 *
 * @author zhuxueliang
 */
@Mapper
public interface AccountLoginDTOConvert extends
    BaseConvert<AccountLoginDTO, AccountLoginCmd> {

        AccountLoginDTOConvert INSTANCE = Mappers.getMapper(AccountLoginDTOConvert.class);
}