package com.wakedt.visual.app.user.view;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.wakedata.common.core.dto.ResultDTO;
import com.wakedt.visual.app.user.assembler.AccountVerificationDTOConvert;
import com.wakedt.visual.client.user.dto.AccountVerificationDTO;
import com.wakedt.visual.infrastructure.user.repository.mapper.AccountVerificationMapper;
import com.wakedt.visual.infrastructure.user.repository.model.AccountVerificationDO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * author Wangchensheng@wakedata.com
 * date 2023年02月13日 12:10:58
 */
@Component
public class AccountVerificationDetailQueryExe {

    @Resource
    private AccountVerificationMapper accountVerificationMapper;

    public ResultDTO<AccountVerificationDTO> execute(String accountNo) {
        AccountVerificationDO verificationDO = accountVerificationMapper.selectOne(
                        new LambdaQueryWrapper<AccountVerificationDO>().eq(AccountVerificationDO::getAccountNo, accountNo));
        AccountVerificationDTO accountVerificationDTO = AccountVerificationDTOConvert.INSTANCE.do2Dto(verificationDO);
        return ResultDTO.success(accountVerificationDTO);
    }

}
