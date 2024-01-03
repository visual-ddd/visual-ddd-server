package com.wakedt.visual.app.user.assembler;

import com.wakedt.visual.client.user.dto.AccountDTO;
import com.wakedt.visual.infrastructure.BaseConvert;
import com.wakedt.visual.infrastructure.user.repository.model.AccountDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * AccountDTO和DO转换器
 *
 * @author zhuxueliang
 */
@Mapper
public interface AccountDTO2DOConvert extends
    BaseConvert<AccountDTO, AccountDO> {

    AccountDTO2DOConvert INSTANCE = Mappers.getMapper(AccountDTO2DOConvert.class);
}