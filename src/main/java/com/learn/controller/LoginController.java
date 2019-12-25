package com.learn.controller;

import com.alibaba.fastjson.JSON;
import com.github.wxpay.sdk.WXPay;
import com.learn.commons.tool.TotalData;
import com.learn.commons.utils.SessionUtils;
import com.learn.mapper.UserInfoMapper;
import com.learn.pojo.UserInfo;
import com.learn.pojo.UserInfoExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
public class LoginController {

    @Autowired
    UserInfoMapper userInfoMapper;

    @RequestMapping("hello")
    public String sayHello(Model view, HttpServletRequest request){


        return "index";

    }


    /**
     * 到登陆页面
     *
     * @return
     */
    @RequestMapping("tologin")
    public String tologin() {

        return "login";
    }

    /**
     * 到注册页面
     *
     * @return
     */
    @RequestMapping("tosign")
    public String tosign() {

        return "register";
    }

    /**
     * 登陆
     *
     * @return
     */
    @RequestMapping("login")
    public String login(String username, String passwd, Model model,
                        HttpServletRequest request,
                        HttpServletResponse response) {

        if (null == username || null == passwd) {
            TotalData totalData = new TotalData();
            totalData.setMsg("用户名或密码错误");
            model.addAttribute("data", totalData);
            return "login";
        }

        UserInfoExample userInfoExample = new UserInfoExample();
        UserInfoExample.Criteria criteria = userInfoExample.createCriteria();
        criteria.andPasswdEqualTo(passwd);
        criteria.andEmailEqualTo(username);
        List<UserInfo> userInfos = userInfoMapper.selectByExample(userInfoExample);

        if (userInfos.size() > 0) {

            UserInfo userInfo = userInfos.get(0);
            userInfo.setPasswd(null);
            userInfo.setRealName(null);
            SessionUtils.setUserInfo(request,userInfo);

            return "index";
        } else {
            TotalData totalData = new TotalData();
            totalData.setMsg("用户名或密码错误");
            model.addAttribute("data", totalData);
            return "login";
        }


    }

    /**
     * 注册
     *
     * @return
     */
    @RequestMapping("sign")
    public String sign(String username, String passwd, Model model) {

        if (null == username || null == passwd) {
            TotalData totalData = new TotalData();
            totalData.setMsg("请正确输入");
            model.addAttribute("data", totalData);
            return "register";
        }

        UserInfoExample userInfoExample = new UserInfoExample();
        UserInfoExample.Criteria criteria = userInfoExample.createCriteria();
        criteria.andEmailEqualTo(username);
        List<UserInfo> userInfos = userInfoMapper.selectByExample(userInfoExample);

        if (userInfos.size() > 0) {
            TotalData totalData = new TotalData();
            totalData.setMsg("邮箱已经存在");
            model.addAttribute("data", totalData);
            return "register";

        } else {


            UserInfo userInfo = new UserInfo();

            userInfo.setUserName(UUID.randomUUID().toString().substring(0,8));
            userInfo.setEmail(username);
            userInfo.setPasswd(passwd);
            userInfo.setBeginDate(new Date());
            userInfoMapper.insertSelective(userInfo);
            TotalData totalData = new TotalData();
            totalData.setMsg("注册成功请登陆");
            model.addAttribute("data", totalData);
            return "login";
        }


    }

    /**
     * 退出
     *
     * @return
     */
    @RequestMapping("logout")
    public String logout(HttpServletRequest request) {

        HttpSession session = request.getSession();
        session.setAttribute("USER_NAME",null);

        return "login";
    }



}
