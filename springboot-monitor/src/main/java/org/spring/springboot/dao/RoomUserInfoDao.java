package org.spring.springboot.dao;

import org.apache.ibatis.annotations.Param;
import org.spring.springboot.entity.UserInfo;
import java.util.List;

public interface RoomUserInfoDao {
    List<UserInfo> findUserInfoById(@Param("roomId") String roomId,
                                    @Param("userId") String userId,
                                    Long startTime,
                                    Long endTime
    );
}
