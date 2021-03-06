package org.spring.springboot.dao;

import org.spring.springboot.entity.ExceptionPO;

import java.util.List;

public interface UserExceptionDao {
    List<ExceptionPO> getUserException(String appId, String roomId, String userId, Long startTime, Long endTime);
}
