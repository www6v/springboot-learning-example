package org.spring.springboot.domain;

/**
 * Created by www6v on 2019/7/22.
 */
public class Audio {

//    private String streamid; ///: string,
    private Integer br; ///:  int bps,
    private Integer lostpre; ///: int  0 – 100,
    private Integer vol; ///: 0 – 100,
    private String mime; ///:string "opus"  " vp8"  " h264"

//    public String getStreamid() {
//        return streamid;
//    }
//
//    public void setStreamid(String streamid) {
//        this.streamid = streamid;
//    }

    public Integer getBr() {
        return br;
    }

    public void setBr(Integer br) {
        this.br = br;
    }

    public Integer getLostpre() {
        return lostpre;
    }

    public void setLostpre(Integer lostpre) {
        this.lostpre = lostpre;
    }

    public Integer getVol() {
        return vol;
    }

    public void setVol(Integer vol) {
        this.vol = vol;
    }

    public String getMime() {
        return mime;
    }

    public void setMime(String mime) {
        this.mime = mime;
    }
}
