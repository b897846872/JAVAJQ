package com.blog.design;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * cglib代理
 * @author qi
 *
 */
public class CglibProxyExample implements MethodInterceptor{
	
	/**
	 * 生成CGLIB代理对象
	 * @param cls
	 * @return
	 */
	public Object getProxy(Class cls) {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(cls);
		enhancer.setCallback(this);
		return enhancer.create();
	}
	
	/**
	 * 代理逻辑方法
	 */
	@Override
	public Object intercept(Object proxy, Method method, Object[] arg, MethodProxy methodProxy) throws Throwable {
		Object result = methodProxy.invokeSuper(proxy, arg);
		return result;
	}

}
