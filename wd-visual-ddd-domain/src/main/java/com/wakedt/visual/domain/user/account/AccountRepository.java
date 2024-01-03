package com.wakedt.visual.domain.user.account;

import com.wakedt.visual.domain.organization.organization.Organization;

/**
 * 账号-聚合根-仓储接口
 *
 * @author zhuxueliang
 */
public interface AccountRepository {

    /**
     * 创建账号
     *
     * @param account 账号聚合
     * @return 账号聚合
     */
    Account save(Account account);

    /**
     * 更新账号
     *
     * @param account 账号聚合
     * @return 账号聚合
     */
    Account update(Account account);

    /**
     * 删除账号
     *
     * @param account 账号聚合(主键id)
     */
    void remove(Account account);

    /**
     * 查看账号详情
     *
     * @param id 主键id
     * @return 账号聚合
     */
    Account find(Long id);

    /**
     * 查看账号详情
     *
     * @param accountNo 账号唯一标识
     * @return 账号聚合
     */
    Account findByAccountNo(String accountNo);

    /**
     * 校验账号唯一标识是否存在
     *
     * @param accountNo 账号唯一标识
     */
    void isAccountExistsOrError(String accountNo);

    /**
     * 根据唯一标识获取组织信息
     */
    Organization getOrganizationByIdentity(String identity);
}
