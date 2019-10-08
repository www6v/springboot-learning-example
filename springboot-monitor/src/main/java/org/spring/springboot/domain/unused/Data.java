package org.spring.springboot.domain.unused;

public class Data {

    private Integer type;
    private Long ts; ///uint32  time sec 1970
    private Integer stype; ///: 1 pub 1 sub
    private Integer mtype; ///: 1 cam 2 screen
    private Integer ttype;///: 1 n
    private String aid; ///: string
    private String rid;///: string
    private String streamid;///: string
    private String sid;///: string
    private Integer uid;///: string
    private String br; ///:  int bps
    private Integer lostpre; ///: int  0 -- 100
    private Integer rtt; ///: int ms
    private String mime; ///:string "opus"  " vp8"  " h264"
    private Integer frt;///: int
    private Integer w; ///: int
    private Integer h; ///: int
    private Integer vol;///: 0 -- 100
    private Integer delay; ///:int

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getTs() {
        return ts;
    }

    public void setTs(Long ts) {
        this.ts = ts;
    }

    public Integer getStype() {
        return stype;
    }

    public void setStype(Integer stype) {
        this.stype = stype;
    }

    public Integer getMtype() {
        return mtype;
    }

    public void setMtype(Integer mtype) {
        this.mtype = mtype;
    }

    public Integer getTtype() {
        return ttype;
    }

    public void setTtype(Integer ttype) {
        this.ttype = ttype;
    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getStreamid() {
        return streamid;
    }

    public void setStreamid(String streamid) {
        this.streamid = streamid;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getBr() {
        return br;
    }

    public void setBr(String br) {
        this.br = br;
    }

    public Integer getLostpre() {
        return lostpre;
    }

    public void setLostpre(Integer lostpre) {
        this.lostpre = lostpre;
    }

    public Integer getRtt() {
        return rtt;
    }

    public void setRtt(Integer rtt) {
        this.rtt = rtt;
    }

    public String getMime() {
        return mime;
    }

    public void setMime(String mime) {
        this.mime = mime;
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

    public Integer getVol() {
        return vol;
    }

    public void setVol(Integer vol) {
        this.vol = vol;
    }

    public Integer getDelay() {
        return delay;
    }

    public void setDelay(Integer delay) {
        this.delay = delay;
    }
}



