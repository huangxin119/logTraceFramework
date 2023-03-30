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
@Activate(group = {CommonConstants.PROVIDER})
@Slf4j
public class ProviderFilter implements Filter {
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        String str =  RpcContext.getContext().getAttachment(RequestContextKey.REQUEST_COMMON_TRACE_ID.toString());
        RequestLogTraceVO requestLogTraceVO = new RequestLogTraceVO();
        if(StringUtils.isEmpty(str)){
            requestLogTraceVO.setTraceId(UUID.randomUUID().toString());
        }else{
            requestLogTraceVO = JSON.parseObject(str,RequestLogTraceVO.class);
        }
        RequestContext.put(RequestContextKey.REQUEST_COMMON_TRACE_ID,requestLogTraceVO);
        try {
            return invoker.invoke(invocation);
        }finally {
            RequestContext.clear();
        }

    }
}
