package org.spring.springboot.dao;

import org.apache.ibatis.annotations.Param;
import org.spring.springboot.domain.RoomStatus;

public interface RoomStatusDao {

    RoomStatus findRoomStatusById(@Param("roomId") String roomId);

//    List<City> findAllCity();
//
//
//    City findById(@Param("id") Long id);
//
//    Long saveCity(City city);
//
//    Long updateCity(City city);
//
//    Long deleteCity(Long id);
}
