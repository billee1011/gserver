package com.eboji.persist.dao;

import com.eboji.persist.pojo.GfReward;
import com.eboji.persist.pojo.GfRewardExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GfRewardMapper {
    int countByExample(GfRewardExample example);

    int deleteByExample(GfRewardExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GfReward record);

    int insertSelective(GfReward record);

    List<GfReward> selectByExample(GfRewardExample example);

    GfReward selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GfReward record, @Param("example") GfRewardExample example);

    int updateByExample(@Param("record") GfReward record, @Param("example") GfRewardExample example);

    int updateByPrimaryKeySelective(GfReward record);

    int updateByPrimaryKey(GfReward record);
}