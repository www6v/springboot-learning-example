package org.spring.springboot.service;

import org.spring.springboot.entity.RoomStatus;

public interface RoomService {
    RoomStatus findRoomStatusById(String roomId);
}
