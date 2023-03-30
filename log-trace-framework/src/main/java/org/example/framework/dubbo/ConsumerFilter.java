package org.example.framework.dubbo;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.common.constants.CommonConstants;
import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.rpc.*;
import org.example.framework.constrants.RequestContextKey;
import org.example.framework.context.RequestContext;
import org.example.framework.context.RequestLogTraceVO;
import org.springframework.util.StringUtils;

import java.util.UUID;

/**
 * @desc：
 * @author: huangxin
 * @date: 2022.04.13
 */
@Activate(group = {CommonConstants.CONSUMER})
@Slf4j
public class ConsumerFilter implements Filter {
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        RequestLogTraceVO requestLogTraceVO = RequestContext.get(RequestContextKey.REQUEST_COMMON_TRACE_ID,RequestLogTraceVO.class);
        if(requestLogTraceVO == null){
            requestLogTraceVO = new RequestLogTraceVO();
        }
        if(StringUtils.isEmpty(requestLogTraceVO.getTraceId())){
            requestLogTraceVO.setTraceId(UUID.randomUUID().toString());
        }
        log.info(RequestContextKey.REQUEST_COMMON_TRACE_ID.toString()+"----"+JSON.toJSONString(requestLogTraceVO));
        RpcContext.getContext().setAttachment(RequestContextKey.REQUEST_COMMON_TRACE_ID.toString(), JSON.toJSONString(requestLogTraceVO));
        return invoker.invoke(invocation);
    }
}
