package com.eboji.persist.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.eboji.persist.pojo.GgRoomMem;
import com.eboji.persist.pojo.GgRoomMemExample;

public interface GgRoomMemMapper {
    int countByExample(GgRoomMemExample example);

    int deleteByExample(GgRoomMemExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GgRoomMem record);

    int insertSelective(GgRoomMem record);

    List<GgRoomMem> selectByExample(GgRoomMemExample example);

    GgRoomMem selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GgRoomMem record, @Param("example") GgRoomMemExample example);

    int updateByExample(@Param("record") GgRoomMem record, @Param("example") GgRoomMemExample example);

    int updateByPrimaryKeySelective(GgRoomMem record);

    int updateByPrimaryKey(GgRoomMem record);
}