package com.learn.controller;

import com.learn.commons.tool.TotalData;
import com.learn.commons.utils.SessionUtils;
import com.learn.mapper.CollectionsMapper;
import com.learn.mapper.UserInfoMapper;
import com.learn.pojo.Collections;
import com.learn.pojo.UserInfo;
import com.learn.service.impl.CollectionsSeriviceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("collections")
public class CollectionsController {


    @Autowired
    CollectionsSeriviceImpl collectionsSerivice;

    @ResponseBody
    @RequestMapping("addCollection")
    public TotalData addCollection(Collections collections) {


        return collectionsSerivice.addCollection(collections);

    }


    @ResponseBody
    @RequestMapping("delCollection")
    public TotalData delCollection(Integer id) {


        return collectionsSerivice.delCollection(id);

    }

    @RequestMapping("listUserCollections")
    public String listUserCollections(HttpServletRequest request){

        UserInfo userInfo = SessionUtils.getUserInfo(request);
        List<Collections> collections = collectionsSerivice.listUserCollections(userInfo.getId());
        request.setAttribute("collections",collections);

        return "person/personCollections";
    }


}
