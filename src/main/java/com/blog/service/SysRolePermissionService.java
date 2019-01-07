package com.blog.service;

import java.util.List;

import com.blog.model.po.SysRolePermissionPo;
import com.blog.model.vo.TreeVo;

public interface SysRolePermissionService {
	void saveSysRolePermissionList(List<TreeVo> tree, String roleId);
	void saveSysRolePermission(SysRolePermissionPo rolePermissionPo);
	void deleteSysRolePermission(String id);
}
