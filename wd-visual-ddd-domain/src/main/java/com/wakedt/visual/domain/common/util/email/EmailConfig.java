package com.wakedt.visual.domain.common.util.email;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author WangChenSheng
 * date 2022/12/29 16:14
 */
@Configuration
@ConfigurationProperties(
        prefix = "spring.mail"
)
public class EmailConfig {
    private String userName;

    public EmailConfig() {
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(final String userName) {
        this.userName = userName;
    }
}
