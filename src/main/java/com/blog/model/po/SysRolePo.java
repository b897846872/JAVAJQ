package com.blog.model.po;

import java.io.Serializable;
/**
 * @author qi
 */
public class SysRolePo extends BasePo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String type;
	private Boolean _checked = false;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Boolean get_checked() {
		return _checked;
	}
	public void set_checked(Boolean _checked) {
		this._checked = _checked;
	}
}
