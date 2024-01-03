package com.wakedt.visual.app.user;

import com.wakedata.common.core.dto.ResultDTO;
import com.wakedt.visual.app.user.assembler.*;
import com.wakedt.visual.app.user.view.AccountDetailQueryExe;
import com.wakedt.visual.app.user.view.AccountPageQueryExe;
import com.wakedt.visual.client.user.AccountRpcService;
import com.wakedt.visual.client.user.dto.*;
import com.wakedt.visual.client.user.query.AccountDetailQuery;
import com.wakedt.visual.client.user.query.AccountPageQuery;
import com.wakedt.visual.domain.user.account.create.AccountCreateCmd;
import com.wakedt.visual.domain.user.account.create.AccountCreateCmdHandler;
import com.wakedt.visual.domain.user.account.delete.AccountDeleteCmd;
import com.wakedt.visual.domain.user.account.delete.AccountDeleteCmdHandler;
import com.wakedt.visual.domain.user.account.email.send.AccountEmailSendCmd;
import com.wakedt.visual.domain.user.account.email.send.AccountEmailSendCmdHandler;
import com.wakedt.visual.domain.user.account.password.reset.AccountPasswordResetCmd;
import com.wakedt.visual.domain.user.account.password.reset.AccountPasswordResetCmdHandler;
import com.wakedt.visual.domain.user.account.passwordupdate.AccountPasswordUpdateCmdHandler;
import com.wakedt.visual.domain.user.account.update.AccountUpdateCmd;
import com.wakedt.visual.domain.user.account.update.AccountUpdateCmdHandler;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * 账号-聚合根-RPC能力接口实现
 *
 * @author zhuxueliang
 */
@Service
public class AccountRpcServiceImpl implements AccountRpcService {

    @Resource
    private AccountCreateCmdHandler accountCreateCmdHandler;
    @Resource
    private AccountUpdateCmdHandler accountUpdateCmdHandler;
    @Resource
    private AccountDeleteCmdHandler accountDeleteCmdHandler;
    @Resource
    private AccountPasswordResetCmdHandler accountPasswordResetCmdHandler;
    @Resource
    private AccountEmailSendCmdHandler accountEmailSendCmdHandler;
    @Resource
    private AccountPasswordUpdateCmdHandler accountPasswordUpdateCmdHandler;
    @Resource
    private AccountDetailQueryExe accountDetailQueryExe;
    @Resource
    private AccountPageQueryExe accountPageQueryExe;


    @Override
    public ResultDTO<Boolean> accountCreate(AccountCreateDTO accountCreateDto) {
        AccountCreateCmd accountCreateCmd = AccountCreateDTOConvert.INSTANCE.dto2Do(accountCreateDto);
        accountCreateCmdHandler.handle(accountCreateCmd);
        return ResultDTO.success(Boolean.TRUE);
    }

    @Override
    public ResultDTO<Boolean> accountUpdate(AccountUpdateDTO dto) {
        AccountUpdateCmd accountUpdateCmd = AccountUpdateDTOConvert.INSTANCE.dto2Do(dto);

        if (dto.getIsAdmin()) {
            accountUpdateCmdHandler.handle(accountUpdateCmd);
            return ResultDTO.success(Boolean.TRUE);
        }

        if (isCurrentAccount(dto.getCurrentUserId(), dto.getId())) {
            accountUpdateCmd.setNewPassword(null);
            accountUpdateCmdHandler.handle(accountUpdateCmd);
            return ResultDTO.success(Boolean.TRUE);
        }

        return ResultDTO.fail("非管理员不能更改他人账号");
    }

    @Override
    public ResultDTO<Boolean> accountDelete(AccountDeleteDTO accountDeleteDto) {
        AccountDeleteCmd accountDeleteCmd = AccountDeleteDTOConvert.INSTANCE.dto2Do(accountDeleteDto);
        accountDeleteCmdHandler.handle(accountDeleteCmd);
        return ResultDTO.success(Boolean.TRUE);
    }

    @Override
    public ResultDTO<Boolean> accountPasswordReset(AccountPasswordResetDTO accountPasswordResetDto) {
        AccountPasswordResetCmd accountPasswordResetCmd = AccountPasswordResetDTOConvert.INSTANCE.dto2Do(accountPasswordResetDto);
        accountPasswordResetCmdHandler.handle(accountPasswordResetCmd);
        return ResultDTO.success(Boolean.TRUE);
    }

    @Override
    public ResultDTO<Boolean> accountEmailSend(AccountEmailSendDTO accountEmailSendDto) {
        AccountEmailSendCmd accountEmailSendCmd = AccountEmailSendDTOConvert.INSTANCE.dto2Do(accountEmailSendDto);
        accountEmailSendCmdHandler.handle(accountEmailSendCmd);
        return ResultDTO.success(Boolean.TRUE);
    }

    @Override
    public ResultDTO<Boolean> accountPasswordUpdate(AccountPasswordUpdateDTO dto) {
        if (dto.getIsAdmin() || isCurrentAccount(dto.getCurrentUserId(), dto.getId())) {
            accountPasswordUpdateCmdHandler.handle(AccountPasswordUpdateDTOConvert.INSTANCE.dto2Do(dto));
            return ResultDTO.success(Boolean.TRUE);
        }
        return ResultDTO.fail("非管理员不能更改他人账号");
    }

    @Override
    public ResultDTO<AccountDTO> accountDetailQuery(AccountDetailQuery query) {
        return accountDetailQueryExe.execute(query);
    }

    @Override
    public ResultDTO<List<AccountDTO>> accountPageQuery(AccountPageQuery pageQuery) {
        return accountPageQueryExe.execute(pageQuery);
    }

    /**
     * 是否为当前账号
     */
    private boolean isCurrentAccount(Long currentUserId, Long id) {
        return Objects.equals(currentUserId, id);
    }

}