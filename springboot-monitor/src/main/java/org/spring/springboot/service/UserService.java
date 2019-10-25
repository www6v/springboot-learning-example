package org.spring.springboot.service;

import org.spring.springboot.entity.ExceptionPO;
import org.spring.springboot.entity.Operation;
import org.spring.springboot.entity.UserDetail;
import org.spring.springboot.entity.UserInfo;

import java.util.List;

public interface UserService {
    List<UserInfo> findUserInfoById(String roomId, String userId);

    List<UserDetail> findRoomUsersById(String appId, String roomId, Long startTime,Long endTime);

    List<Operation> getUserOperation(String roomId, String userId);

    List<ExceptionPO> getUserException(String roomId, String userId);
}
