package org.spring.springboot.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Charsets;
import com.google.common.io.FileWriteMode;
import com.google.common.io.Files;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.springboot.logDomain.exception.ExceptionLog;
import org.spring.springboot.logDomain.joinLeave.RtcInitOrLeaveLog;
import org.spring.springboot.logDomain.operation.OpertionLog;
import org.spring.springboot.logDomain.status.RtcStatusLog;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;

@RestController
public class RtcRestController {
    Logger logger=  LoggerFactory.getLogger(RtcRestController.class);

    public static final String STATUS_LOG_PATH = "/home/urtc/data/appendFile.log";
    public static final String JOIN_LEAVE_LOG_PATH = "/home/urtc/data/appendFileJoinLeave.log";
    public static final String OPERATION_LOG_PATH = "/home/urtc/data/appendFileOpertionLog.log";
    public static final String EXCEPTION_LOG_PATH = "/home/urtc/data/appendFileExceptionLog.log";

    @ResponseBody
    @RequestMapping(value = "/api/exceptionLog", method = RequestMethod.POST)
    public String createExceptionLog(@RequestBody @Valid ExceptionLog exceptionLog,
                                    BindingResult bindingResult) {
        if (errorHandle(bindingResult))
            return "Input json is not valid.";

        return persistJsonToFile(exceptionLog, EXCEPTION_LOG_PATH);
    }

    @ResponseBody
    @RequestMapping(value = "/api/opertionLog", method = RequestMethod.POST)
    public String createOpertionLog(@RequestBody @Valid OpertionLog opertionLog,
                                     BindingResult bindingResult) {
        if (errorHandle(bindingResult))
            return "Input json is not valid.";

        return persistJsonToFile(opertionLog, OPERATION_LOG_PATH);
    }

    //            String jsonString = JSON.toJSONString(rtcClinetLog,
    //            SerializerFeature.WriteNullStringAsEmpty);

    @ResponseBody
    @RequestMapping(value = "/api/rtcClinetLog", method = RequestMethod.POST)
    public String createRtcClientLog(@RequestBody  @Valid RtcStatusLog rtcClinetLog,
                                     BindingResult bindingResult) {
        if (errorHandle(bindingResult)) return "Input json is not valid.";
        return persistJsonToFile(rtcClinetLog, STATUS_LOG_PATH);
    }


    @ResponseBody
    @RequestMapping(value = "/api/rtcJoinLeaveClientLog", method = RequestMethod.POST)
        public String createRtcJoinLeaveClinetLog(@RequestBody @Valid RtcInitOrLeaveLog rtcJoinLeaveClientLog,
            BindingResult bindingResult) {
        if (errorHandle(bindingResult)) return "Input json is not valid.";

        return persistJsonToFile(rtcJoinLeaveClientLog, JOIN_LEAVE_LOG_PATH);
    }

    private String persistJsonToFile(Object rtcJoinLeaveClientLog, String fileName) {
        String jsonString;
        try {
            jsonString = JSON.toJSONString(rtcJoinLeaveClientLog);
            File file = new File(fileName);
            Files.asCharSink(file, Charsets.UTF_8, FileWriteMode.APPEND).write(jsonString + "\n");
        } catch (IOException e) {
            return e.toString();
        }

        return jsonString;
    }

    private boolean errorHandle(BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return true;
        }
        return false;
    }
}
