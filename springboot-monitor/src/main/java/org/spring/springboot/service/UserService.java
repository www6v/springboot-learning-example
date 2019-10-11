package org.spring.springboot.service;

import org.spring.springboot.entity.ExceptionPO;
import org.spring.springboot.entity.Operation;
import org.spring.springboot.entity.UserInfo;

import java.util.List;

public interface UserService {
    List<UserInfo> findRoomUsersById(String roomId);

    List<Operation> getUserOperation(String roomId, String userId);

    List<ExceptionPO> getUserException(String roomId, String userId);
}
