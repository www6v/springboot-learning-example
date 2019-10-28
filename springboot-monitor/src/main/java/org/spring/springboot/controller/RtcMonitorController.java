package org.spring.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.springboot.domain.RoomReq;
import org.spring.springboot.entity.*;
import org.spring.springboot.service.RoomService;
import org.spring.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class RtcMonitorController {

    Logger logger=  LoggerFactory.getLogger(RtcMonitorController.class);

    @Autowired
    private RoomService roomService;
    @Autowired
    private UserService userService;

    // romom的状态 1.1 单个
    @Deprecated
    @ResponseBody
    @RequestMapping(value = "/api/roomStatus/{appId}/{roomId}", method = RequestMethod.GET)
    public RoomStatus findRoomStatus(@PathVariable("appId") String appId,
                                     @PathVariable("roomId") String roomId) {
        return roomService.findRoomStatusById(appId, roomId);
    }

    /// romom的状态 1.2 批量
    @PostMapping("/api/roomsStatus")
    public List<RoomStatus> findStatusOfRooms(@RequestBody RoomReq req) {
        String appId = req.getAppId();
        List<String> roomIds = req.getRoomIds();

        List<RoomStatus> roomStatusList = new ArrayList<>();

        for(int i =0; i< roomIds.size(); i++) {
            String rid = roomIds.get(i);
            RoomStatus roomStatus = roomService.findRoomStatusById(appId, rid);

            if(roomStatus == null)  continue;

            roomStatusList.add(roomStatus);
        }

        return roomStatusList;
    }

    /// 2.1 room中用户接入的设备
    @ResponseBody
    @RequestMapping(value = "/api/roomUsers/{appId}/{roomId}", method = RequestMethod.GET)
    public Map<String, List<UserDetail>> findRoomUsers(@PathVariable("appId") String appId,
                                                       @PathVariable("roomId") String roomId,
                                                       @RequestParam("startTime") Long startTime,
                                                       @RequestParam("endTime") Long endTime) {
        HashMap<String, List<UserDetail>> userMap = new HashMap<>();
        List<UserDetail> roomUsersList = userService.findRoomUsersById(appId, roomId, startTime, endTime);

        Iterator<UserDetail> iterator = roomUsersList.iterator();
        while(iterator.hasNext()) {
            UserDetail user = iterator.next();
            String concurentUserId = user.getUserId();

            List<UserDetail> userInfosList = userMap.get(concurentUserId);
            if(userInfosList == null) {
                userInfosList = new ArrayList<>();
                userInfosList.add(user);
            }
            else {
                userInfosList.add(user);
            }
            userMap.put(concurentUserId, userInfosList);
        }

        return userMap;
    }

    /// 2.2 用户使用时间
    @ResponseBody
    @RequestMapping(value = "/api/roomUsers/{appId}/{roomId}/{userId}", method = RequestMethod.GET)
    public List<UserInfo> findRoomUsers(@PathVariable("appId") String appId,
                                        @PathVariable("roomId") String roomId,
                                        @PathVariable("userId") String userId,

                                        @RequestParam("startTime") Long startTime,
                                        @RequestParam("endTime") Long endTime) {
        List<UserInfo> userInfoList = userService.findUserInfoById(roomId, userId, startTime, endTime);

        return userInfoList;
    }

    @ResponseBody
    @RequestMapping(value = "/api/userOperation/{appId}/{roomId}/{userId}", method = RequestMethod.GET)
    public List<Operation>  getUserOperation(@PathVariable String roomId,
                                             @PathVariable String userId,

                                             @RequestParam("startTime") Long startTime,
                                             @RequestParam("endTime") Long endTime) {
        return userService.getUserOperation(roomId, userId, startTime, endTime);
    }

    @ResponseBody
    @RequestMapping(value = "/api/userException/{appId}/{roomId}/{userId}", method = RequestMethod.GET)
    public List<ExceptionPO>  getUserException(@PathVariable String roomId,
                                               @PathVariable String userId,

                                               @RequestParam("startTime") Long startTime,
                                               @RequestParam("endTime") Long endTime) {
        return userService.getUserException(roomId, userId, startTime, endTime);
    }
}
