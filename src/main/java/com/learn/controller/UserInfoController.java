package com.learn.controller;

import com.learn.commons.utils.SessionUtils;
import com.learn.mapper.UserInfoMapper;
import com.learn.pojo.UserInfo;
import com.learn.service.impl.UserInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("users")
public class UserInfoController {


    @Autowired
    UserInfoServiceImpl userInfoService;





    @RequestMapping("person")
    public String person(HttpServletRequest request){
        UserInfoMapper userInfoMapper = userInfoService.getUserInfoMapper();
        UserInfo userInfo = SessionUtils.getUserInfo(request);
        UserInfo userInfo1 = userInfoMapper.selectByPrimaryKey(userInfo.getId());
        SessionUtils.setUserInfo(request,userInfo1);

        return "person/person";
    }


    @RequestMapping("userInfo")
    public String userInfo(){

        return "person/person_info";
    }


    @RequestMapping("update")
    public String update(UserInfo userInfo, HttpServletRequest request){

        UserInfo userInfo1 = SessionUtils.getUserInfo(request);
        userInfo1.setUserName(userInfo.getUserName());
        userInfo1.setPhone(userInfo.getPhone());
        userInfo1.setSex(userInfo.getSex());
        SessionUtils.setUserInfo(request,userInfo1);
        System.out.println(userInfo1);
        userInfoService.updateByPrimaryKeySelective(userInfo1,request);


        return "person/person_info";
    }



}
