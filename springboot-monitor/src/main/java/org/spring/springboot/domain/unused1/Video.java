package org.spring.springboot.domain.unused1;

/**
 * Created by www6v on 2019/7/22.
 */
public class Video {

//    private String streamid; ///: string,
    private Integer br; ///:  int bps,
    private Integer lostpre; ///: int  0 – 100,
    private Integer frt; ///: int
    private Integer w; ///: int
    private Integer h; ///: int

    private String mime; /// :string "vp8"  "vp9" "h264"

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

    public Integer getFrt() {
        return frt;
    }

    public void setFrt(Integer frt) {
        this.frt = frt;
    }

    public Integer getW() {
        return w;
    }

    public void setW(Integer w) {
        this.w = w;
    }

    public Integer getH() {
        return h;
    }

    public void setH(Integer h) {
        this.h = h;
    }

    public String getMime() {
        return mime;
    }

    public void setMime(String mime) {
        this.mime = mime;
    }
}

