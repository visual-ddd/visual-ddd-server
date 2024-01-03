package com.wakedt.visual.domain.common.util.email;

import com.wakedt.visual.domain.common.constant.VisualConstant;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Arrays;

/**
 * @author WangChenSheng
 * date 2022/12/29 16:12
 */
@Component
public class EmailUtil implements ApplicationContextAware {
    private static final Logger log = LoggerFactory.getLogger(EmailUtil.class);
    private static JavaMailSender mailSender;
    private static EmailConfig emailConfig;

    public EmailUtil() {
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        mailSender = applicationContext.getBean(JavaMailSender.class);
        emailConfig = applicationContext.getBean(EmailConfig.class);
    }

    /**
     * 发送邮件
     *
     * @param sendInfo 邮件信息
     */
    public static void sendEmail(SendInfo sendInfo) {
        if (StringUtils.isNotBlank(sendInfo.getMailUser())) {
            String[] warnUser = sendInfo.getMailUser().split(VisualConstant.STRING_SPLIT);
            Arrays.stream(warnUser).forEach(to -> EmailUtil.sendSimpleTextEmail(to, sendInfo.getMailSubject(), sendInfo.getMailContent()));
        }
    }

    /**
     * 发送HTML邮件
     *
     * @param sendInfo 邮件信息
     */
    public static void sendHtmlEmail(SendInfo sendInfo) {
        if (StringUtils.isNotBlank(sendInfo.getMailUser())) {
            String[] warnUser = sendInfo.getMailUser().split(VisualConstant.STRING_SPLIT);
            Arrays.stream(warnUser).forEach(to -> EmailUtil.sendHtmlTextEmail(to, sendInfo.getMailSubject(), sendInfo.getMailContent()));
        }
    }

    private static void sendSimpleTextEmail(String to, String subject, String content) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(to);
            message.setSubject(subject);
            message.setText(content);
            message.setFrom(emailConfig.getUserName());
            log.info("Send simple text email\n:{}。", message);
            mailSender.send(message);
        } catch (MailException var4) {
            log.error("Error to send email!to:{}, subject:{}, content:{}!", to, subject, content);
            log.error(var4.getMessage());
            throw var4;
        }
    }

    private static void sendHtmlTextEmail(String to, String subject, String content) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true);
            helper.setFrom(emailConfig.getUserName());

            log.info("Send html text email\n:{}。", message);
            mailSender.send(message);
        } catch (MailException var4) {
            log.error("Error to send email!to:{}, subject:{}, content:{}!", to, subject, content);
            log.error(var4.getMessage());
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}