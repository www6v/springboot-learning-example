package org.spring.springboot.logDomain.joinLeave;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class RtcInitOrLeaveLog extends RtcParentLog {
    @Valid
    @NotNull(message = "不能为空")
    private InitData data;

    public InitData getData() {
        return data;
    }
    public void setData(InitData data) {
        this.data = data;
    }
}







