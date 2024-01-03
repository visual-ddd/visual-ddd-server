package com.wakedt.visual.adapter.user.web.common;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.json.JSONUtil;
import com.wakedata.common.core.context.UserInfoContext;
import com.wakedata.common.core.dto.ResultDTO;
import com.wakedt.visual.client.user.dto.AccountInfo;
import com.wakedt.visual.domain.common.constant.VisualConstant;
import lombok.NonNull;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 登陆较验过滤器
 *
 * @author WangChenSheng
 * date 2022/12/30 11:09
 */
public class AccountLoginCheckInterceptor implements HandlerInterceptor {

    /**
     * 预处理
     */
    @Override
    public boolean preHandle(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull Object handler) {


        String sessionId = AccountInfoHelper.getVisualCookieId(request);
        if (ObjectUtil.isEmpty(sessionId)) {
            return notLogin(response);
        }

        HttpSession session = request.getSession();
        Object attribute = session.getAttribute(AccountInfoHelper.getAccountInfoSessionKey(sessionId));
        if (ObjectUtil.isEmpty(attribute)) {
            return notLogin(response);
        }

        AccountInfo accountInfo = JSONUtil.toBean(attribute.toString(), AccountInfo.class);
        accountInfo.setUserId(accountInfo.getUserName());
        UserInfoContext.setUser(accountInfo);
        // 目前用户会话过期时间默认为永久, 因此不刷新用户会话缓存时间
        // AccountInfoHelper.refreshIPaasUserSessionExpireTime(session);
        return Boolean.TRUE;
    }

    /**
     * 完成之后
     */
    @Override
    public void afterCompletion(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull Object handler, Exception ex) {
        UserInfoContext.removeUserInfoContext();
    }

    /**
     * 未登录
     */
    private boolean notLogin(HttpServletResponse response) {
        response.setCharacterEncoding(VisualConstant.RESPONSE_CHARACTER_ENCODING);
        response.setContentType(VisualConstant.RESPONSE_CONTENT_TYPE);
        //返回的数据
        ResultDTO<Boolean> resultDTO = new ResultDTO<>();
        resultDTO.setSuccess(Boolean.FALSE);
        resultDTO.setCode(VisualConstant.NOT_LOGIN_CODE);
        resultDTO.setMsg(VisualConstant.NOT_LOGIN_MEG);
        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.write(JSONUtil.toJsonStr(resultDTO));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.flush();
                out.close();
            }
        }
        return Boolean.FALSE;
    }

}
