package com.blog.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.blog.model.po.SysUserPo;
import com.blog.model.vo.SysUserVo;

import tk.mybatis.mapper.common.BaseMapper;

@Mapper
public interface SysUserMapper extends BaseMapper<SysUserPo>{
	List<SysUserPo> findUserAll(String searchValue);
	List<SysUserVo> findUserById(String id);
	List<SysUserVo> findUserByLoginName(String loginName);
	void saveSysUser(SysUserPo sysUserPo);
	void deleteSysUser(String id);
	void updateSysUser(SysUserPo sysUserPo);
	void updatePassword(SysUserPo sysUserPo);
	void updateSysUserToLoginTime(SysUserPo sysUserPo);
}
