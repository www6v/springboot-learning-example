package org.spring.springboot.logDomain.exception;

import org.spring.springboot.logDomain.common.Head;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class ExceptionLog  extends Head {
    @Valid
    @NotNull(message = "不能为空")
    private ExceptionData data;

    public ExceptionData getData() {
        return data;
    }
    public void setData(ExceptionData data) {
        this.data = data;
    }
}