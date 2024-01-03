package com.wakedt.visual.app.user.assembler;

import com.wakedt.visual.client.user.dto.AccountEmailSendDTO;
import com.wakedt.visual.domain.user.account.email.send.AccountEmailSendCmd;
import com.wakedt.visual.infrastructure.BaseConvert;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * AccountEmailSendCmd和DTO转换器
 *
 * @author zhuxueliang
 */
@Mapper
public interface AccountEmailSendDTOConvert extends
    BaseConvert<AccountEmailSendDTO, AccountEmailSendCmd> {

        AccountEmailSendDTOConvert INSTANCE = Mappers.getMapper(AccountEmailSendDTOConvert.class);
}