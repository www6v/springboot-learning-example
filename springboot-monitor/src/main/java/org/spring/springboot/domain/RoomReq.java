package org.spring.springboot.domain;
        ;

import java.util.List;

public class RoomReq {
    private String appId;
    private List<String> roomIds;

    public List<String> getRoomIds() {
        return roomIds;
    }
    public void setRoomIds(List<String> roomIds) {
        this.roomIds = roomIds;
    }


    public String getAppId() {
        return appId;
    }
    public void setAppId(String appId) {
        this.appId = appId;
    }
}
