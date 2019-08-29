package org.spring.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.springboot.domain.RoomStatus;
import org.spring.springboot.domain.UserInfo;
import org.spring.springboot.service.RoomStatusService;
import org.spring.springboot.service.RoomUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class RtcMonitorController {

    Logger logger=  LoggerFactory.getLogger(RtcMonitorController.class);

    @Autowired
    private RoomStatusService roomStatusService;
    @Autowired
    private RoomUserService roomUserService;


    @ResponseBody
    @RequestMapping(value = "/api/roomStatus/{roomId}", method = RequestMethod.GET)
    public RoomStatus findRoomStatus(@PathVariable("roomId") String roomId) {
        return roomStatusService.findRoomStatusById(roomId);
    }

    @ResponseBody
    @RequestMapping(value = "/api/roomUsers/{roomId}", method = RequestMethod.GET)
    public Map<String, List<UserInfo>> findRoomUsers(@PathVariable("roomId") String roomId) {
        HashMap<String, List<UserInfo>> userMap = new HashMap<>();
        List<UserInfo> roomUsersList = roomUserService.findRoomUsersById(roomId);

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
    public List<RoomStatus> findStatusOfRooms(@RequestBody List<String> roomIds) {

        List<RoomStatus> roomStatusList = new ArrayList<>();

        for(int i =0; i< roomIds.size(); i++) {
            String rid = roomIds.get(i);
            RoomStatus roomStatus = roomStatusService.findRoomStatusById(rid);

            if(roomStatus == null)  continue;

            roomStatusList.add(roomStatus);
        }

        return roomStatusList;
    }
}
