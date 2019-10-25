package org.spring.springboot.dao;

import org.spring.springboot.entity.RoomStatus;

public interface RoomStatusDao {
    RoomStatus findRoomStatusById(String appId, String roomId);
}
