package com.eboji.persist.dao;

import com.eboji.persist.pojo.GgRoom;
import com.eboji.persist.pojo.GgRoomExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GgRoomMapper {
    int countByExample(GgRoomExample example);

    int deleteByExample(GgRoomExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GgRoom record);

    int insertSelective(GgRoom record);

    List<GgRoom> selectLockByExample(GgRoomExample example);
    
    List<GgRoom> selectByExample(GgRoomExample example);

    GgRoom selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GgRoom record, @Param("example") GgRoomExample example);

    int updateByExample(@Param("record") GgRoom record, @Param("example") GgRoomExample example);

    int updateByPrimaryKeySelective(GgRoom record);

    int updateByPrimaryKey(GgRoom record);
}