package com.wakedt.visual.start.config;

import com.wakedt.visual.adapter.user.web.common.AccountLoginCheckInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author WangChenSheng
 * date 2022/12/30 12:51
 */
@Configuration
public class BeanConfiguration implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        //登录校验
        InterceptorRegistration registration = registry.addInterceptor(new AccountLoginCheckInterceptor());
        registration.addPathPatterns("/web/**");
        registration.excludePathPatterns("/web/account/account-register");
        registration.excludePathPatterns("/web/account/account-send.email");
        registration.excludePathPatterns("/web/account/account-password-reset");
        registration.excludePathPatterns("/web/account/account-password-reset-send.email");
        registration.excludePathPatterns("/web/account/login/login");

        // 业务域开放文档
        registration.excludePathPatterns("/web/secondary-development/get-domain-design-version-no-auth");
        registration.excludePathPatterns("/web/secondary-development/get-application-bind-model-info");
        registration.excludePathPatterns("/web/secondary-development/get-business-scene-version-no-auth");
    }
}
