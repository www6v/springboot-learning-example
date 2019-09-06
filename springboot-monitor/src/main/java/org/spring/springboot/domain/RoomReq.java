package org.spring.springboot.domain;

import java.util.List;

public class RoomReq {

    private List<String> roomIds;

    public List<String> getRoomIds() {
        return roomIds;
    }
    public void setRoomIds(List<String> roomIds) {
        this.roomIds = roomIds;
    }
}
