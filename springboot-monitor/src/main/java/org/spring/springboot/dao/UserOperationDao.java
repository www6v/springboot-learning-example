package org.spring.springboot.dao;

import org.spring.springboot.entity.Operation;
import java.util.List;

public interface UserOperationDao {
    List<Operation> getUserOperation(String appId, String roomId, String userId, Long startTime, Long endTime);
}
