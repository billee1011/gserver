package com.eboji.persist.dao;

import com.eboji.persist.pojo.GgHist;
import com.eboji.persist.pojo.GgHistExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GgHistMapper {
    int countByExample(GgHistExample example);

    int deleteByExample(GgHistExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GgHist record);

    int insertSelective(GgHist record);

    List<GgHist> selectByExample(GgHistExample example);

    GgHist selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GgHist record, @Param("example") GgHistExample example);

    int updateByExample(@Param("record") GgHist record, @Param("example") GgHistExample example);

    int updateByPrimaryKeySelective(GgHist record);

    int updateByPrimaryKey(GgHist record);
}