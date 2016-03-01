package com.eboji.data.dao;

import com.eboji.data.pojo.BkAccount;
import com.eboji.data.pojo.BkAccountExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BkAccountMapper {
    int countByExample(BkAccountExample example);

    int deleteByExample(BkAccountExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BkAccount record);

    int insertSelective(BkAccount record);

    List<BkAccount> selectByExample(BkAccountExample example);

    BkAccount selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BkAccount record, @Param("example") BkAccountExample example);

    int updateByExample(@Param("record") BkAccount record, @Param("example") BkAccountExample example);

    int updateByPrimaryKeySelective(BkAccount record);

    int updateByPrimaryKey(BkAccount record);
}