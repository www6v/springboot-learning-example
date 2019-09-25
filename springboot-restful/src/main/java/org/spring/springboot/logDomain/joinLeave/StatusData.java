package org.spring.springboot.logDomain.joinLeave;

import org.spring.springboot.logDomain.status.Audio;
import org.spring.springboot.logDomain.status.Video;

public class StatusData {

   private Integer rtt; ///: int ms, //pub 有效
   private Integer delay; ///:int, //sub 有效

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
}
