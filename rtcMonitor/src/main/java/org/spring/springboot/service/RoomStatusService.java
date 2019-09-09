package org.spring.springboot.service;

import org.spring.springboot.domain.RoomStatus;

public interface RoomStatusService {
    RoomStatus findRoomStatusById(String roomId);
}
