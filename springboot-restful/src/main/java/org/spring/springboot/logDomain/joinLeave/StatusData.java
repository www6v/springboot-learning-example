package org.spring.springboot.logDomain.joinLeave;

import org.spring.springboot.logDomain.status.Audio;
import org.spring.springboot.logDomain.status.Video;

import javax.validation.constraints.NotNull;

public class StatusData {
    @NotNull(message = "不能为空")
    private Integer rtt; ///: int ms, //pub 有效
    @NotNull(message = "不能为空")
    private Integer delay; ///:int, //sub 有效

    @NotNull(message = "不能为空")
    private Integer cpu;
    @NotNull(message = "不能为空")
    private Integer memory;

    @NotNull(message = "不能为空")
    private String userid;
    @NotNull(message = "不能为空")
    private String streamid;

    private Audio audio;
    private Video video;

    public Integer getRtt() {
        return rtt;
    }

    public void setRtt(Integer rtt) {
        this.rtt = rtt;
    }

    public Integer getDelay() {
        return delay;
    }

    public void setDelay(Integer delay) {
        this.delay = delay;
    }

    public Audio getAudio() {
        return audio;
    }

    public void setAudio(Audio audio) {
        this.audio = audio;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public Integer getCpu() {
        return cpu;
    }
    public void setCpu(Integer cpu) {
        this.cpu = cpu;
    }

    public Integer getMemory() {
        return memory;
    }
    public void setMemory(Integer memory) {
        this.memory = memory;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getStreamid() {
        return streamid;
    }

    public void setStreamid(String streamid) {
        this.streamid = streamid;
    }
}
