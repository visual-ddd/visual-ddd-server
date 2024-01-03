package com.wakedt.visual.domain.user.verifycode;

/**
 * author Wangchensheng@wakedata.com
 * date 2023年02月13日 11:16:17
 */
public interface AccountVerificationRepository {

    /**
     * 创建验证码
     *
     * @param verification 验证码聚合
     * @return 验证码聚合
     */
    AccountVerification save(AccountVerification verification);

    /**
     * 更新验证码
     *
     * @param verification 验证码聚合
     * @return 验证码聚合
     */
    AccountVerification update(AccountVerification verification);

    /**
     * 查询验证码详情
     *
     * @param id 主键id
     * @return AccountVerification
     */
    AccountVerification find(Long id);

    /**
     * 账号获取验证码信息
     */
    AccountVerification findByAccountNo(String accountNo);
}
