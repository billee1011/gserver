package com.eboji.persist.dao;

import com.eboji.persist.pojo.GuDeposit;
import com.eboji.persist.pojo.GuDepositExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GuDepositMapper {
    int countByExample(GuDepositExample example);

    int deleteByExample(GuDepositExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GuDeposit record);

    int insertSelective(GuDeposit record);

    List<GuDeposit> selectByExample(GuDepositExample example);

    GuDeposit selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GuDeposit record, @Param("example") GuDepositExample example);

    int updateByExample(@Param("record") GuDeposit record, @Param("example") GuDepositExample example);

    int updateByPrimaryKeySelective(GuDeposit record);

    int updateByPrimaryKey(GuDeposit record);
}