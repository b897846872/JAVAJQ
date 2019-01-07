package com.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.mapper.SysRolePermissionMapper;
import com.blog.model.annotation.OperLog;
import com.blog.model.po.SysRolePermissionPo;
import com.blog.model.vo.TreeVo;

@Service
public class SysRolePermissionServiceImpl implements SysRolePermissionService {
	@Autowired
	SysRolePermissionMapper sysRolePermissionMapper;

	@Override
	public void saveSysRolePermission(SysRolePermissionPo rolePermissionPo) {
		sysRolePermissionMapper.saveSysRolePermission(rolePermissionPo);
	}

	@Override
	public void deleteSysRolePermission(String id) {
		sysRolePermissionMapper.deleteSysRolePermission(id);
	}

	@Override
	@OperLog(operateModule="角色授权菜单权限")
	public void saveSysRolePermissionList(List<TreeVo> tree, String rid) {
		deleteSysRolePermission(rid);
		for (TreeVo treeVo : tree) {
			SysRolePermissionPo rp = new SysRolePermissionPo();
			rp.setRid(rid);
			rp.setPid(treeVo.getId());
			saveSysRolePermission(rp);
		}
	}
}
