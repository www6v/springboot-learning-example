package org.spring.springboot.logDomain.exception;

import org.hibernate.validator.constraints.Range;

public class ExceptionData {
    @Range(min = 1, max = 13, message = "range在[1,13]之间")
    private int errorType;

    public int getErrorType() {
        return errorType;
    }
    public void setErrorType(int errorType) {
        this.errorType = errorType;
    }
}
