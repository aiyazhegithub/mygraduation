package com.learn.commons.utils;

import com.alibaba.fastjson.JSON;
import com.learn.pojo.UserInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionUtils {





    public static UserInfo getUserInfo(HttpServletRequest request){
        HttpSession session = request.getSession();
        String user_name = (String) session.getAttribute("USER_NAME");
        UserInfo userInfo = JSON.parseObject(user_name, UserInfo.class);
        return userInfo;

    }

    public static boolean setUserInfo(HttpServletRequest request,
                                       UserInfo userInfo){

        String json = JSON.toJSONString(userInfo);
        HttpSession session = request.getSession();
        session.setAttribute("USER_NAME",json);
        request.setAttribute("userInfo",userInfo);

        return true;

    }







}
