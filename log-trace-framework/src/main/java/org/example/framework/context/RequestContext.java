package org.example.framework.context;

import com.alibaba.ttl.TransmittableThreadLocal;

import java.util.HashMap;
import java.util.Map;

/**
 * @desc： 请求线程的本地上下文，每个线程只有1个
 * @author: huangxin
 * @date: 2022.04.12
 */
public class RequestContext {
    private static final ThreadLocal<Map<Object,Object>> threadRequestContext = new TransmittableThreadLocal<Map<Object,Object>>(){
        @Override
        protected Map<Object, Object> initialValue() {
            return new HashMap();
        }
        public Map<Object, Object> copy(Map<Object, Object> parentValue) {
            return parentValue != null ? new HashMap<>(parentValue) : null;
        }
    };

    public static void put(Object key,Object value){
        if(key==null){
            throw new IllegalStateException("key is null");
        }
        if(value==null){
            throw new IllegalStateException("value is null");
        }
        if(threadRequestContext.get()==null){
            threadRequestContext.set(new HashMap<Object, Object>());
        }
        threadRequestContext.get().put(key, value);
    }
    public static Object get(Object key){
        if(key==null){
            throw new IllegalStateException("key is null");
        }
        if(threadRequestContext.get()==null){
            return null;
        }
        return threadRequestContext.get().get(key);
    }
    public static <T> T get(Object key, Class<T> clazz) {
        return (T) get(key);
    }
    public static void clear(){
        threadRequestContext.remove();
    }
}
