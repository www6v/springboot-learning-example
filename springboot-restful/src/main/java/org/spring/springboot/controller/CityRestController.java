package org.spring.springboot.controller;

import com.google.common.base.Charsets;
import com.google.common.io.FileWriteMode;
import com.google.common.io.Files;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.springboot.domain.City;
import org.spring.springboot.domain.RtcClinetLog;
import org.spring.springboot.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * 城市 Controller 实现 Restful HTTP 服务
 * <p>
 * Created by bysocket on 07/02/2017.
 */
@RestController
public class CityRestController {

    Logger logger=  LoggerFactory.getLogger(CityRestController.class);

    @Autowired
    private CityService cityService;

    @RequestMapping(value = "/api/city/{id}", method = RequestMethod.GET)
    public City findOneCity(@PathVariable("id") Long id) {
        return cityService.findCityById(id);
    }

    @RequestMapping(value = "/api/city", method = RequestMethod.GET)
    public List<City> findAllCity() {
        return cityService.findAllCity();
    }

    @RequestMapping(value = "/api/city", method = RequestMethod.POST)
    public void createCity(@RequestBody City city) {
        cityService.saveCity(city);
    }

    @RequestMapping(value = "/api/city", method = RequestMethod.PUT)
    public void modifyCity(@RequestBody City city) {
        cityService.updateCity(city);
    }

    @RequestMapping(value = "/api/city/{id}", method = RequestMethod.DELETE)
    public void modifyCity(@PathVariable("id") Long id) {
        cityService.deleteCity(id);
    }

    @ResponseBody
    @RequestMapping(value = "/api/rtcClinetLog", method = RequestMethod.POST)
    public RtcClinetLog createRtcClinetLog(@RequestBody RtcClinetLog rtcClinetLog) {
        try {
//            System.out.println(rtcClinetLog.getMethod());
//            System.out.println(rtcClinetLog.getRpc_id());
//            System.out.println(rtcClinetLog.getVersion());
//
//            System.out.println(rtcClinetLog.getData().getType());
//            System.out.println(rtcClinetLog.getData().getAid());

            String jsonString = JSON.toJSONString(rtcClinetLog, SerializerFeature.PrettyFormat,
                    SerializerFeature.WriteNullStringAsEmpty, SerializerFeature.UseSingleQuotes);

            logger.debug(jsonString);

            String path = "D:\\temp\\appendFile.txt";
            File file = new File(path);
            Files.asCharSink(file, Charsets.UTF_8, FileWriteMode.APPEND).write(jsonString + "\n");

//            String read2 = Files.asCharSource(file, Charsets.UTF_8).read();
//            System.out.println("读取: " + read2);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return rtcClinetLog;
    }
}
