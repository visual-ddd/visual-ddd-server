package com.wakedt.visual.adapter.user.web;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.IdUtil;
import com.wakedata.common.core.context.UserInfoContext;
import com.wakedata.common.core.dto.ResultDTO;
import com.wakedt.visual.adapter.user.web.common.AccountInfoHelper;
import com.wakedt.visual.client.user.AccountLoginRpcService;
import com.wakedt.visual.client.user.dto.AccountDTO;
import com.wakedt.visual.client.user.dto.AccountInfo;
import com.wakedt.visual.client.user.dto.AccountLoginDTO;
import com.wakedt.visual.client.user.dto.AccountRoleDTO;
import com.wakedt.visual.domain.common.constant.VisualConstant;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Objects;

/**
 * @author WangChenSheng
 * date 2022/12/30 10:27
 */
@RestController
@RequestMapping("/web/account/login")
@Api(value = "/web/account/login", tags = "B端-账号登陆")
public class AccountLoginController {

    @Resource
    private AccountLoginRpcService accountLoginRpcService;

    @PostMapping(value = "/login")
    @ApiOperation(value = "账号登录")
    public ResultDTO<AccountInfo> login(HttpServletRequest request, HttpServletResponse response, @RequestBody @Valid AccountLoginDTO accountLoginDTO) {

        // 账号登陆
        ResultDTO<AccountDTO> resultDTO = accountLoginRpcService.login(accountLoginDTO);

        // 设置用户信息
        AccountInfo accountInfo = BeanUtil.copyProperties(resultDTO.getData(), AccountInfo.class);
        accountInfo.setSessionId(IdUtil.fastSimpleUUID());
        accountInfo.setIsAdmin(Objects.equals(accountInfo.getId(), VisualConstant.DEFAULT_SYS_ADMIN_ID));
        AccountInfoHelper.setSessionIdCookie(request, response, accountInfo.getSessionId());

        // session缓存
        AccountInfoHelper.setSession(request, accountInfo);
        return ResultDTO.success(accountInfo);
    }

    @PostMapping(value = "/logout")
    @ApiOperation(value = "退出登录")
    public ResultDTO<Boolean> logout(HttpServletRequest request, HttpServletResponse response) {
        AccountInfoHelper.removeCookieSession(request, response);
        return ResultDTO.success(Boolean.TRUE);
    }

    @PostMapping(value = "/get-account-info")
    @ApiOperation(value = "获取用户信息")
    public ResultDTO<AccountInfo> getAccountInfo() {
        AccountInfo accountInfo = UserInfoContext.getUser();
        return ResultDTO.success(accountInfo);
    }

    @PostMapping(value = "/get-account-role")
    @ApiOperation(value = "获取用户权限信息")
    public ResultDTO<AccountRoleDTO> getAccountRoleInfo() {
        AccountInfo accountInfo = UserInfoContext.getUser();
        return accountLoginRpcService.buildAccountRoleInfo(accountInfo);
    }


}
