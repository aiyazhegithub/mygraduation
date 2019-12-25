package com.learn.service.impl;

import com.learn.mapper.PublishGoodsMapper;
import com.learn.pojo.PublishGoods;
import com.learn.pojo.PublishGoodsExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class PublishGoodsServiceImpl {


    @Autowired
    PublishGoodsMapper publishGoodsMapper;

    /**
     * 列出已经发布的商品并排数
     */
    public List<PublishGoods> listOderByDESC(PublishGoods record){

        List<PublishGoods> publishGoods = publishGoodsMapper.listOderByDESC(record);

        return publishGoods;
    }


    public List<PublishGoods> listUserPublish(Long userId){

        PublishGoodsExample goodsExample=new PublishGoodsExample();
        PublishGoodsExample.Criteria criteria = goodsExample.createCriteria();
        criteria.andUserIdEqualTo(userId);

        return publishGoodsMapper.selectByExample(goodsExample);
    }








}
