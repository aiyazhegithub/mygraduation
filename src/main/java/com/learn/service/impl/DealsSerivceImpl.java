package com.learn.service.impl;


import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.learn.commons.tool.TotalData;
import com.learn.commons.utils.SessionUtils;
import com.learn.mapper.DealTablesMapper;
import com.learn.mapper.PublishGoodsMapper;
import com.learn.mapper.UserInfoMapper;
import com.learn.pojo.DealTables;
import com.learn.pojo.PublishGoods;
import com.learn.pojo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Service
public class DealsSerivceImpl {

    @Autowired
    DealTablesMapper dealTablesMapper;

    @Autowired
    PublishGoodsMapper publishGoodsMapper;
    @Autowired
    UserInfoMapper userInfoMapper;


    public String tocharge(DealTables dealTables, HttpServletRequest request, Model model) {
        //获取用户信息
        UserInfo userInfo = SessionUtils.getUserInfo(request);


        request.setAttribute("userInfo", userInfo);
        PublishGoods publishGoods =
                publishGoodsMapper.selectByPrimaryKey(dealTables.getPublishId());

        if (publishGoods != null) {

            model.addAttribute("publishGoods", publishGoods);

            if (userInfo.getMoney() != null && publishGoods.getSprice() != null) {
                if (userInfo.getMoney() < publishGoods.getSprice()) {
                    TotalData totalData = new TotalData("余额不足");
                    model.addAttribute("totalData", totalData);

                }
            } else {
                TotalData totalData = new TotalData("余额不足");
                model.addAttribute("totalData", totalData);
            }

        }


        return "deal";

    }

    @Transactional
    public String pay(DealTables dealTables, HttpServletRequest request) {
        //
        UserInfo userInfo = SessionUtils.getUserInfo(request);

        //验证
        UserInfo userInfo2 = userInfoMapper.selectByPrimaryKey(userInfo.getId());
        PublishGoods publishGoods = publishGoodsMapper.selectByPrimaryKey(dealTables.getPublishId());

        if(userInfo2.getMoney()<publishGoods.getSprice()){
            return "redirect:/charges/tocharge";
        }

        dealTables.setUserId(userInfo.getId());

        dealTables.setBeginDate(new Date());

        dealTablesMapper.insertSelective(dealTables);
        publishGoods.setEndDate(new Date());
        publishGoods.setIsdeal(1);
        publishGoodsMapper.updateByPrimaryKeySelective(publishGoods);
       // Integer money = userInfo.getMoney();
        Double money = userInfo.getMoney();
        userInfo.setMoney(money - publishGoods.getSprice());

        //更新收款人
        UserInfo userInfo1 = userInfoMapper.selectByPrimaryKey(1l);
        if (userInfo1.getMoney() == null) {
            userInfo1.setMoney(publishGoods.getSprice());
            userInfoMapper.updateByPrimaryKeySelective(userInfo1);
        } else {
            userInfo1.setMoney(userInfo1.getMoney() + publishGoods.getSprice());
            userInfoMapper.updateByPrimaryKeySelective(userInfo1);
        }

        SessionUtils.setUserInfo(request, userInfo);

        userInfoMapper.updateByPrimaryKeySelective(userInfo);

        request.setAttribute("data", new TotalData("支付成功"));


        return "success";

    }

    /**
     * 显示订单详情
     *
     * @param userId
     * @param request
     * @return
     */
    public List<DealTables> listDealsDetail(Long userId, HttpServletRequest request) {

        List<DealTables> dealTables = dealTablesMapper.listDealsDetail((long) userId);

        return dealTables;
    }

    @Transactional
    public boolean confirmPay(Long dealId, Long userId) {


        DealTables dealTables = dealTablesMapper.selectByPrimaryKey(dealId);

        if (dealTables != null) {

            PublishGoods publishGoods = publishGoodsMapper.selectByPrimaryKey(dealTables.getPublishId());
            //卖方ID
            UserInfo userInfo = userInfoMapper.selectByPrimaryKey(publishGoods.getUserId());
            if(userInfo.getMoney()==null){
                userInfo.setMoney(publishGoods.getSprice());
                userInfoMapper.updateByPrimaryKeySelective(userInfo);
                UserInfo adminuserInfo = userInfoMapper.selectByPrimaryKey(1l);
                adminuserInfo.setMoney(adminuserInfo.getMoney()-publishGoods.getSprice());
                userInfoMapper.updateByPrimaryKeySelective(adminuserInfo);
            }else {
                userInfo.setMoney(publishGoods.getSprice()+userInfo.getMoney());
                userInfoMapper.updateByPrimaryKeySelective(userInfo);

                UserInfo adminuserInfo = userInfoMapper.selectByPrimaryKey(1l);
                adminuserInfo.setMoney(adminuserInfo.getMoney()-publishGoods.getSprice());
                userInfoMapper.updateByPrimaryKeySelective(adminuserInfo);
            }


            if (dealTables.getUserId() == userId) {
                dealTables.setEndDate(new Date());
                dealTablesMapper.updateByPrimaryKeySelective(dealTables);
                return true;

            } else {
                throw new RuntimeException();
            }

        } else {
            throw new RuntimeException();
        }


    }


}
