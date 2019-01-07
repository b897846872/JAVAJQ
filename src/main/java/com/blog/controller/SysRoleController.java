package com.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.blog.common.ResponseResultUtil;
import com.blog.model.ResponseResult;
import com.blog.model.po.SysRolePo;
import com.blog.model.vo.TreeVo;
import com.blog.service.SysRolePermissionService;
import com.blog.service.SysRoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@RequestMapping("role")
@RestController
public class SysRoleController {
	private static Logger log = LoggerFactory.getLogger(SysRoleController.class);
	@Autowired
	private SysRoleService sysRoleService;
	@Autowired
	private SysRolePermissionService sysRolePermissionService;
	
	@GetMapping("list")
	@SuppressWarnings("rawtypes")
	public ResponseResult list(@RequestParam(required = true) String pageNum, 
									@RequestParam(required = true) String pageSize,
									@RequestParam(required = false) String searchValue) {
        PageHelper.startPage(Integer.parseInt(pageNum), Integer.parseInt(pageSize));
        try {
        	PageInfo<SysRolePo> logPageInfo = new PageInfo<>(sysRoleService.findSysRoleAll(searchValue));
        	return ResponseResultUtil.success(logPageInfo);
		} catch (Exception e) {
			log.error(e.getMessage());
			return ResponseResultUtil.error(e.getMessage());
		}
	}
	
	@PutMapping("save")
	@SuppressWarnings("rawtypes")
	public ResponseResult save(@RequestBody SysRolePo sysRolePo){
		try {
			sysRoleService.saveSysRole(sysRolePo);
		} catch (Exception e) {
			log.error(e.getMessage());
			return ResponseResultUtil.error(e.getMessage());
		}
		return ResponseResultUtil.success();
	}
	
	@PutMapping("update")
	@SuppressWarnings("rawtypes")
	public ResponseResult update(@RequestBody SysRolePo sysRolePo){
		try {
			sysRoleService.updateSysRole(sysRolePo);
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
			sysRoleService.deleteSysRole(id);
		} catch (Exception e) {
			log.error(e.getMessage());
			return ResponseResultUtil.error(e.getMessage());
		}
		return ResponseResultUtil.success();
	}
	
	@PutMapping("saveRolePermission")
	@SuppressWarnings("rawtypes")
	public ResponseResult saveRolePermission(@RequestBody List<TreeVo> tree, 
						@RequestParam(required = true) String roleId){
		try {
			sysRolePermissionService.saveSysRolePermissionList(tree, roleId);
		} catch (Exception e) {
			log.error(e.getMessage());
			return ResponseResultUtil.error(e.getMessage());
		}
		return ResponseResultUtil.success();
	}
	
	@GetMapping("findUserRoleTab")
	@SuppressWarnings("rawtypes")
	public ResponseResult findUserRoleTab(@RequestParam(required = true) String pageNum, 
									@RequestParam(required = true) String pageSize,
									@RequestParam(required = true) String userId) {
        PageHelper.startPage(Integer.parseInt(pageNum), Integer.parseInt(pageSize));
        try {
        	PageInfo<SysRolePo> logPageInfo = new PageInfo<>(sysRoleService.findSysRoleByUserId(userId));
        	return ResponseResultUtil.success(logPageInfo);
		} catch (Exception e) {
			log.error(e.getMessage());
			return ResponseResultUtil.error(e.getMessage());
		}
	}
}
