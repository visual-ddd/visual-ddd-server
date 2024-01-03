package com.wakedt.visual.app.user.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * 注册邮箱验证配置
 */
@Getter
@Configuration
public class RegisterEmailConfiguration {

    @Value("${register.mail.suffix-configs}")
    private String[] mailSuffixList;

    @Value("${register.whitelist.enable}")
    private Boolean whitelistEnable;


    public Boolean notInMailSuffixList(String email) {
        return Arrays.stream(mailSuffixList).noneMatch(suffix -> email.endsWith("@" + suffix));
    }

    public Boolean isWhitelistEnable() {
        return whitelistEnable;
    }
}