package org.spring.springboot.domain;

public class RtcClinetLog {

    private String method;
    private String version;
    private String rpc_id;

    private Data data;

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

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}




