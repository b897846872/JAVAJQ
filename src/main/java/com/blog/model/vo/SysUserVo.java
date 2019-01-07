package com.blog.model.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.blog.model.po.BasePo;
/**
 * @author qi
 */
public class SysUserVo extends BasePo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String loginName;
	private String realName;
	private String password;
	private String email;
	private String phone;
	private Date lastLoginTime;
	private String status;
	private List<String> roleStrList;
	private List<String> permissionStrList;
	
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<String> getRoleStrList() {
		return roleStrList;
	}
	public void setRoleStrList(List<String> roleStrList) {
		this.roleStrList = roleStrList;
	}
	public List<String> getPermissionStrList() {
		return permissionStrList;
	}
	public void setPermissionStrList(List<String> permissionStrList) {
		this.permissionStrList = permissionStrList;
	}
}
