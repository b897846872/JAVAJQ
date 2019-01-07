package com.blog.mapper;


import org.apache.ibatis.annotations.Mapper;

import com.blog.model.po.SysUserRolePo;

import tk.mybatis.mapper.common.BaseMapper;

@Mapper
public interface SysUserRoleMapper extends BaseMapper<SysUserRolePo>{
	void saveSysUserRole(SysUserRolePo sysUserRolePo);
	void deleteSysUserRole(String id);
}
