package com.wakedt.visual.domain.common.constant;

/**
 * @author WangChenSheng
 * date 2022/12/30 15:20
 */
public class VisualConstant {

    public static final Long DEFAULT_SYS_ADMIN_ID = 1L;

    public static final String VISUAL_ACCOUNT_INFO_KEY = "account::%s";

    // 发送邮件的相关常量
    public static final String SEND_MAIL_RESET_PASS_WORD_SUBJECT = "【Visual DDD】重置密码";
    public static final String SEND_MAIL_RESET_PASS_WORD_INFO = "/reset-password?code=%s&userId=%s";
    public static final String SEND_MAIL_REGISTER_ACCOUNT_SUBJECT = "【Visual DDD】注册验证码";
    public static final String SEND_MAIN_REGISTER_ACCOUNT = "<!DOCTYPE html>\n" +
            "<html>\n" +
            "  <head>\n" +
            "    <meta charset=\"UTF-8\">\n" +
            "    <title>DDD可视化平台</title>\n" +
            "  </head>\n" +
            "  <body>\n" +
            "    <p>尊敬的用户：</p>\n" +
            "    <p>感谢您注册DDD可视化平台，请使用下面的验证码完成注册流程：</p>\n" +
            "    <p>【验证码：<span style=\"color: red;\">%s</span>】</p>\n" +
            "    <p>该验证码将于30分钟后失效，请及时输入以完成您的注册。</p>\n" +
            "    <p>如有任何问题，请随时联系我们，我们将竭诚为您服务。</p>\n" +
            "    <p>谢谢！<br>DDD可视化平台团队</p>\n" +
            "  </body>\n" +
            "</html>\n";

    // 注册验证码的相关配置
    public static final Integer VERIFICATION_CODE_LENGTH = 4;
    public static final Long VERIFICATION_CODE_DUE = 1800000L;

    // 登陆常量
    public static final Integer VISUAL_SESSION_LOGIN_CACHE_EXPIRE_TIME = -1;
    public static final String VISUAL_COOKIE_KEY = "visualJsid";
    public static final Integer VISUAL_COOKIE_LOGOUT_AGE = 0;
    public static final String VISUAL_COOKIE_PATH = "/";
    public static final String NOT_LOGIN_MEG = "未登陆";
    public static final Integer NOT_LOGIN_CODE = 401;

    // response常量
    public static final String RESPONSE_CHARACTER_ENCODING = "UTF-8";
    public static final String RESPONSE_CONTENT_TYPE = "application/json; charset=utf-8";

    public static final String STRING_SPLIT = ",";

}
