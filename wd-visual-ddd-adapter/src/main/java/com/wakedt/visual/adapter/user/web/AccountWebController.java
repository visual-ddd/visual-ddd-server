package com.wakedt.visual.adapter.user.web;

import com.wakedata.common.core.context.UserInfoContext;
import com.wakedata.common.core.dto.ResultDTO;
import com.wakedt.visual.client.user.AccountRpcService;
import com.wakedt.visual.client.user.AccountVerificationRpcService;
import com.wakedt.visual.client.user.dto.*;
import com.wakedt.visual.client.user.query.AccountDetailQuery;
import com.wakedt.visual.client.user.query.AccountPageQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * 账号-web-controller
 *
 * @author zhuxueliang
 */
@RestController
@RequestMapping("/web/account")
@Api(value = "/web/account", tags = "B端-账号")
public class AccountWebController {

    @Resource
    private AccountRpcService accountRpcService;
    @Resource
    private AccountVerificationRpcService accountVerificationRpcService;

    @ApiOperation("创建账号")
    @PostMapping("/account-create")
    public ResultDTO<Boolean> accountCreate(@RequestBody @Valid AccountCreateDTO dto) {
        return accountRpcService.accountCreate(dto);
    }

    @ApiOperation("更新账号基本信息")
    @PostMapping("/account-update")
    public ResultDTO<Boolean> accountUpdate(@RequestBody @Valid AccountUpdateDTO dto) {
        AccountInfo accountInfo = UserInfoContext.getUser();
        dto.setIsAdmin(accountInfo.getIsAdmin());
        dto.setCurrentUserId(accountInfo.getId());
        return accountRpcService.accountUpdate(dto);
    }

    @ApiOperation("删除用户账号")
    @PostMapping("/account-delete")
    public ResultDTO<Boolean> accountDelete(@RequestBody @Valid AccountDeleteDTO dto) {
        return accountRpcService.accountDelete(dto);
    }

    @ApiOperation("修改用户密码")
    @PostMapping("/account-password-update")
    public ResultDTO<Boolean> accountPasswordUpdate(@RequestBody @Valid AccountPasswordUpdateDTO dto) {
        AccountInfo accountInfo = UserInfoContext.getUser();
        dto.setIsAdmin(accountInfo.getIsAdmin());
        dto.setCurrentUserId(accountInfo.getId());

        accountRpcService.accountPasswordUpdate(dto);
        return ResultDTO.success(Boolean.TRUE);
    }

    @ApiOperation("查询用户账号信息详情")
    @GetMapping("/account-detail-query")
    public ResultDTO<AccountDTO> accountDetailQuery(AccountDetailQuery query) {
        return accountRpcService.accountDetailQuery(query);
    }

    @ApiOperation("分页查询用户账号信息")
    @GetMapping("/account-page-query")
    public ResultDTO<List<AccountDTO>> accountPageQuery(AccountPageQuery pageQuery) {
        return accountRpcService.accountPageQuery(pageQuery);
    }

    @ApiOperation("发送注册账号验证码")
    @PostMapping("/account-send.email")
    public ResultDTO<Boolean> accountVerificationCreate(@RequestBody @Valid AccountVerificationCreateDTO dto) {
        return accountVerificationRpcService.accountVerificationCreateOrUpdate(dto);
    }

    @ApiOperation("注册账号")
    @PostMapping("/account-register")
    public ResultDTO<Boolean> accountRegister(@RequestBody @Valid AccountRegisterDTO dto) {
        return accountVerificationRpcService.accountRegister(dto);
    }

    @ApiOperation("发送重置密码邮件")
    @PostMapping("/account-password-reset-send.email")
    public ResultDTO<Boolean> accountResetPasswordEmailSend(@RequestBody @Valid AccountEmailSendDTO dto) {
        return accountRpcService.accountEmailSend(dto);
    }

    @ApiOperation("重置用户密码")
    @PostMapping("/account-password-reset")
    public ResultDTO<Boolean> accountResetPassword(@RequestBody @Valid AccountPasswordResetDTO dto) {
        return accountRpcService.accountPasswordReset(dto);
    }
}


