package com.blog.model.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
/**
 * 自定义注解：操作日志
 * @author jiangqi
 */
public @interface OperLog {
	/**
	 * 操作模块
	 * @return
	 */
	String operateModule() default "";
}
