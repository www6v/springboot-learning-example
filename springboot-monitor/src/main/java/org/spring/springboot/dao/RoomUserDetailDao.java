package org.spring.springboot.dao;

import org.apache.ibatis.annotations.Param;
import org.spring.springboot.entity.UserDetail;

import java.util.List;

public interface RoomUserDetailDao {
//    List<UserDetail> findRoomUserById(@Param("roomId") String roomId);
    List<UserDetail> findRoomUserById(String appId, String roomId, Long startTime, Long endTime);
}
