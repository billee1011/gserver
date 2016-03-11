package com.eboji.data.dao;

import com.eboji.data.pojo.GameTable;
import com.eboji.data.pojo.GameTableExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GameTableMapper {
    int countByExample(GameTableExample example);

    int deleteByExample(GameTableExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GameTable record);

    int insertSelective(GameTable record);

    List<GameTable> selectByExample(GameTableExample example);

    GameTable selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GameTable record, @Param("example") GameTableExample example);

    int updateByExample(@Param("record") GameTable record, @Param("example") GameTableExample example);

    int updateByPrimaryKeySelective(GameTable record);

    int updateByPrimaryKey(GameTable record);
}