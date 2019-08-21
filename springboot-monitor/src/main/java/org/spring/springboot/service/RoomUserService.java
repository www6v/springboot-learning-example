package org.spring.springboot.service;

import org.spring.springboot.domain.UserInfo;

import java.util.List;

public interface RoomUserService {
    List<UserInfo> findRoomUsersById(String roomId);
}
