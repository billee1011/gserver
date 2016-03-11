package com.eboji.data.dao;

import com.eboji.data.pojo.GameScore;
import com.eboji.data.pojo.GameScoreExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GameScoreMapper {
    int countByExample(GameScoreExample example);

    int deleteByExample(GameScoreExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GameScore record);

    int insertSelective(GameScore record);

    List<GameScore> selectByExample(GameScoreExample example);

    GameScore selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GameScore record, @Param("example") GameScoreExample example);

    int updateByExample(@Param("record") GameScore record, @Param("example") GameScoreExample example);

    int updateByPrimaryKeySelective(GameScore record);

    int updateByPrimaryKey(GameScore record);
}