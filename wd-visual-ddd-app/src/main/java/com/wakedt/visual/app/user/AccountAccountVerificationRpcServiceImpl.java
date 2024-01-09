package com.wakedt.visual.app.user;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.wakedata.common.core.dto.ResultDTO;
import com.wakedata.common.core.exception.BizException;
import com.wakedt.visual.app.user.assembler.AccountCreateDTOConvert;
import com.wakedt.visual.app.user.assembler.AccountVerificationCreateDTOConvert;
import com.wakedt.visual.app.user.config.RegisterEmailConfiguration;
import com.wakedt.visual.app.user.view.AccountVerificationDetailQueryExe;
import com.wakedt.visual.client.user.AccountVerificationRpcService;
import com.wakedt.visual.client.user.dto.AccountRegisterDTO;
import com.wakedt.visual.client.user.dto.AccountVerificationCreateDTO;
import com.wakedt.visual.client.user.dto.AccountVerificationDTO;
import com.wakedt.visual.domain.common.constant.VisualConstant;
import com.wakedt.visual.domain.common.util.RandomUtil;
import com.wakedt.visual.domain.common.util.email.EmailUtil;
import com.wakedt.visual.domain.common.util.email.SendInfo;
import com.wakedt.visual.domain.user.account.create.AccountCreateCmdHandler;
import com.wakedt.visual.domain.user.verifycode.AccountVerification;
import com.wakedt.visual.domain.user.verifycode.AccountVerificationRepository;
import com.wakedt.visual.domain.user.verifycode.create.AccountVerificationCreateCmd;
import com.wakedt.visual.domain.user.verifycode.create.AccountVerificationCreateCmdHandler;
import com.wakedt.visual.domain.user.verifycode.update.AccountVerificationUpdateCmd;
import com.wakedt.visual.domain.user.verifycode.update.AccountVerificationUpdateCmdHandler;
import com.wakedt.visual.domain.whitelist.whitelist.WhiteListRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Objects;

/**
 * author Wangchensheng@wakedata.com
 * date 2023年02月13日 11:39:56
 */
@Service
public class AccountAccountVerificationRpcServiceImpl implements AccountVerificationRpcService {

    @Resource
    private AccountCreateCmdHandler accountCreateCmdHandler;
    @Resource
    private AccountVerificationDetailQueryExe accountVerificationDetailQueryExe;
    @Resource
    private AccountVerificationCreateCmdHandler accountVerificationCreateCmdHandler;
    @Resource
    private AccountVerificationUpdateCmdHandler accountVerificationUpdateCmdHandler;

    @Resource
    private AccountVerificationRepository accountVerificationRepository;
    @Resource
    private WhiteListRepository whiteListRepository;
    @Resource
    private RegisterEmailConfiguration registerEmailConfiguration;


    @Override
    public ResultDTO<Boolean> accountRegister(AccountRegisterDTO dto) {
        String accountNo = dto.getAccountNo();
        AccountVerificationDTO accountVerificationDTO = accountVerificationDetailQueryExe.execute(accountNo).getData();

        // 验证码校验
        checkCodeDue(accountVerificationDTO, dto.getCode());

        // 创建账号
        accountCreateCmdHandler.handle(AccountCreateDTOConvert.INSTANCE.dto2Do(dto));
        return ResultDTO.success(Boolean.TRUE);
    }

    @Override
    public ResultDTO<Boolean> accountVerificationCreateOrUpdate(AccountVerificationCreateDTO accountVerificationCreateDTO) {
        String accountNo = accountVerificationCreateDTO.getAccountNo();

        // 校验白名单
        accountVerify(accountNo);

        String code = RandomUtil.buildVerification(VisualConstant.VERIFICATION_CODE_LENGTH);

        // 数据库存储一条最新的验证码信息
        AccountVerification verification = accountVerificationRepository.findByAccountNo(accountNo);
        if (verification == null) {
            AccountVerificationCreateCmd verifyCodeCreateCmd = AccountVerificationCreateDTOConvert.INSTANCE.dto2Do(accountVerificationCreateDTO);
            verifyCodeCreateCmd.setCode(code);
            accountVerificationCreateCmdHandler.handle(verifyCodeCreateCmd);
        } else {
            AccountVerificationUpdateCmd accountVerificationUpdateCmd = new AccountVerificationUpdateCmd();
            accountVerificationUpdateCmd.setId(verification.getId());
            accountVerificationUpdateCmd.setCode(code);
            accountVerificationUpdateCmdHandler.handle(accountVerificationUpdateCmd);
        }

        // 发送验证码邮件
        sendCodeEmail(accountVerificationCreateDTO, code);
        return ResultDTO.success(Boolean.TRUE);
    }

    private void accountVerify(String accountNo) {
        // 校验账号的邮箱后缀是否在配置列表中
        if (registerEmailConfiguration.notInMailSuffixList(accountNo)
                && (registerEmailConfiguration.isWhitelistEnable())) {
            // 校验账号是否在白名单中
            whiteListRepository.checkAccountNoInWhiteList(accountNo);
        }
    }

    /**
     * 校验验证码是否过期
     * 校验验证码是否正确
     */
    private void checkCodeDue(AccountVerificationDTO verificationDTO, String code) {
        if (Objects.isNull(verificationDTO)) {
            throw new BizException("验证码不存在, 请查看账号是否一致");
        }

        long codeTime = verificationDTO.getUpdateTime().toInstant(ZoneOffset.of("+8")).toEpochMilli();
        long nowTime = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
        long codeDue = codeTime + VisualConstant.VERIFICATION_CODE_DUE;

        if (nowTime > codeDue) {
            throw new BizException("验证码过期");
        }

        if (!StringUtils.equals(verificationDTO.getCode(), code)) {
            throw new BizException("验证码不正确, 请输入正确的验证码");
        }
    }

    /**
     * 发送验证码邮件
     */
    private static void sendCodeEmail(AccountVerificationCreateDTO accountVerificationCreateDTO, String code) {
        SendInfo sendInfo = SendInfo.builder()
                .mailSubject(VisualConstant.SEND_MAIL_REGISTER_ACCOUNT_SUBJECT)
                .mailUser(accountVerificationCreateDTO.getAccountNo())
                .mailContent(String.format(VisualConstant.SEND_MAIN_REGISTER_ACCOUNT, code)).build();
        try {
            EmailUtil.sendHtmlEmail(sendInfo);
        } catch (Exception e) {
            throw new BizException("发送邮件失败！");
        }
    }

}
