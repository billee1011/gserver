package com.eboji.persist.dao;

import com.eboji.persist.pojo.GcRatioTax;
import com.eboji.persist.pojo.GcRatioTaxExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GcRatioTaxMapper {
    int countByExample(GcRatioTaxExample example);

    int deleteByExample(GcRatioTaxExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GcRatioTax record);

    int insertSelective(GcRatioTax record);

    List<GcRatioTax> selectByExample(GcRatioTaxExample example);

    GcRatioTax selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GcRatioTax record, @Param("example") GcRatioTaxExample example);

    int updateByExample(@Param("record") GcRatioTax record, @Param("example") GcRatioTaxExample example);

    int updateByPrimaryKeySelective(GcRatioTax record);

    int updateByPrimaryKey(GcRatioTax record);
}