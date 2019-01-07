package com.blog.model.po;

import java.io.Serializable;
/**
 * @author qi
 */
public class SysRolePermissionPo extends BasePo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String rid;
	private String pid;
	public String getRid() {
		return rid;
	}
	public void setRid(String rid) {
		this.rid = rid;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
}
