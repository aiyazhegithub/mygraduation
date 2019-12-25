package com.learn.controller;


import com.learn.commons.tool.TotalData;
import com.learn.commons.utils.SessionUtils;
import com.learn.mapper.MessagesMapper;
import com.learn.pojo.Messages;
import com.learn.pojo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
@RequestMapping("messages")
public class MessagesController {

    @Autowired
    MessagesMapper messagesMapper;

    @ResponseBody
    @RequestMapping("addmessages")
    public TotalData addMessages(Messages messages, HttpServletRequest request){

        if (messages==null){

        }else if(messages.getPublishId() == null){

        }else if (messages.getLuserId()==null){

        }else if (messages.getMessage()==null){

        }
        UserInfo userInfo = SessionUtils.getUserInfo(request);

        System.out.println(messages);
        messages.setLuserId(userInfo.getId());
        messages.setBeginDate(new Date());

        messagesMapper.insertSelective(messages);

        TotalData totalData = new TotalData("成功");

        return totalData;
    }










}
