package com.wakedt.visual.domain.common.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * 注册邮箱验证配置
 */
@Getter
@Configuration
public class PasswordResetEmailConfiguration {

    @Value("${password-reset.url.config}")
    private String passwordResetUrl;

}