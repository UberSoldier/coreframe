package com.czf.base.page;


import org.apache.ibatis.plugin.*;

import java.util.Properties;

/**
 * Mybatis - 通用分页拦截器
 */
public class PageHelper implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        return null;
    }

    @Override
    public Object plugin(Object o) {
        return null;
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
