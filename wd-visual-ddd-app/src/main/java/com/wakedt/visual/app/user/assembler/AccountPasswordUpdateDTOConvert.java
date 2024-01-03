package com.wakedt.visual.app.user.assembler;

import com.wakedt.visual.client.user.dto.AccountPasswordUpdateDTO;
import com.wakedt.visual.domain.user.account.passwordupdate.AccountPasswordUpdateCmd;
import com.wakedt.visual.infrastructure.BaseConvert;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * AccountPasswordUpdateCmd和DTO转换器
 *
 * @author zhuxueliang
 */
@Mapper
public interface AccountPasswordUpdateDTOConvert extends
    BaseConvert<AccountPasswordUpdateDTO, AccountPasswordUpdateCmd> {

        AccountPasswordUpdateDTOConvert INSTANCE = Mappers.getMapper(AccountPasswordUpdateDTOConvert.class);
}