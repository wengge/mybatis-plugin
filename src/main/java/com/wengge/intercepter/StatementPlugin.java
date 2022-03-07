package com.wengge.intercepter;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.util.Properties;

@Intercepts(@Signature(
        type = StatementHandler.class,
        method = "prepare",
        args = {Connection.class, Integer.class}))
public class StatementPlugin implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        StatementHandler statementHandler = (StatementHandler)invocation.getTarget();
        MetaObject metaObject = SystemMetaObject.forObject(statementHandler);
        MappedStatement mappedStatement = (MappedStatement) metaObject.getValue("delegate.mappedStatement");
        BoundSql boundSql = statementHandler.getBoundSql();
        SqlCommandType sqlCommandType = mappedStatement.getSqlCommandType();
        System.err.println("方法执行前");
        if (SqlCommandType.SELECT.equals(sqlCommandType)){
            String sql = boundSql.getSql();
            System.err.println("sql before:"+ sql);
            sql = sql+" limit 3";
            System.err.println("sql after:"+ sql);
            Field sqlField = boundSql.getClass().getDeclaredField("sql");
            sqlField.setAccessible(true);
            sqlField.set(boundSql,sql);
        }
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object o) {
        return Plugin.wrap(o,this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}