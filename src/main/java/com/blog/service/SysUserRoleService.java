package com.blog.service;


import java.util.List;

import com.blog.model.po.SysRolePo;
import com.blog.model.po.SysUserRolePo;

public interface SysUserRoleService {
	void saveUserRoleList(List<SysRolePo> list, String userId);
	void saveUserRole(SysUserRolePo sysUserRolePo);
	void deleteSysUserRole(String id);
}
