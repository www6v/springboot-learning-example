package org.spring.springboot.logDomain.exception;

import org.spring.springboot.logDomain.joinLeave.Head;

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






//{
//        "version": "1.0",
//        "method": "xxx",
//        "rpc_id": "xxx",
//        "type": 4,  /// 异常
//        "ts": 22222233232,
//        "mtype": 1,
//        "aid": "xxx",
//        "rid": "xxx",
//        "uid": "xxx",
//        "sid": "xxx",
//        "streamid": "xxx",
//        "stype": 5,
//        "data": {
//
//        }
//        }
