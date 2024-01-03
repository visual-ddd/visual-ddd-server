package com.wakedt.visual.client.user;

import com.wakedata.common.core.dto.ResultDTO;
import com.wakedt.visual.client.user.dto.*;
import com.wakedt.visual.client.user.query.AccountDetailQuery;
import com.wakedt.visual.client.user.query.AccountPageQuery;

import java.util.List;

/**
 * 账号-聚合根-RPC能力接口
 *
 * @author zhuxueliang
 */
public interface AccountRpcService {

    /**
     * 创建账号
     *
     * @param accountCreateDto 创建账号参数
     * @return true/false
     */
    ResultDTO<Boolean> accountCreate(AccountCreateDTO accountCreateDto);

    /**
     * 更新账号基本信息
     *
     * @param accountUpdateDto 更新账号参数
     * @return true/false
     */
    ResultDTO<Boolean> accountUpdate(AccountUpdateDTO accountUpdateDto);

    /**
     * 删除用户账号
     *
     * @param accountDeleteDto 删除账号参数
     * @return true/false
     */
    ResultDTO<Boolean> accountDelete(AccountDeleteDTO accountDeleteDto);

    /**
     * 重置用户密码
     *
     * @param accountPasswordResetDto 重置用户密码参数
     * @return true/false
     */
    ResultDTO<Boolean> accountPasswordReset(AccountPasswordResetDTO accountPasswordResetDto);

    /**
     * 发送重置密码邮件
     *
     * @param accountEmailSendDto 发送重置密码邮件参数
     * @return true/false
     */
    ResultDTO<Boolean> accountEmailSend(AccountEmailSendDTO accountEmailSendDto);

    /**
     * 修改用户密码
     *
     * @param accountPasswordUpdateDto 修改用户密码参数
     * @return true/false
     */
    ResultDTO<Boolean> accountPasswordUpdate(AccountPasswordUpdateDTO accountPasswordUpdateDto);

    /**
     * 查询用户账号信息详情
     *
     * @param query 查询用户账号信息详情条件
     * @return AccountDTO
     */
    ResultDTO<AccountDTO> accountDetailQuery(AccountDetailQuery query);

    /**
     * 分页查询用户账号信息
     *
     * @param pageQuery 分页查询用户账号信息条件
     * @return AccountDTOList
     */
    ResultDTO<List<AccountDTO>> accountPageQuery(AccountPageQuery pageQuery);

}