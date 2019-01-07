package com.blog.common;

import java.lang.reflect.Method;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;

import com.blog.model.vo.SysUserVo;
import com.blog.service.SysConfigService;
import com.blog.service.SysConfigServiceImpl;

public class Common {
	
	/**
	 * 获取当前用户id
	 * @return
	 */
	public static String getCurrentUserId(){
        Session session = SecurityUtils.getSubject().getSession();
        SysUserVo sysUserVo = (SysUserVo) session.getAttribute("user");
        if (sysUserVo == null) {
        	return "1";
        }
        return sysUserVo.getId();
	}
	
	/**
	 * 获取当前登录名
	 * @return
	 */
	public static String getCurrentUserName(){
        Session session = SecurityUtils.getSubject().getSession();
        SysUserVo sysUserVo = (SysUserVo) session.getAttribute("user");
        if (sysUserVo == null) {
        	return "admin";
        }
        return sysUserVo.getLoginName();
	}
	
	public static void main(String[] args) {
//		SysConfigServiceImpl serviceImpl = null;
//		try {
//			serviceImpl = (SysConfigServiceImpl) Class
//						.forName("com.blog.service.SysConfigServiceImpl")
//						.newInstance();
//			Class class1 = serviceImpl.getClass();
//			Method method = class1.getDeclaredMethod("testReflect",String.class);
//			method.invoke(serviceImpl, "name");
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		// jdk动态代理
//		JdkProxyExample example = new JdkProxyExample();
//		SysConfigService configService = (SysConfigService) example.bind(new SysConfigServiceImpl());
//		configService.testProxy("name1");
//		
//		// cglib代理
//		CglibProxyExample cglibProxyExample = new CglibProxyExample();
//		SysConfigServiceImpl impl = (SysConfigServiceImpl) cglibProxyExample.getProxy(SysConfigServiceImpl.class);
//		impl.testProxy("name2");
	}
}
