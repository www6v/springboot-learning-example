package org.spring.springboot.dao;

import org.apache.ibatis.annotations.Param;
import org.spring.springboot.domain.RoomStatus;

public interface RoomStatusDao {
    RoomStatus findRoomStatusById(@Param("roomId") String roomId);
}
