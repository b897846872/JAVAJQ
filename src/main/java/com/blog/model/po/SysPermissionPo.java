package com.blog.model.po;

import java.io.Serializable;
/**
 * @author qi
 */
public class SysPermissionPo extends BasePo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String url;
	private String name;
	private String code;
	/**
	 * function: 功能
	 * menu: 菜单
	 * main: 菜单的主目录
	 */
	private String type;
	private Integer orderl;
	private String parentId;
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getOrderl() {
		return orderl;
	}
	public void setOrderl(Integer orderl) {
		this.orderl = orderl;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	
}
