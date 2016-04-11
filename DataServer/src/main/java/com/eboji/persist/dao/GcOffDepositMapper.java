package com.eboji.persist.dao;

import com.eboji.persist.pojo.GcOffDeposit;
import com.eboji.persist.pojo.GcOffDepositExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GcOffDepositMapper {
    int countByExample(GcOffDepositExample example);

    int deleteByExample(GcOffDepositExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GcOffDeposit record);

    int insertSelective(GcOffDeposit record);

    List<GcOffDeposit> selectByExample(GcOffDepositExample example);

    GcOffDeposit selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GcOffDeposit record, @Param("example") GcOffDepositExample example);

    int updateByExample(@Param("record") GcOffDeposit record, @Param("example") GcOffDepositExample example);

    int updateByPrimaryKeySelective(GcOffDeposit record);

    int updateByPrimaryKey(GcOffDeposit record);
}