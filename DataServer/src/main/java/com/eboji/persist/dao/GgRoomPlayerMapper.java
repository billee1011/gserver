package com.eboji.persist.dao;

import com.eboji.persist.pojo.GgRoomPlayer;
import com.eboji.persist.pojo.GgRoomPlayerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GgRoomPlayerMapper {
    int countByExample(GgRoomPlayerExample example);

    int deleteByExample(GgRoomPlayerExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GgRoomPlayer record);

    int insertSelective(GgRoomPlayer record);

    List<GgRoomPlayer> selectByExample(GgRoomPlayerExample example);

    GgRoomPlayer selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GgRoomPlayer record, @Param("example") GgRoomPlayerExample example);

    int updateByExample(@Param("record") GgRoomPlayer record, @Param("example") GgRoomPlayerExample example);

    int updateByPrimaryKeySelective(GgRoomPlayer record);

    int updateByPrimaryKey(GgRoomPlayer record);
}