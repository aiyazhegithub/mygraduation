package com.learn.mapper;

import com.learn.pojo.PublishGoods;
import com.learn.pojo.PublishGoodsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PublishGoodsMapper {
    int countByExample(PublishGoodsExample example);

    int deleteByExample(PublishGoodsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PublishGoods record);

    int insertSelective(PublishGoods record);

    List<PublishGoods> selectByExample(PublishGoodsExample example);

    PublishGoods selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PublishGoods record, @Param("example") PublishGoodsExample example);

    int updateByExample(@Param("record") PublishGoods record, @Param("example") PublishGoodsExample example);

    int updateByPrimaryKeySelective(PublishGoods record);

    int updateByPrimaryKey(PublishGoods record);


    /*-------------------*/

    List<PublishGoods> listOderByDESC(PublishGoods record);
}