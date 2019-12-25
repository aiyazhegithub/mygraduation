package com.learn.mapper;

import com.learn.pojo.DealTables;
import com.learn.pojo.DealTablesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DealTablesMapper {
    int countByExample(DealTablesExample example);

    int deleteByExample(DealTablesExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DealTables record);

    int insertSelective(DealTables record);

    List<DealTables> selectByExample(DealTablesExample example);

    DealTables selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DealTables record, @Param("example") DealTablesExample example);

    int updateByExample(@Param("record") DealTables record, @Param("example") DealTablesExample example);

    int updateByPrimaryKeySelective(DealTables record);

    int updateByPrimaryKey(DealTables record);


    List<DealTables> listDealsDetail(Long userId);
}