package com.eboji.data.dao;

import com.eboji.data.pojo.BkRecharge;
import com.eboji.data.pojo.BkRechargeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BkRechargeMapper {
    int countByExample(BkRechargeExample example);

    int deleteByExample(BkRechargeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BkRecharge record);

    int insertSelective(BkRecharge record);

    List<BkRecharge> selectByExample(BkRechargeExample example);

    BkRecharge selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BkRecharge record, @Param("example") BkRechargeExample example);

    int updateByExample(@Param("record") BkRecharge record, @Param("example") BkRechargeExample example);

    int updateByPrimaryKeySelective(BkRecharge record);

    int updateByPrimaryKey(BkRecharge record);
}