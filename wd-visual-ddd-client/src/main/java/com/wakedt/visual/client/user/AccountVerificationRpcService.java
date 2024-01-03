package com.wakedt.visual.client.user;

import com.wakedata.common.core.dto.ResultDTO;
import com.wakedt.visual.client.user.dto.AccountRegisterDTO;
import com.wakedt.visual.client.user.dto.AccountVerificationCreateDTO;

/**
 * author Wangchensheng@wakedata.com
 * date 2023年02月13日 11:36:48
 */
public interface AccountVerificationRpcService {

    /**
     * 创建/更新注册验证码
     *
     * @param dto 验证码参数
     * @return true/false
     */
    ResultDTO<Boolean> accountVerificationCreateOrUpdate(AccountVerificationCreateDTO dto);

    /**
     * 注册账号
     *
     * @param dto 注册账号参数
     * @return true/false
     */
    ResultDTO<Boolean> accountRegister(AccountRegisterDTO dto);

}
