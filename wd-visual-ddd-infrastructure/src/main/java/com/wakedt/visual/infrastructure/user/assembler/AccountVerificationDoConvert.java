package com.wakedt.visual.infrastructure.user.assembler;

import com.wakedt.visual.domain.user.verifycode.AccountVerification;
import com.wakedt.visual.infrastructure.BaseConvert;
import com.wakedt.visual.infrastructure.user.repository.model.AccountVerificationDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * author Wangchensheng@wakedata.com
 * date 2023年02月13日 11:53:52
 */
@Mapper
public interface AccountVerificationDoConvert extends BaseConvert<AccountVerification, AccountVerificationDO> {

    AccountVerificationDoConvert INSTANCE = Mappers.getMapper(AccountVerificationDoConvert.class);

}
