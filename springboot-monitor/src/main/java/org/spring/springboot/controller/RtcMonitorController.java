package org.spring.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.springboot.domain.RoomReq;
import org.spring.springboot.entity.Operation;
import org.spring.springboot.entity.RoomStatus;
import org.spring.springboot.entity.UserInfo;
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
    @RequestMapping(value = "/api/roomStatus/{roomId}", method = RequestMethod.GET)
    public RoomStatus findRoomStatus(@PathVariable("roomId") String roomId) {
        return roomService.findRoomStatusById(roomId);
    }

    @ResponseBody
    @RequestMapping(value = "/api/roomUsers/{roomId}", method = RequestMethod.GET)
    public Map<String, List<UserInfo>> findRoomUsers(@PathVariable("roomId") String roomId) {
        HashMap<String, List<UserInfo>> userMap = new HashMap<>();
        List<UserInfo> roomUsersList = userService.findRoomUsersById(roomId);

        Iterator<UserInfo> iterator = roomUsersList.iterator();
        while(iterator.hasNext()) {
            UserInfo user = iterator.next();
            String concurentUserId = user.getUserId();

            List<UserInfo> userInfosList = userMap.get(concurentUserId);
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

    @PostMapping("/api/userOperation/{roomId}/{userId}")
    public List<Operation>  getUserOperation(@PathVariable String roomId, @PathVariable String userId) {
        return userService.getUserOperation(roomId, userId);
    }
}
