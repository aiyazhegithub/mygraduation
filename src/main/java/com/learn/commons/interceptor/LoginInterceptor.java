package com.learn.commons.interceptor;

import com.alibaba.fastjson.JSON;
import com.learn.commons.tool.TotalData;
import com.learn.pojo.UserInfo;
import org.junit.Test;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler) throws Exception {
        HttpSession session = request.getSession();

        String user_name = (String) session.getAttribute("USER_NAME");

        if (user_name == null) {
            String url = request.getRequestURI();
            // URL:除了登录请求外，其他的URL都进行拦截控制
            if (url.indexOf("/tologin") >= 0
                    || url.indexOf("/tosign") >= 0
                    || url.indexOf("/login") >= 0
                    || url.indexOf("/sign") >= 0
                    || url.indexOf("/logout") >= 0
                    || url.indexOf("/notice") >= 0) {


                return true;

            } else {
                TotalData totalData = new TotalData("您还没有登录，请先登录！");

                request.setAttribute("data", totalData);
                request.getRequestDispatcher("/WEB-INF/views/active/login.jsp").forward(request, response);


                return false;
            }

        } else {
            UserInfo userInfo = JSON.parseObject(user_name, UserInfo.class);
            request.setAttribute("userInfo", userInfo);
            return true;

        }


    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {


    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
