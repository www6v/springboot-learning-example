package org.spring.springboot.service;

import org.spring.springboot.entity.ExceptionPO;
import org.spring.springboot.entity.Operation;
import org.spring.springboot.entity.UserDetail;
import org.spring.springboot.entity.UserInfo;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface UserService {
    List<UserDetail> findRoomUsersById(String appId, String roomId, Long startTime,Long endTime);

    List<UserInfo> findUserInfoById(String appId, String roomId, String userId, Long startTime, Long endTime);

    List<Operation> getUserOperation(String appId, String roomId, String userId, Long startTime, Long endTime);

    List<ExceptionPO> getUserException(String appId, String roomId, String userId, Long startTime, Long endTime);
}
