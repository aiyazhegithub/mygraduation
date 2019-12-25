package com.learn.controller;

import com.learn.commons.utils.SessionUtils;
import com.learn.pojo.DealTables;
import com.learn.pojo.UserInfo;
import com.learn.service.impl.DealsSerivceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("deals")
public class DealsController {


    @Autowired
    DealsSerivceImpl dealsSerivce;

    @RequestMapping("todeals")
    public String todeals(DealTables dealTables, HttpServletRequest request,Model model){

        if(dealTables.getPublishId() == null){


        }

        return dealsSerivce.tocharge(dealTables,request,model);
    }

    /**
     * 支付
     * @param dealTables
     * @param request
     * @return
     */
    @RequestMapping("pay")
    public String pay(DealTables dealTables, HttpServletRequest request){

        if(dealTables.getId()==null){

        }


        return dealsSerivce.pay(dealTables,request);

    }

    @RequestMapping("list")
    public String tolist(Integer userId,HttpServletRequest request){

        UserInfo userInfo = SessionUtils.getUserInfo(request);
        List<DealTables> dealTables = dealsSerivce.listDealsDetail(userInfo.getId(), request);

        request.setAttribute("dealTables",dealTables);

        return "person/personDeaLlist";
    }

    /**
     * 确认收货
     * @param request
     * @param dealId
     * @return
     */
    @ResponseBody
    @RequestMapping("confirm")
    public String confirmPay(HttpServletRequest request,Long dealId){


        UserInfo userInfo = SessionUtils.getUserInfo(request);
        System.out.println(userInfo);
         dealsSerivce.confirmPay(dealId, userInfo.getId());



        return null;
    }










}
