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

    @Deprecated
    @ResponseBody
    @RequestMapping(value = "/api/roomStatus/{appId}/{roomId}", method = RequestMethod.GET)
    public RoomStatus findRoomStatus(@PathVariable("roomId") String roomId) {
        return roomService.findRoomStatusById(roomId);
    }

    @PostMapping("/api/roomsStatus")
    public List<RoomStatus> findStatusOfRooms(@RequestBody RoomReq req) {
        List<String> roomIds = req.getRoomIds();

        List<RoomStatus> roomStatusList = new ArrayList<>();

        for(int i =0; i< roomIds.size(); i++) {
            String rid = roomIds.get(i);
            RoomStatus roomStatus = roomService.findRoomStatusById(rid);

            if(roomStatus == null)  continue;

            roomStatusList.add(roomStatus);
        }

        return roomStatusList;
    }

    /// 用戶信息
    @ResponseBody
    @RequestMapping(value = "/api/roomUsers/{appId}/{roomId}", method = RequestMethod.GET)
    public Map<String, List<UserDetail>> findRoomUsers(@PathVariable("appId") String appId,
                                                       @PathVariable("roomId") String roomId) {
        HashMap<String, List<UserDetail>> userMap = new HashMap<>();
        List<UserDetail> roomUsersList = userService.findRoomUsersById(roomId);

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


    @ResponseBody
    @RequestMapping(value = "/api/roomUsers/{appId}/{roomId}/{userId}", method = RequestMethod.GET)
    public List<UserInfo> findRoomUsers(@PathVariable("appId") String appId,
                                                     @PathVariable("roomId") String roomId,
                                                     @PathVariable("userId") String userId) {

        List<UserInfo> userInfoList = userService.findUserInfoById(roomId, userId);
        return userInfoList;
    }

    @ResponseBody
    @RequestMapping(value = "/api/userOperation/{appId}/{roomId}/{userId}", method = RequestMethod.GET)
    public List<Operation>  getUserOperation(@PathVariable String roomId, @PathVariable String userId) {
        return userService.getUserOperation(roomId, userId);
    }

    @ResponseBody
    @RequestMapping(value = "/api/userException/{appId}/{roomId}/{userId}", method = RequestMethod.GET)
    public List<ExceptionPO>  getUserException(@PathVariable String roomId, @PathVariable String userId) {
        return userService.getUserException(roomId, userId);
    }
}
