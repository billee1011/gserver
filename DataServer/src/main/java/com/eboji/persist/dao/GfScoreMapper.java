package com.eboji.persist.dao;

import com.eboji.persist.pojo.GfScore;
import com.eboji.persist.pojo.GfScoreExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GfScoreMapper {
    int countByExample(GfScoreExample example);

    int deleteByExample(GfScoreExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GfScore record);

    int insertSelective(GfScore record);

    List<GfScore> selectByExample(GfScoreExample example);

    GfScore selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GfScore record, @Param("example") GfScoreExample example);

    int updateByExample(@Param("record") GfScore record, @Param("example") GfScoreExample example);

    int updateByPrimaryKeySelective(GfScore record);

    int updateByPrimaryKey(GfScore record);
}