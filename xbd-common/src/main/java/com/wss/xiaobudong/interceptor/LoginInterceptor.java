package com.wss.xiaobudong.interceptor;

import com.wss.xiaobudong.enums.BizCodeEnum;
import com.wss.xiaobudong.model.LoginUser;
import com.wss.xiaobudong.utils.CommonUtil;
import com.wss.xiaobudong.utils.JWTUtil;
import com.wss.xiaobudong.utils.JsonData;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    public static ThreadLocal<LoginUser> threadLocal = new ThreadLocal<>();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String accessToken = request.getHeader("token");
        if (accessToken == null) {
            accessToken = request.getParameter("token");
        }
        if (StringUtils.isNotBlank(accessToken)) {
            //不为空
            Claims claims = JWTUtil.checkJWT(accessToken);
            if (claims == null) {
                //未登录
                CommonUtil.sendJsonMessage(response, JsonData.buildResult(BizCodeEnum.ACCOUNT_UNLOGIN));
                return false;
            }

            long userId = Long.valueOf(claims.get("id").toString());
            String headImg = (String) claims.get("head_img");
            String name = (String) claims.get("name");
            String mail = (String) claims.get("mail");


            LoginUser loginUser = LoginUser
                    .builder()
                    .headImg(headImg)
                    .name(name)
                    .id(userId)
                    .mail(mail).build();
            // protobuf
//            loginUser.setName(name);
//            loginUser.setHeadImg(headImg);
//            loginUser.setId(userId);
//            loginUser.setMail(mail);

            //通过attribute传递用户信息
            //request.setAttribute("loginUser",loginUser);

            //通过threadLocal传递用户登录信息

            threadLocal.set(loginUser);

            return true;


        }

        CommonUtil.sendJsonMessage(response,JsonData.buildResult(BizCodeEnum.ACCOUNT_UNLOGIN));
        return false;
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
