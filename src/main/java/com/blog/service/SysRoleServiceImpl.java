package com.blog.service;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.common.Common;
import com.blog.common.UUIDGenerator;
import com.blog.mapper.SysRoleMapper;
import com.blog.model.annotation.OperLog;
import com.blog.model.po.SysRolePo;

@Service
public class SysRoleServiceImpl implements SysRoleService {
	
	@Autowired
	SysRoleMapper sysRoleMapper;

	@Override
	public List<SysRolePo> findSysRoleByUserId(String userId) throws Exception{
		List<SysRolePo> alllist = sysRoleMapper.findSysRoleAll(null);
		List<SysRolePo> userRolelist = sysRoleMapper.findSysRoleByUserId(userId);
		Iterator<SysRolePo> it = alllist.iterator();
		while (it.hasNext()) {
			SysRolePo po1 = (SysRolePo) it.next();
			for (int i = 0; i < userRolelist.size(); i++) {
				if (po1.getId().equals(userRolelist.get(i).getId())) {
					userRolelist.get(i).set_checked(true);
					it.remove();
				}
				
			}
		}
		alllist.addAll(userRolelist);
		return alllist;
	}

	@Override
	public List<SysRolePo> findSysRoleAll(String searchValue) {
		return sysRoleMapper.findSysRoleAll(searchValue);
	}

	@Override
	@OperLog(operateModule="保存角色")
	public void saveSysRole(SysRolePo sysRolePo) {
		sysRolePo.setCreateTime(new Date());
		sysRolePo.setId(UUIDGenerator.getUUID());
		sysRolePo.setUserId(Common.getCurrentUserId());
		sysRoleMapper.saveSysRole(sysRolePo);
	}

	@Override
	@OperLog(operateModule="删除角色")
	public void deleteSysRole(String id) {
		sysRoleMapper.deleteSysRole(id);
	}

	@Override
	@OperLog(operateModule="修改角色")
	public void updateSysRole(SysRolePo sysRolePo) {
		sysRolePo.setUpdateTime(new Date());
		sysRoleMapper.updateSysRole(sysRolePo);
	}
}
