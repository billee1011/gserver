package com.eboji.data.dao;

import com.eboji.data.pojo.GameHist;
import com.eboji.data.pojo.GameHistExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GameHistMapper {
    int countByExample(GameHistExample example);

    int deleteByExample(GameHistExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GameHist record);

    int insertSelective(GameHist record);

    List<GameHist> selectByExample(GameHistExample example);

    GameHist selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GameHist record, @Param("example") GameHistExample example);

    int updateByExample(@Param("record") GameHist record, @Param("example") GameHistExample example);

    int updateByPrimaryKeySelective(GameHist record);

    int updateByPrimaryKey(GameHist record);
}