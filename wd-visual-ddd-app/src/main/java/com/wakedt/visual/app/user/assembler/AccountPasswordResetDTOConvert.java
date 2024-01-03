package com.wakedt.visual.app.user.assembler;

import com.wakedt.visual.client.user.dto.AccountPasswordResetDTO;
import com.wakedt.visual.domain.user.account.password.reset.AccountPasswordResetCmd;
import com.wakedt.visual.infrastructure.BaseConvert;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * AccountPasswordResetCmd和DTO转换器
 *
 * @author zhuxueliang
 */
@Mapper
public interface AccountPasswordResetDTOConvert extends
    BaseConvert<AccountPasswordResetDTO, AccountPasswordResetCmd> {

        AccountPasswordResetDTOConvert INSTANCE = Mappers.getMapper(AccountPasswordResetDTOConvert.class);
}