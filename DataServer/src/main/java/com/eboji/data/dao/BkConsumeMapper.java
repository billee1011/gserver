package com.eboji.data.dao;

import com.eboji.data.pojo.BkConsume;
import com.eboji.data.pojo.BkConsumeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BkConsumeMapper {
    int countByExample(BkConsumeExample example);

    int deleteByExample(BkConsumeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BkConsume record);

    int insertSelective(BkConsume record);

    List<BkConsume> selectByExample(BkConsumeExample example);

    BkConsume selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BkConsume record, @Param("example") BkConsumeExample example);

    int updateByExample(@Param("record") BkConsume record, @Param("example") BkConsumeExample example);

    int updateByPrimaryKeySelective(BkConsume record);

    int updateByPrimaryKey(BkConsume record);
}