package com.wakedt.visual.infrastructure.user.repository;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.wakedata.common.core.exception.BizException;
import com.wakedt.visual.domain.organization.organization.Organization;
import com.wakedt.visual.domain.user.account.Account;
import com.wakedt.visual.domain.user.account.AccountRepository;
import com.wakedt.visual.infrastructure.organization.assembler.OrganizationDoConvert;
import com.wakedt.visual.infrastructure.organization.repository.mapper.OrganizationMapper;
import com.wakedt.visual.infrastructure.organization.repository.model.OrganizationDO;
import com.wakedt.visual.infrastructure.user.assembler.AccountDoConvert;
import com.wakedt.visual.infrastructure.user.repository.mapper.AccountMapper;
import com.wakedt.visual.infrastructure.user.repository.model.AccountDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.List;

/**
 * 账号存储接口实现类
 *
 * @author zhuxueliang
 */
@Slf4j
@Component
public class AccountRepositoryImpl implements AccountRepository {

    @Resource
    private AccountMapper accountMapper;
    @Resource
    private OrganizationMapper organizationMapper;

    @Override
    public Account save(Account account) {
        AccountDO accountDO = AccountDoConvert.INSTANCE.dto2Do(account);
        int insert = accountMapper.insert(accountDO);
        Assert.isTrue(insert == 1, "插入数据库异常，请联系管理员");
        return AccountDoConvert.INSTANCE.do2Dto(accountDO);
    }

    @Override
    public Account update(Account account) {
        AccountDO accountDO = AccountDoConvert.INSTANCE.dto2Do(account);
        int update = accountMapper.updateById(accountDO);
        Assert.isTrue(update == 1, "更新数据库异常，请联系管理员");
        return AccountDoConvert.INSTANCE.do2Dto(accountDO);
    }

    @Override
    public void remove(Account account) {
        AccountDO accountDO = AccountDoConvert.INSTANCE.dto2Do(account);
        accountMapper.deleteById(accountDO.getId());
    }

    @Override
    public Account find(Long id) {
        AccountDO account = accountMapper.selectById(id);
        return AccountDoConvert.INSTANCE.do2Dto(account);
    }

    @Override
    public Account findByAccountNo(String accountNo) {
        LambdaQueryWrapper<AccountDO> queryWrapper = new LambdaQueryWrapper<AccountDO>()
                .eq(AccountDO::getAccountNo, accountNo);
        return AccountDoConvert.INSTANCE.do2Dto(accountMapper.selectOne(queryWrapper));
    }

    @Override
    public void isAccountExistsOrError(String accountNo) {
        LambdaQueryWrapper<AccountDO> queryWrapper = new LambdaQueryWrapper<AccountDO>()
                .eq(AccountDO::getAccountNo, accountNo);
        List<AccountDO> accountDOList = accountMapper.selectList(queryWrapper);
        if (CollUtil.isNotEmpty(accountDOList)) {
            throw new BizException("邮箱已被占用");
        }
    }

    @Override
    public Organization getOrganizationByIdentity(String identity) {
        List<OrganizationDO> organizationDOList = organizationMapper.selectList(new LambdaQueryWrapper<OrganizationDO>()
                .eq(OrganizationDO::getName, identity));
        if (CollUtil.isEmpty(organizationDOList)) {
            return null;
        }
        return OrganizationDoConvert.INSTANCE.do2Dto(organizationDOList.get(0));
    }
}
