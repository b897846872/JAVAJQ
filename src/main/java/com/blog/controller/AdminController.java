package com.blog.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blog.common.Common;
import com.blog.common.ResponseResultUtil;
import com.blog.model.ResponseResult;
import com.blog.model.po.SysUserPo;
import com.blog.model.vo.SysUserVo;
import com.blog.service.SysUserService;




/**
 * @Description: 用户登陆权限认证管理控制器
 */
@RestController
public class AdminController {

	private static Logger logger = LoggerFactory.getLogger(AdminController.class);
	@Autowired
	SysUserService sysUserService;

	// 登陆验证，这里方便url测试，正式上线需要使用POST方式提交
	@PostMapping("index")
	@SuppressWarnings("rawtypes")
	public ResponseResult index(@RequestBody SysUserVo user) {
		if (user.getLoginName() != null && user.getPassword() != null) {
			UsernamePasswordToken token = new UsernamePasswordToken(user.getLoginName(), user.getPassword(), "login");
			Subject currentUser = SecurityUtils.getSubject();
			logger.info("对用户[" + user.getLoginName() + "]进行登录验证..验证开始");
			try {
				currentUser.login(token);
				// 验证是否登录成功
				if (currentUser.isAuthenticated()) {
					logger.info("用户[" + user.getLoginName() + "]登录认证通过(这里可以进行一些认证通过后的一些系统参数初始化操作)");
					SysUserPo sysUserPo = new SysUserPo();
					sysUserPo.setId(Common.getCurrentUserId());
					sysUserService.updateSysUserToLoginTime(sysUserPo);
					return ResponseResultUtil.success(Common.getCurrentUserId());
				} else {
					token.clear();
					return ResponseResultUtil.error("用户[" + user.getLoginName() + "]登录认证失败,重新登陆");
				}
			} catch (UnknownAccountException uae) {
				logger.info("对用户[" + user.getLoginName() + "]进行登录验证..验证失败-username wasn't in the system");
				return ResponseResultUtil.error("对用户[" + user.getLoginName() + "]进行登录验证..验证失败-username wasn't in the system");
			} catch (IncorrectCredentialsException ice) {
				logger.info("对用户[" + user.getLoginName() + "]进行登录验证..验证失败-password didn't match");
				return ResponseResultUtil.error("对用户[" + user.getLoginName() + "]进行登录验证..验证失败-password didn't match");
			} catch (LockedAccountException lae) {
				logger.info("对用户[" + user.getLoginName() + "]进行登录验证..验证失败-account is locked in the system");
				return ResponseResultUtil.error("对用户[" + user.getLoginName() + "]进行登录验证..验证失败-account is locked in the system");
			} catch (AuthenticationException ae) {
				logger.error(ae.getMessage());
				return ResponseResultUtil.error(ae.getMessage());
			}
		}
		return null;
	}

	/**
	 * 退出
	 * @return
	 * @throws Exception 
	 */
	@GetMapping("logout")
    public ResponseResult logout() {
    	try {
    		SecurityUtils.getSubject().logout();
    		return ResponseResultUtil.success();
    	} catch (Exception e) {
			return ResponseResultUtil.error(e.getMessage());
    	}
    }

}
