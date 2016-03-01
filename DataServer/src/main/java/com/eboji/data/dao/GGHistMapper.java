package com.eboji.data.dao;

import com.eboji.data.pojo.GGHist;
import com.eboji.data.pojo.GGHistExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GGHistMapper {
    int countByExample(GGHistExample example);

    int deleteByExample(GGHistExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GGHist record);

    int insertSelective(GGHist record);

    List<GGHist> selectByExample(GGHistExample example);

    GGHist selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GGHist record, @Param("example") GGHistExample example);

    int updateByExample(@Param("record") GGHist record, @Param("example") GGHistExample example);

    int updateByPrimaryKeySelective(GGHist record);

    int updateByPrimaryKey(GGHist record);
}