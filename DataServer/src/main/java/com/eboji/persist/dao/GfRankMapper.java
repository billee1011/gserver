package com.eboji.persist.dao;

import com.eboji.persist.pojo.GfRank;
import com.eboji.persist.pojo.GfRankExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GfRankMapper {
    int countByExample(GfRankExample example);

    int deleteByExample(GfRankExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GfRank record);

    int insertSelective(GfRank record);

    List<GfRank> selectByExample(GfRankExample example);

    GfRank selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GfRank record, @Param("example") GfRankExample example);

    int updateByExample(@Param("record") GfRank record, @Param("example") GfRankExample example);

    int updateByPrimaryKeySelective(GfRank record);

    int updateByPrimaryKey(GfRank record);
}