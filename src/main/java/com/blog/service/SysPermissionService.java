package com.blog.service;

import java.util.List;

import com.blog.model.po.SysPermissionPo;
import com.blog.model.vo.SysPermissionVo;
import com.blog.model.vo.TreeVo;

public interface SysPermissionService {
	List<SysPermissionVo> findSysPermissionByUserId(String userId);
	List<TreeVo> findSysPermissionByRoleId(String roleId);
	List<TreeVo> findSysPermissionAll();
	void saveSysPermission(SysPermissionPo sysPermissionPo);
	void deleteSysPermission(String id);
	void updateSysPermission(SysPermissionPo sysPermissionPo);
}
