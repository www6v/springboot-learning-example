package org.spring.springboot.logDomain.joinLeave;

import javax.validation.constraints.NotNull;

/**
 * Created by www6v on 2019/8/15.
 */
public class Head {
    @NotNull(message = "不能为空")
    public String method; ///: "logup",
    @NotNull(message = "不能为空")
    public String version; ///: 1.0,
    @NotNull(message = "不能为空")
    public String rpc_id; ///: xxxx,
    @NotNull(message = "不能为空")
    public Integer mtype; ///: 1 cam 2 screen,
    @NotNull(message = "不能为空")
    public Integer type; /// log分类 取值 1 2 3, 1 通话开始 2 通话状态 3 通话结束
    @NotNull(message = "不能为空")
    public Integer stype; ///: 1 pub 1 sub,
    @NotNull(message = "不能为空")
    public Long ts; ///:uint32 time sec 1970,
    @NotNull(message = "不能为空")
    public String aid; ///: string,
    @NotNull(message = "不能为空")
    public String rid; ///: string,
    @NotNull(message = "不能为空")
    public String sid; ///: string,
    @NotNull(message = "不能为空")
    public String uid;  ///: string
    @NotNull(message = "不能为空")
    public String streamid; ///: string,


    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getRpc_id() {
        return rpc_id;
    }

    public void setRpc_id(String rpc_id) {
        this.rpc_id = rpc_id;
    }

    public Integer getMtype() {
        return mtype;
    }

    public void setMtype(Integer mtype) {
        this.mtype = mtype;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStype() {
        return stype;
    }

    public void setStype(Integer stype) {
        this.stype = stype;
    }

    public Long getTs() {
        return ts;
    }

    public void setTs(Long ts) {
        this.ts = ts;
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

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getStreamid() {
        return streamid;
    }

    public void setStreamid(String streamid) {
        this.streamid = streamid;
    }
}
