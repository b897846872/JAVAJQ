package com.demo.design;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理绑定和代理逻辑
 * @author qi
 */
public class JdkProxyExample implements InvocationHandler{
	private Object target; // 真实对象
	
	/**
	 * 建立代理对象和真实对象的代理关系，并返回代理对象
	 * @param target
	 * @return
	 */
	public Object bind(Object target) {
		Object obj = Proxy.newProxyInstance(target.getClass().getClassLoader(),
				target.getClass().getInterfaces(), this);
		return obj;
	}
	
	/**
	 * 代理方法逻辑
	 * @throws ClassNotFoundException 
	 * @throws InstantiationException 
	 */
	public Object invoke(Object proxy, Method method, Object[] args) throws InstantiationException, ClassNotFoundException {
		Object obj = null;
		try {
			obj = method.invoke(target, args);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return obj;
	}
}
