package org.spring.springboot.logDomain.operation;

import org.hibernate.validator.constraints.Range;

public class OpertionData {
    @Range(min = 1, max = 10, message = "range在[1,10]之间")
    private int opertionType;

    public int getOpertionType() {
        return opertionType;
    }
    public void setOpertionType(int opertionType) {
        this.opertionType = opertionType;
    }
}


