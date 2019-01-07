package com.blog.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.common.UUIDGenerator;
import com.blog.mapper.SysUserMapper;
import com.blog.model.annotation.OperLog;
import com.blog.model.po.SysUserPo;
import com.blog.model.vo.SysUserVo;

@Service
public class SysUserServiceImpl implements SysUserService {
	@Autowired
	private SysUserMapper userMapper;
	@Autowired
	private SysUserRoleService sysUserRoleService;
	
	@Override
	public List<SysUserPo> findAllUser(String searchValue) {
		return userMapper.findUserAll(searchValue);
	}

	@Override
	public SysUserVo findUserById(String id) {
		List<SysUserVo> list = userMapper.findUserById(id);
		SysUserVo sysUser = new SysUserVo();
		if (list.size() > 0) {
			sysUser = list.get(0);
		}
		return sysUser;
	}

	@Override
	public SysUserVo findUserByLoginName(String loginName) {
		List<SysUserVo> list = userMapper.findUserByLoginName(loginName);
		SysUserVo sysUser = new SysUserVo();
		if (list.size() > 0) {
			sysUser = list.get(0);
		}
		return sysUser;
	}

	@Override
	@OperLog(operateModule="保存用户")
	public void saveSysUser(SysUserPo sysUserPo) {
		sysUserPo.setId(UUIDGenerator.getUUID());
		sysUserPo.setCreateTime(new Date());
		sysUserPo.setStatus("1");
		userMapper.saveSysUser(sysUserPo);
	}

	@Override
	@OperLog(operateModule="删除用户")
	public void deleteSysUser(String id) {
		userMapper.deleteSysUser(id);
		sysUserRoleService.deleteSysUserRole(id);
	}

	@Override
	@OperLog(operateModule="修改用户")
	public void updateSysUser(SysUserPo sysUserPo) {
		sysUserPo.setUpdateTime(new Date());
		userMapper.updateSysUser(sysUserPo);
	}

	@Override
	@OperLog(operateModule="修改密码")
	public void updatePassword(SysUserPo sysUserPo) {
		sysUserPo.setUpdateTime(new Date());
		userMapper.updatePassword(sysUserPo);
	}

	@Override
	@OperLog(operateModule="修改最后登录时间")
	public void updateSysUserToLoginTime(SysUserPo sysUserPo) {
		sysUserPo.setLastLoginTime(new Date());
		userMapper.updateSysUserToLoginTime(sysUserPo);
	}
	
}
