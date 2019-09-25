package org.spring.springboot.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Charsets;
import com.google.common.io.FileWriteMode;
import com.google.common.io.Files;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.springboot.logDomain.joinLeave.RtcInitOrLeaveLog;
import org.spring.springboot.logDomain.status.RtcStatusLog;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;

@RestController
public class RtcRestController {
    Logger logger=  LoggerFactory.getLogger(RtcRestController.class);

    @ResponseBody
    @RequestMapping(value = "/api/rtcClinetLog", method = RequestMethod.POST)
    public String createRtcClinetLog(@RequestBody RtcStatusLog rtcClinetLog) {

        String jsonString;
        try {
             jsonString = JSON.toJSONString(rtcClinetLog);

//            String jsonString = JSON.toJSONString(rtcClinetLog,
//                    SerializerFeature.WriteNullStringAsEmpty);
//            SerializerFeature.UseSingleQuotes
//            SerializerFeature.PrettyFormat,

//            String path = "D:\\temp\\appendFile.txt"; // windows
            String path = "/home/urtc/data/appendFile.log"; // linux
            File file = new File(path);
            Files.asCharSink(file, Charsets.UTF_8, FileWriteMode.APPEND).write(jsonString + "\n");

        } catch (IOException e) {
            return e.getMessage();
        }

        return jsonString;
    }


    @ResponseBody
    @RequestMapping(value = "/api/rtcJoinLeaveClientLog", method = RequestMethod.POST)
//    public String createRtcJoinLeaveClinetLog(@RequestBody String rtcJoinLeaveClientLog) {
        public String createRtcJoinLeaveClinetLog(@RequestBody RtcInitOrLeaveLog rtcJoinLeaveClientLog) {

        String jsonString;
        try {
            jsonString = JSON.toJSONString(rtcJoinLeaveClientLog);

//            String path = "D:\\temp\\appendFile.txt"; // windows
            String path = "/home/urtc/data/appendFileJoinLeave.log"; // linux
            File file = new File(path);
            Files.asCharSink(file, Charsets.UTF_8, FileWriteMode.APPEND).write(jsonString + "\n");
        } catch (IOException e) {
            return e.toString();
        }

        return jsonString;
    }
}
