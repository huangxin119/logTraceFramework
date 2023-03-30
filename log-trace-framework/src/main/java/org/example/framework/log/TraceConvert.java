package org.example.framework.log;


import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;
import org.example.framework.constrants.RequestContextKey;
import org.example.framework.context.RequestContext;
import org.example.framework.context.RequestLogTraceVO;

/**
 * @desc：
 * @author: huangxin
 * @date: 2022.04.12
 */
public class TraceConvert extends ClassicConverter {
    public String convert(ILoggingEvent iLoggingEvent) {
        //从线程中取出traceId
        Object requestLogTraceVO =  RequestContext.get(RequestContextKey.REQUEST_COMMON_TRACE_ID);
        if(requestLogTraceVO==null){
            return "traceId---";
        }
        return "traceId:"+((RequestLogTraceVO)requestLogTraceVO).getTraceId();
    }
}
