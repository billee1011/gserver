package com.eboji.data.dao;

import com.eboji.data.pojo.GGTable;
import com.eboji.data.pojo.GGTableExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GGTableMapper {
    int countByExample(GGTableExample example);

    int deleteByExample(GGTableExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GGTable record);

    int insertSelective(GGTable record);

    List<GGTable> selectByExample(GGTableExample example);

    GGTable selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GGTable record, @Param("example") GGTableExample example);

    int updateByExample(@Param("record") GGTable record, @Param("example") GGTableExample example);

    int updateByPrimaryKeySelective(GGTable record);

    int updateByPrimaryKey(GGTable record);
}