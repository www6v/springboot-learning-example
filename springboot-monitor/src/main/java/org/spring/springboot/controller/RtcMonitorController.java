package org.spring.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.springboot.domain.RoomStatus;
import org.spring.springboot.service.RoomStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//import org.spring.springboot.domain1.RtcClinetLog;

@RestController
public class RtcMonitorController {

    Logger logger=  LoggerFactory.getLogger(RtcMonitorController.class);

//    @Autowired
//    private CityService cityService;
    @Autowired
    private RoomStatusService roomStatusService;

//    @RequestMapping(value = "/api/city/{id}", method = RequestMethod.GET)
//    public City findOneCity(@PathVariable("id") Long id) {
//        return cityService.findCityById(id);
//    }

    @ResponseBody
    @RequestMapping(value = "/api/roomStatus/{roomId}", method = RequestMethod.GET)
    public RoomStatus findRoomStatus(@PathVariable("roomId") String roomId) {
        return roomStatusService.findRoomStatusById(roomId);
    }


//    @ResponseBody
//    @RequestMapping(value = "/api/rtcClinetLog", method = RequestMethod.POST)
//    public RtcClinetLog createRtcClinetLog(@RequestBody RtcClinetLog rtcClinetLog) {
//        try {
//            String jsonString = JSON.toJSONString(rtcClinetLog,
//                    SerializerFeature.WriteNullStringAsEmpty);
////            String path = "D:\\temp\\appendFile.txt"; // windows
//            String path = "/home/urtc/data/appendFile.log"; // linux
//            File file = new File(path);
//            Files.asCharSink(file, Charsets.UTF_8, FileWriteMode.APPEND).write(jsonString + "\n");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return rtcClinetLog;
//    }
}
