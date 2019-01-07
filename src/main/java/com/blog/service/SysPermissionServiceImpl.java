package com.blog.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.common.TreeToolUtils;
import com.blog.common.UUIDGenerator;
import com.blog.mapper.SysPermissionMapper;
import com.blog.model.annotation.OperLog;
import com.blog.model.po.SysPermissionPo;
import com.blog.model.vo.SysPermissionVo;
import com.blog.model.vo.TreeVo;

@Service
public class SysPermissionServiceImpl implements SysPermissionService {
	
	@Autowired
	SysPermissionMapper sysPermissionMapper;
	
	@Override
	public List<SysPermissionVo> findSysPermissionByUserId(String userId) {
		return sysPermissionMapper.findSysPermissionByUserId(userId);
	}

	@Override
	@OperLog(operateModule="保存菜单")
	public void saveSysPermission(SysPermissionPo sysPermissionPo) {
		sysPermissionPo.setCreateTime(new Date());
		sysPermissionPo.setId(UUIDGenerator.getUUID());
		sysPermissionMapper.saveSysPermission(sysPermissionPo);
	}

	@Override
	@OperLog(operateModule="删除菜单")
	public void deleteSysPermission(String id) {
		sysPermissionMapper.deleteSysPermission(id);
	}

	@Override
	@OperLog(operateModule="修改菜单")
	public void updateSysPermission(SysPermissionPo sysPermissionPo) {
		sysPermissionMapper.updateSysPermission(sysPermissionPo);
	}

	@Override
	public List<TreeVo> findSysPermissionAll() {
		List<SysPermissionVo> sysPermissionVolist = sysPermissionMapper.findSysPermissionAll();
		List<TreeVo> rootList = new ArrayList<>();
	    List<TreeVo> bodyList = new ArrayList<>();
	    
		if (sysPermissionVolist.size() > 0) {
			for (SysPermissionVo sysPermissionVo : sysPermissionVolist) {
				TreeVo tree = new TreeVo();
				tree.setTitle(sysPermissionVo.getName());
				tree.setCode(sysPermissionVo.getCode());
				tree.setId(sysPermissionVo.getId());
				tree.setParentId(sysPermissionVo.getParentId());
				tree.setParentName(sysPermissionVo.getParentName());
				tree.setSysPermissionVo(sysPermissionVo);
				if ("main".equals(sysPermissionVo.getType())) {
					rootList.add(tree);
//					continue;
				}
				bodyList.add(tree);
			}
		}
		TreeToolUtils toolUtils = new TreeToolUtils(rootList, bodyList);
		List<TreeVo> list = toolUtils.getTree();
		return list;
	}

	@Override
	public List<TreeVo> findSysPermissionByRoleId(String roleId) {
		List<SysPermissionVo> rolePermissionlist = sysPermissionMapper.findSysPermissionByRoleId(roleId);
		List<SysPermissionVo> alllist = sysPermissionMapper.findSysPermissionAll();
		List<TreeVo> rootList = new ArrayList<>();
	    List<TreeVo> bodyList = new ArrayList<>();
		for (SysPermissionVo p1 : alllist) {
			TreeVo tree = new TreeVo();
			for (SysPermissionVo p2 : rolePermissionlist) {
				if (p1.getId().equals(p2.getId())) {
					tree.setChecked(true);
					break;
				}
			}
			tree.setTitle(p1.getName());
			tree.setCode(p1.getCode());
			tree.setId(p1.getId());
			tree.setParentId(p1.getParentId());
			tree.setParentName(p1.getParentName());
			tree.setSysPermissionVo(p1);
			if ("main".equals(p1.getType())) {
				rootList.add(tree);
			}
			bodyList.add(tree);
		}
		TreeToolUtils toolUtils = new TreeToolUtils(rootList, bodyList);
		return toolUtils.getTree();
	}
	
}
