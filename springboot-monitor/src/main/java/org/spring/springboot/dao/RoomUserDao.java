package org.spring.springboot.dao;

import org.apache.ibatis.annotations.Param;
import org.spring.springboot.entity.UserInfo;

import java.util.List;

public interface RoomUserDao {
    List<UserInfo> findRoomUserById(@Param("roomId") String roomId);
}
