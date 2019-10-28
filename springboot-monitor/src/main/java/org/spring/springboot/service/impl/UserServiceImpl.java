package org.spring.springboot.service.impl;

import org.spring.springboot.dao.RoomUserDetailDao;
import org.spring.springboot.dao.RoomUserInfoDao;
import org.spring.springboot.dao.UserExceptionDao;
import org.spring.springboot.dao.UserOperationDao;
import org.spring.springboot.entity.ExceptionPO;
import org.spring.springboot.entity.Operation;
import org.spring.springboot.entity.UserDetail;
import org.spring.springboot.entity.UserInfo;
import org.spring.springboot.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private RoomUserDetailDao roomUserDao;

    @Autowired
    private UserOperationDao userOperationDao;

    @Autowired
    private UserExceptionDao userExceptionDao;

    @Autowired
    private RoomUserInfoDao roomUserInfoDao;


//    @Override
//    public List<UserInfo> findUserInfoById(String roomId, String userId) {
//        return roomUserInfoDao.findUserInfoById(roomId,userId);
//    }

    @Override
    public List<UserInfo> findUserInfoById(String roomId, String userId, Long startTime, Long endTime) {
        return roomUserInfoDao.findUserInfoById(roomId, userId, startTime, endTime);
    }

    @Override
    public List<UserDetail> findRoomUsersById(String appId, String roomId, Long startTime, Long endTime) {
        return roomUserDao.findRoomUserById(appId, roomId, startTime, endTime);
    }

    @Override
    public List<Operation> getUserOperation(String roomId, String userId, Long startTime, Long endTime) {
        return userOperationDao.getUserOperation(roomId, userId, startTime, endTime);
    }

    @Override
    public List<ExceptionPO> getUserException(String roomId, String userId, Long startTime, Long endTime) {
        return userExceptionDao.getUserException(roomId, userId, startTime, endTime );
    }

//    @Override
//    public List<UserDetail> findRoomUsersById(String roomId) {
//        return roomUserDao.findRoomUserById(roomId);
//    }

//    @Override
//    public List<Operation> getUserOperation(String roomId,String userId) {
//        return userOperationDao.getUserOperation(roomId, userId);
//    }

    //    @Override
//    public List<ExceptionPO> getUserException(String roomId, String userId) {
//        return userExceptionDao.getUserException(roomId, userId);
//    }
}
