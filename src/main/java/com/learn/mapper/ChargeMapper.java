package com.learn.mapper;

import com.learn.pojo.Charge;
import com.learn.pojo.ChargeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ChargeMapper {
    int countByExample(ChargeExample example);

    int deleteByExample(ChargeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Charge record);

    int insertSelective(Charge record);

    List<Charge> selectByExample(ChargeExample example);

    Charge selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Charge record, @Param("example") ChargeExample example);

    int updateByExample(@Param("record") Charge record, @Param("example") ChargeExample example);

    int updateByPrimaryKeySelective(Charge record);

    int updateByPrimaryKey(Charge record);







    //----------

    int noticeUpdate(Charge record);
}