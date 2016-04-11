package com.eboji.persist.dao;

import com.eboji.persist.pojo.GcRatioCoin;
import com.eboji.persist.pojo.GcRatioCoinExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GcRatioCoinMapper {
    int countByExample(GcRatioCoinExample example);

    int deleteByExample(GcRatioCoinExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GcRatioCoin record);

    int insertSelective(GcRatioCoin record);

    List<GcRatioCoin> selectByExample(GcRatioCoinExample example);

    GcRatioCoin selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GcRatioCoin record, @Param("example") GcRatioCoinExample example);

    int updateByExample(@Param("record") GcRatioCoin record, @Param("example") GcRatioCoinExample example);

    int updateByPrimaryKeySelective(GcRatioCoin record);

    int updateByPrimaryKey(GcRatioCoin record);
}