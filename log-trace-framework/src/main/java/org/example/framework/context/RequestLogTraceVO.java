package org.example.framework.context;

import java.io.Serializable;

/**
 * @desc： 请求的日志追踪对象
 * @author: huangxin
 * @date: 2022.04.12
 */
public class RequestLogTraceVO implements Serializable {
    private String traceId;

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    @Override
    public String toString() {
        return "RequestLogTraceVO{" +
                "traceId='" + traceId + '\'' +
                '}';
    }

}
