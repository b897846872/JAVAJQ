package com.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.blog.common.ResponseResultUtil;
import com.blog.model.ResponseResult;
import com.blog.model.po.SysPermissionPo;
import com.blog.service.SysPermissionService;

@RequestMapping("permission")
@RestController
public class SysPermissionController {
	private static Logger log = LoggerFactory.getLogger(SysPermissionController.class);
	@Autowired
	private SysPermissionService sysPermissionService;
	
	@GetMapping("findSysPermissionByUserId")
	@SuppressWarnings("rawtypes")
	public ResponseResult findSysPermissionByUserId(@RequestParam(required = true) String userId) {
		try {
			return ResponseResultUtil.success(sysPermissionService.findSysPermissionByUserId(userId));
		} catch (Exception e) {
			log.error(e.getMessage());
			return ResponseResultUtil.error(e.getMessage());
		}
	}
	
	@GetMapping("findSysPermissionAll")
	@SuppressWarnings("rawtypes")
	public ResponseResult findSysPermissionAll() {
		try {
			return ResponseResultUtil.success(sysPermissionService.findSysPermissionAll());
		} catch (Exception e) {
			log.error(e.getMessage());
			return ResponseResultUtil.error(e.getMessage());
		}
	}
	
	@GetMapping("findSysPermissionByRoleId")
	@SuppressWarnings("rawtypes")
	public ResponseResult findSysPermissionByRoleId(@RequestParam(required = true) String roleId) {
		try {
			return ResponseResultUtil.success(sysPermissionService.findSysPermissionByRoleId(roleId));
		} catch (Exception e) {
			log.error(e.getMessage());
			return ResponseResultUtil.error(e.getMessage());
		}
	}
	
	@PutMapping("save")
	@SuppressWarnings("rawtypes")
	public ResponseResult save(@RequestBody SysPermissionPo sysPermissionPo){
		try {
			sysPermissionService.saveSysPermission(sysPermissionPo);
		} catch (Exception e) {
			log.error(e.getMessage());
			return ResponseResultUtil.error(e.getMessage());
		}
		return ResponseResultUtil.success();
	}
	
	@PutMapping("update")
	@SuppressWarnings("rawtypes")
	public ResponseResult update(@RequestBody SysPermissionPo sysPermissionPo){
		try {
			sysPermissionService.updateSysPermission(sysPermissionPo);
		} catch (Exception e) {
			log.error(e.getMessage());
			return ResponseResultUtil.error(e.getMessage());
		}
		return ResponseResultUtil.success();
	}
	
	@DeleteMapping("delete")
	@SuppressWarnings("rawtypes")
	public ResponseResult delete(@RequestParam String id){
		try {
			sysPermissionService.deleteSysPermission(id);
		} catch (Exception e) {
			log.error(e.getMessage());
			return ResponseResultUtil.error(e.getMessage());
		}
		return ResponseResultUtil.success();
	}
	
}
