package com.blog.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.blog.model.po.SysPermissionPo;
import com.blog.model.vo.SysPermissionVo;

import tk.mybatis.mapper.common.BaseMapper;

@Mapper
public interface SysPermissionMapper extends BaseMapper<SysPermissionPo>{
	List<SysPermissionVo> findSysPermissionByUserId(String userId);
	List<SysPermissionVo> findSysPermissionByRoleId(String roleId);
	List<SysPermissionVo> findSysPermissionAll();
	void saveSysPermission(SysPermissionPo sysPermissionPo);
	void deleteSysPermission(String id);
	void updateSysPermission(SysPermissionPo sysPermissionPo);
}
