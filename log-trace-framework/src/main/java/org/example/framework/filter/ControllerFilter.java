package org.example.framework.filter;

import org.example.framework.constrants.RequestContextKey;
import org.example.framework.context.RequestContext;
import org.example.framework.context.RequestLogTraceVO;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;
import java.util.UUID;

/**
 * @desc：
 * @author: huangxin
 * @date: 2022.04.12
 */
public class ControllerFilter implements Filter {
    /**
     * 为每个请求生成一个traceId，存入本地线程上下文中
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //生成traceId存入上下文
        System.out.println(111);
        RequestLogTraceVO requestLogTraceVO = new RequestLogTraceVO();
        String traceId = UUID.randomUUID().toString();
        requestLogTraceVO.setTraceId(traceId);
        RequestContext.put(RequestContextKey.REQUEST_COMMON_TRACE_ID,requestLogTraceVO);
        //继续执行原有逻辑
        filterChain.doFilter(servletRequest, servletResponse);
    }

    public void destroy() {
        RequestContext.clear();
    }
}
