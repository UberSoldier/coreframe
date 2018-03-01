package com.czf.base.annotation;

import java.lang.annotation.*;

/**
 * 类SysLog的功能描述:
 * 系统日志注解
 * @auther czf
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysLog {

	String value() default "";
}
