package com.blog.mapper;


import org.apache.ibatis.annotations.Mapper;
import com.blog.model.po.SysRolePermissionPo;

import tk.mybatis.mapper.common.BaseMapper;

@Mapper
public interface SysRolePermissionMapper extends BaseMapper<SysRolePermissionPo>{
	void saveSysRolePermission(SysRolePermissionPo rolePermissionPo);
	void deleteSysRolePermission(String id);
}
