package com.wakedt.visual.infrastructure.user.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.wakedt.visual.domain.user.verifycode.AccountVerification;
import com.wakedt.visual.domain.user.verifycode.AccountVerificationRepository;
import com.wakedt.visual.infrastructure.user.assembler.AccountVerificationDoConvert;
import com.wakedt.visual.infrastructure.user.repository.mapper.AccountVerificationMapper;
import com.wakedt.visual.infrastructure.user.repository.model.AccountVerificationDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.Resource;

/**
 * author Wangchensheng@wakedata.com
 * date 2023年02月13日 11:51:41
 */
@Slf4j
@Component
public class AccountVerificationRepositoryImpl implements AccountVerificationRepository {

    @Resource
    private AccountVerificationMapper accountVerificationMapper;

    @Override
    public AccountVerification save(AccountVerification verification) {
        AccountVerificationDO verificationDO = AccountVerificationDoConvert.INSTANCE.dto2Do(verification);
        int insert = accountVerificationMapper.insert(verificationDO);
        Assert.isTrue(insert == 1, "插入数据库异常，请联系管理员");
        return AccountVerificationDoConvert.INSTANCE.do2Dto(verificationDO);
    }

    @Override
    public AccountVerification update(AccountVerification verification) {
        AccountVerificationDO verificationDO = AccountVerificationDoConvert.INSTANCE.dto2Do(verification);
        int update = accountVerificationMapper.updateById(verificationDO);
        Assert.isTrue(update == 1, "更新数据库异常，请联系管理员");
        return AccountVerificationDoConvert.INSTANCE.do2Dto(verificationDO);
    }

    @Override
    public AccountVerification find(Long id) {
        AccountVerificationDO accountVerificationDO = accountVerificationMapper.selectById(id);
        return AccountVerificationDoConvert.INSTANCE.do2Dto(accountVerificationDO);
    }

    @Override
    public AccountVerification findByAccountNo(String accountNo) {
        AccountVerificationDO accountVerificationDO = accountVerificationMapper.selectOne(
                new LambdaQueryWrapper<AccountVerificationDO>().eq(AccountVerificationDO::getAccountNo, accountNo));
        return AccountVerificationDoConvert.INSTANCE.do2Dto(accountVerificationDO);
    }

}
