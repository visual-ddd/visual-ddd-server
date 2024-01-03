package com.wakedt.visual.domain.user.account.email.send;

import com.wakedata.common.core.exception.BizException;
import com.wakedt.visual.domain.common.config.PasswordResetEmailConfiguration;
import com.wakedt.visual.domain.common.constant.VisualConstant;
import com.wakedt.visual.domain.common.util.email.EmailUtil;
import com.wakedt.visual.domain.common.util.email.SendInfo;
import com.wakedt.visual.domain.user.account.Account;
import com.wakedt.visual.domain.user.account.AccountRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Objects;
import java.util.UUID;

/**
 * 发送重置密码邮件-指令处理器
 *
 * @author zhuxueliang
 */
@Component
public class AccountEmailSendCmdHandler {

    @Resource
    private AccountRepository repository;
    @Resource
    private PasswordResetEmailConfiguration passwordResetEmailConfiguration;

    public void handle(AccountEmailSendCmd accountEmailSendCmd) {
        String uuid = UUID.randomUUID().toString();
        Account account = repository.findByAccountNo(accountEmailSendCmd.getAccountNo());
        if (Objects.isNull(account)) {
            throw new BizException("获取不到账号信息");
        }

        // 发送重置邮件
        SendInfo sendInfo = SendInfo.builder()
                .mailSubject(VisualConstant.SEND_MAIL_RESET_PASS_WORD_SUBJECT)
                .mailUser(account.getAccountNo())
                .mailContent(buildMailContent(uuid, account.getAccountNo())).build();
        EmailUtil.sendHtmlEmail(sendInfo);

        // 更新重置账号uuid
        account.updateAccountRetPass(uuid);
        repository.update(account);

//        DomainEventPublisher.getInstance().postAfterCommit(new AccountEmailSendCmdEvent(removeCmd));
    }

    /**
     * 构建邮件消息体
     *
     * @param code      uuid
     * @param accountNo 账号
     * @return 邮件消息体
     */
    private String buildMailContent(String code, String accountNo) {
        String urlFormat = passwordResetEmailConfiguration.getPasswordResetUrl()
                + VisualConstant.SEND_MAIL_RESET_PASS_WORD_INFO;
        String url = String.format(urlFormat, code, accountNo);

        return String.format("<!DOCTYPE html> <html> <head> <meta charset=\"UTF-8\"> " +
                "<title>DDD可视化平台重置密码</title> </head> <body> <h3>尊敬的用户：</h3> <p>请点击以下链接重置密码：" +
                "</p> <p><a href=\"%s\">[%s]</a></p> <p>为了保护您的账户安全，请设置强度较高的密码，并不要使用其他账户相同的密码。" +
                "</p> <p>如非本人操作，请忽略此邮件。</p> <p>谢谢！</p> <br> <p>此致</p> <p>敬礼</p> <p>DDD可视化开发平台团队</p> " +
                "</body> </html>", url, url);
    }
}