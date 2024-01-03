package com.wakedt.visual.adapter.user.web.common;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.json.JSONUtil;
import com.wakedt.visual.client.user.dto.AccountInfo;
import com.wakedt.visual.domain.common.constant.VisualConstant;
import org.apache.shiro.web.servlet.SimpleCookie;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.Objects;

/**
 * @author WangChenSheng
 * date 2022/12/30 10:59
 */
public class AccountInfoHelper {

    /**
     * 获取登录sessionId
     */
    public static String getVisualCookieId(HttpServletRequest request){

        Cookie[] cookies = request.getCookies();
        if(ObjectUtil.isEmpty(cookies)){
            return null;
        }
        return Arrays.stream(cookies)
                .filter(cookie -> Objects.equals(VisualConstant.VISUAL_COOKIE_KEY, cookie.getName()))
                .findFirst().map(Cookie::getValue).orElse(null);
    }

    /**
     * 获取登录用户缓存key
     */
    public static String getAccountInfoSessionKey(String sessionId){
        return String.format(VisualConstant.VISUAL_ACCOUNT_INFO_KEY,sessionId);
    }

    /**
     * 刷新缓存时间
     */
    public static void refreshVisualAccountSessionExpireTime(HttpSession session) {
        session.setMaxInactiveInterval(VisualConstant.VISUAL_SESSION_LOGIN_CACHE_EXPIRE_TIME);
    }

    /**
     * 设置cookie
     * @param request request
     * @param response response
     * @param sessionId sessionId
     */
    public static void setSessionIdCookie(HttpServletRequest request, HttpServletResponse response, String sessionId) {
        SimpleCookie simpleCookie = new SimpleCookie();
        simpleCookie.setName(VisualConstant.VISUAL_COOKIE_KEY);
        simpleCookie.setHttpOnly(Boolean.TRUE);
        simpleCookie.setPath(VisualConstant.VISUAL_COOKIE_PATH);
        simpleCookie.setValue(sessionId);
        simpleCookie.saveTo(request, response);
    }

    /**
     * 设置session
     *
     * @param request request
     * @param accountInfo 用户信息
     */
    public static void setSession(HttpServletRequest request, AccountInfo accountInfo) {
        HttpSession session = request.getSession();
        session.setAttribute(getAccountInfoSessionKey(accountInfo.getSessionId()), JSONUtil.toJsonStr(accountInfo));
        session.setMaxInactiveInterval(VisualConstant.VISUAL_SESSION_LOGIN_CACHE_EXPIRE_TIME);
    }

    /**
     * 移除cookie和session
     *
     * @param request request
     * @param response response
     */
    public static void removeCookieSession(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        if (ObjectUtil.isEmpty(cookies)) {
            return;
        }
        for (Cookie cookie : cookies) {
            if (Objects.equals(VisualConstant.VISUAL_COOKIE_KEY, cookie.getName())) {
                cookie.setMaxAge(VisualConstant.VISUAL_COOKIE_LOGOUT_AGE);
                cookie.setPath(VisualConstant.VISUAL_COOKIE_PATH);
                response.addCookie(cookie);
                //删除缓存
                request.getSession().removeAttribute(AccountInfoHelper.getAccountInfoSessionKey(cookie.getValue()));
            }
        }
    }
}
