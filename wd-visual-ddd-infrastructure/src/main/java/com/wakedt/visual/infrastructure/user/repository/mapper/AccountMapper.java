package com.wakedt.visual.infrastructure.user.repository.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wakedt.visual.client.user.query.AccountDetailQuery;
import com.wakedt.visual.client.user.query.AccountPageQuery;
import com.wakedt.visual.infrastructure.user.repository.model.AccountDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 账号Mapper接口
 *
 * @author zhuxueliang
 */
@Mapper
public interface AccountMapper extends BaseMapper<AccountDO> {

    /**
    * 查询用户账号信息详情
    */
    AccountDO accountDetailQuery(AccountDetailQuery query);

    /**
     * 分页查询用户账号信息
     */
    List<AccountDO> accountPageQuery(AccountPageQuery pageQuery);
}