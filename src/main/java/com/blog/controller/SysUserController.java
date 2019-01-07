package com.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.blog.common.ResponseResultUtil;
import com.blog.model.ResponseResult;
import com.blog.model.po.SysRolePo;
import com.blog.model.po.SysUserPo;
import com.blog.service.SysUserRoleService;
import com.blog.service.SysUserRoleServiceImpl;
import com.blog.service.SysUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@RequestMapping("user")
@RestController
public class SysUserController {
	private static Logger log = LoggerFactory.getLogger(SysUserController.class);
	@Autowired
	private SysUserService userService;
	@Autowired
	private SysUserRoleService sysUserRoleService;
	
	@GetMapping("list")
	@SuppressWarnings("rawtypes")
	public ResponseResult list(@RequestParam(required = true) String pageNum, 
									@RequestParam(required = true) String pageSize,
									@RequestParam(required = false) String searchValue) {
        PageHelper.startPage(Integer.parseInt(pageNum), Integer.parseInt(pageSize));
        PageInfo<SysUserPo> userPageInfo = new PageInfo<>(userService.findAllUser(searchValue));
        log.info("用户列表", userPageInfo);
		return ResponseResultUtil.success(userPageInfo);
	}
	
	@GetMapping("getUser")
	@SuppressWarnings("rawtypes")
	public ResponseResult getUser(@RequestParam(required = true) String id) {
		try {
			return ResponseResultUtil.success(userService.findUserById(id));
		} catch (Exception e) {
			return ResponseResultUtil.error(e.getMessage());
		}
	}
	
	@PutMapping("save")
	@SuppressWarnings("rawtypes")
	public ResponseResult save(@RequestBody SysUserPo sysUserPo) {
		try {
			userService.saveSysUser(sysUserPo);
		} catch (Exception e) {
			return ResponseResultUtil.error(e.getMessage());
		}
		return ResponseResultUtil.success();
	}
	
	@PutMapping("update")
	@SuppressWarnings("rawtypes")
	public ResponseResult update(@RequestBody SysUserPo sysUserPo) {
		try {
			userService.updateSysUser(sysUserPo);
		} catch (Exception e) {
			return ResponseResultUtil.error(e.getMessage());
		}
		return ResponseResultUtil.success();
	}
	
	@PutMapping("updatePassword")
	@SuppressWarnings("rawtypes")
	public ResponseResult updatePassword(@RequestBody SysUserPo sysUserPo) {
		try {
			userService.updatePassword(sysUserPo);
		} catch (Exception e) {
			return ResponseResultUtil.error(e.getMessage());
		}
		return ResponseResultUtil.success();
	}
	
	@DeleteMapping("delete")
	@SuppressWarnings("rawtypes")
	public ResponseResult delete(@RequestParam(required = true) String id) {
		try {
			userService.deleteSysUser(id);
		} catch (Exception e) {
			return ResponseResultUtil.error(e.getMessage());
		}
		return ResponseResultUtil.success();
	}
	
	@PutMapping("saveUserRole")
	@SuppressWarnings("rawtypes")
	public ResponseResult saveUserRole(@RequestBody List<SysRolePo> sysRolelist,
				@RequestParam(required = true) String userId) {
		try {
			sysUserRoleService.saveUserRoleList(sysRolelist, userId);
		} catch (Exception e) {
			return ResponseResultUtil.error(e.getMessage());
		}
		return ResponseResultUtil.success();
	}
}
