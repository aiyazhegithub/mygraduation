package com.learn.service.impl;

import com.learn.mapper.ChargeMapper;
import com.learn.mapper.UserInfoMapper;
import com.learn.pojo.Charge;
import com.learn.pojo.ChargeExample;
import com.learn.pojo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class ChargeServiceImpl {

    @Autowired
    private ChargeMapper chargeMapper;
    @Autowired
    private UserInfoMapper userInfoMapper;


    public ChargeMapper getChargeMapper() {
        return chargeMapper;
    }


    public int createQCode(Charge charge) {

        return chargeMapper.insertSelective(charge);

    }

    @Transactional
    public boolean notice(Long chargeId) {

        Charge charge=new Charge();
        charge.setEndDate(new Date());
        ChargeExample chargeExample=new ChargeExample();
        ChargeExample.Criteria criteria = chargeExample.createCriteria();
        criteria.andEndDateIsNull();
        criteria.andIdEqualTo(chargeId);

        int i=chargeMapper.updateByExampleSelective(charge,chargeExample);

        System.out.println("sss"+i);
        if(i!=0){
            Charge charge1 = chargeMapper.selectByPrimaryKey(chargeId);
            UserInfo userInfo = new UserInfo();
            userInfo.setId(charge1.getUserId());
            userInfo.setMoney(charge1.getTotalMoney());

            int i1 = userInfoMapper.noticeUpdate(userInfo);

            System.out.println("用户更新了："+i1);


        }


        return true;
    }


}
