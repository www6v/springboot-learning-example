package org.spring.springboot.service.impl;

import org.spring.springboot.dao.RoomUserDao;
import org.spring.springboot.domain.UserInfo;
import org.spring.springboot.service.RoomUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RomUserServiceImpl implements RoomUserService {
    @Autowired
    private RoomUserDao roomUserDao;

    @Override
    public List<UserInfo> findRoomUsersById(String roomId) {
        return roomUserDao.findRoomUserById(roomId);
    }
}
