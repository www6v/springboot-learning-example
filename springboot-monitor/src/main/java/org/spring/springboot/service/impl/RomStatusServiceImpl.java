package org.spring.springboot.service.impl;

import org.spring.springboot.dao.RoomStatusDao;
import org.spring.springboot.domain.RoomStatus;
import org.spring.springboot.service.RoomStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RomStatusServiceImpl implements RoomStatusService {

    @Autowired
    private RoomStatusDao roomStatusDao;

    @Override
    public RoomStatus findRoomStatusById(String roomId) {
        return roomStatusDao.findRoomStatusById(roomId);
    }
}
