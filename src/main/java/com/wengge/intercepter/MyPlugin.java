package com.wengge.intercepter;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.util.Properties;

@Intercepts({
        @Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class}),
        @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class})})
public class MyPlugin implements Interceptor {
    private Properties prop;

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        System.err.println("====before====" + invocation.getTarget());
        Object obj = invocation.proceed();
        System.err.println("====after====" + invocation.getTarget());
        return obj;
    }

    @Override
    public Object plugin(Object target) {
        System.err.println("====调用生成代理对象====target:" + target);
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
        System.err.println("====属性值====properties:"+properties.toString());
        this.prop = properties;
    }

}