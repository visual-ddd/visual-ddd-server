package com.wakedt.visual.infrastructure.user.assembler;

import com.wakedt.visual.domain.user.account.Account;
import com.wakedt.visual.domain.user.account.AccountRoleConverter;
import com.wakedt.visual.infrastructure.BaseConvert;
import com.wakedt.visual.infrastructure.user.repository.model.AccountDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Account和DO转换器
 *
 * @author zhuxueliang
 */
@Mapper(
        uses = AccountRoleConverter.class
)
public interface AccountDoConvert extends
    BaseConvert<Account, AccountDO> {

    AccountDoConvert INSTANCE = Mappers.getMapper(AccountDoConvert.class);
}
