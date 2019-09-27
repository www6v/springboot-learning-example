package org.spring.springboot.logDomain.operation;

import org.spring.springboot.logDomain.joinLeave.Head;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class OpertionLog  extends Head {
    @Valid
    @NotNull(message = "不能为空")
    private OpertionData data;

    public OpertionData getData() {
        return data;
    }
    public void setData(OpertionData data) {
        this.data = data;
    }
}
