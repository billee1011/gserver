package com.eboji.persist.dao;

import com.eboji.persist.pojo.GuLogin;
import com.eboji.persist.pojo.GuLoginExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GuLoginMapper {
    int countByExample(GuLoginExample example);

    int deleteByExample(GuLoginExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GuLogin record);

    int insertSelective(GuLogin record);

    List<GuLogin> selectByExample(GuLoginExample example);

    GuLogin selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GuLogin record, @Param("example") GuLoginExample example);

    int updateByExample(@Param("record") GuLogin record, @Param("example") GuLoginExample example);

    int updateByPrimaryKeySelective(GuLogin record);

    int updateByPrimaryKey(GuLogin record);
}