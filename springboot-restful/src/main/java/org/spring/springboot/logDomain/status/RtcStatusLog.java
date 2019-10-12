package org.spring.springboot.logDomain.status;

import org.spring.springboot.logDomain.common.Head;
import org.spring.springboot.logDomain.joinLeave.StatusData;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class RtcStatusLog extends Head implements Serializable {
    @Valid
    @NotNull(message = "不能为空")
    private StatusData data;

    public StatusData getData() {
        return data;
    }

    public void setData(StatusData data) {
        this.data = data;
    }
}







