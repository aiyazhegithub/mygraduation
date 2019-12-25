package com.learn.service.impl;

import com.learn.commons.tool.TotalData;
import com.learn.mapper.CollectionsMapper;
import com.learn.mapper.UserInfoMapper;
import com.learn.pojo.Collections;
import com.learn.pojo.CollectionsExample;
import com.learn.pojo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CollectionsSeriviceImpl {

    @Autowired
    CollectionsMapper collectionsMapper;

    @Transactional
    public TotalData addCollection(Collections collections) {

        collectionsMapper.insertSelective(collections);
        TotalData totalData = new TotalData("SUCCESS");
        totalData.setData(collections.getId());

        return totalData;
    }

    public TotalData delCollection(int id) {

        int i = collectionsMapper.deleteByPrimaryKey((long) id);

        TotalData totalData = new TotalData("SUCCESS");
        totalData.setData(i);

        return totalData;
    }


    public List<Collections> listUserCollections(Long userId) {

        List<Collections> collections = collectionsMapper.listUserCollections(userId);
        return collections;

    }


}
