package com.wakedt.visual.client.user;

import com.wakedata.common.core.dto.ResultDTO;
import com.wakedt.visual.client.user.dto.AccountDTO;
import com.wakedt.visual.client.user.dto.AccountInfo;
import com.wakedt.visual.client.user.dto.AccountLoginDTO;
import com.wakedt.visual.client.user.dto.AccountRoleDTO;

/**
 * @author WangChenSheng
 * date 2022/12/30 10:28
 */
public interface AccountLoginRpcService {

    /**
     * 账号登录
     *
     * @param accountLoginDTO accountLoginDTO
     * @return true/false
     */
    ResultDTO<AccountDTO> login(AccountLoginDTO accountLoginDTO);

    /**
     * 获取账号权限信息
     *
     * @param accountInfo 账号信息
     * @return 账号权限信息
     */
    ResultDTO<AccountRoleDTO> buildAccountRoleInfo(AccountInfo accountInfo);
}
