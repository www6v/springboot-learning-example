package org.spring.springboot.dao;

import org.spring.springboot.entity.ExceptionPO;

import java.util.List;

public interface UserExceptionDao {
    List<ExceptionPO> getUserException(String roomId, String userId);
}
