package com.learn.mapper;

import com.learn.pojo.Collections;
import com.learn.pojo.CollectionsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CollectionsMapper {
    int countByExample(CollectionsExample example);

    int deleteByExample(CollectionsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Collections record);

    int insertSelective(Collections record);

    List<Collections> selectByExample(CollectionsExample example);

    Collections selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Collections record, @Param("example") CollectionsExample example);

    int updateByExample(@Param("record") Collections record, @Param("example") CollectionsExample example);

    int updateByPrimaryKeySelective(Collections record);

    int updateByPrimaryKey(Collections record);

    List<Collections> listUserCollections(Long userId);
}