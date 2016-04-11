package com.eboji.persist.dao;

import com.eboji.persist.pojo.GuUser;
import com.eboji.persist.pojo.GuUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GuUserMapper {
    int countByExample(GuUserExample example);

    int deleteByExample(GuUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GuUser record);

    int insertSelective(GuUser record);

    List<GuUser> selectByExampleWithBLOBs(GuUserExample example);

    List<GuUser> selectByExample(GuUserExample example);

    GuUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GuUser record, @Param("example") GuUserExample example);

    int updateByExampleWithBLOBs(@Param("record") GuUser record, @Param("example") GuUserExample example);

    int updateByExample(@Param("record") GuUser record, @Param("example") GuUserExample example);

    int updateByPrimaryKeySelective(GuUser record);

    int updateByPrimaryKeyWithBLOBs(GuUser record);

    int updateByPrimaryKey(GuUser record);
}