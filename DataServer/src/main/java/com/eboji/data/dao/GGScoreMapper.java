package com.eboji.data.dao;

import com.eboji.data.pojo.GGScore;
import com.eboji.data.pojo.GGScoreExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GGScoreMapper {
    int countByExample(GGScoreExample example);

    int deleteByExample(GGScoreExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GGScore record);

    int insertSelective(GGScore record);

    List<GGScore> selectByExample(GGScoreExample example);

    GGScore selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GGScore record, @Param("example") GGScoreExample example);

    int updateByExample(@Param("record") GGScore record, @Param("example") GGScoreExample example);

    int updateByPrimaryKeySelective(GGScore record);

    int updateByPrimaryKey(GGScore record);
}