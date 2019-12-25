package com.learn.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.learn.commons.utils.SessionUtils;
import com.learn.mapper.CollectionsMapper;
import com.learn.mapper.MessagesMapper;
import com.learn.mapper.PublishGoodsMapper;
import com.learn.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("list")
public class ListController {

    @Autowired
    PublishGoodsMapper publishGoodsMapper;
    @Autowired
    MessagesMapper messagesMapper;
    @Autowired
    CollectionsMapper collectionsMapper;

    /**
     * 跳转到详情页面（detail.jsp）
     *
     * @param id 已发布商品的id
     * @return
     */
    @RequestMapping("todetail")
    public String todetail(Integer id, Model model, HttpServletRequest request) {
        //
        PublishGoods publishGoods = publishGoodsMapper.selectByPrimaryKey((long) id);
        //
        MessagesExample messagesExample = new MessagesExample();
        MessagesExample.Criteria messagesExampleCriteria = messagesExample.createCriteria();
        messagesExampleCriteria.andPublishIdEqualTo((long)id);
        //
        List<Messages> messages = messagesMapper.selectByExample(messagesExample);
        //
        CollectionsExample collectionsExample=new CollectionsExample();
        CollectionsExample.Criteria criteria = collectionsExample.createCriteria();
        criteria.andPublishIdEqualTo(publishGoods.getId());
        criteria.andIsexpireEqualTo(false);

        //
        UserInfo userInfo = SessionUtils.getUserInfo(request);

        criteria.andUserIdEqualTo(userInfo.getId());

        List<Collections> collections = collectionsMapper.selectByExample(collectionsExample);

        model.addAttribute("collections", collections);


        model.addAttribute("publishGoods", publishGoods);
        model.addAttribute("messages", messages);


        return "detail";
    }


    /**
     * @param page 第几页
     * @param type 商品类型
     * @return
     */
    @RequestMapping("page")
    public String pageNumber(Integer page, Integer type, Model model) {

        /*   重复利用 IndexListController -> tolist */
        PageInfo<PublishGoods> pageInfo = PageHelper.startPage(page, 8).
                doSelectPageInfo(
                        () -> {
                            PublishGoodsExample goodsExample = new PublishGoodsExample();
                            if (type != null) {
                                PublishGoodsExample.Criteria criteria = goodsExample.createCriteria();
                                criteria.andGoodsTypeEqualTo(type);
                            }

                            publishGoodsMapper.selectByExample(goodsExample);

                        }
                );
        model.addAttribute("type", type);
        model.addAttribute("pageInfo", pageInfo);


        return "list";
    }







}
