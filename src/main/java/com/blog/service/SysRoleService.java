package com.blog.service;

import java.util.List;

import com.blog.model.po.SysRolePo;

public interface SysRoleService {
	List<SysRolePo> findSysRoleByUserId(String userId) throws Exception;
	List<SysRolePo> findSysRoleAll(String searchValue);
	void saveSysRole(SysRolePo sysRolePo);
	void deleteSysRole(String id);
	void updateSysRole(SysRolePo sysRolePo);
}