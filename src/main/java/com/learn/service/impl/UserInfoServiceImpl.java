package com.learn.service.impl;


import com.learn.mapper.UserInfoMapper;
import com.learn.pojo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class UserInfoServiceImpl {

    @Autowired
    private UserInfoMapper userInfoMapper;

    public UserInfoMapper getUserInfoMapper() {
        return userInfoMapper;
    }

    public int  updateByPrimaryKeySelective(UserInfo userInfo, HttpServletRequest request){


         return userInfoMapper.updateByPrimaryKeySelective(userInfo);


    }





}



