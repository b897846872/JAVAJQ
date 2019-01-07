package com.blog.service;

import java.util.List;

import com.blog.model.po.SysLogPo;

public interface SysLogService {
	List<SysLogPo> findSysLogAll(String searchValue);
	void saveSysLog(SysLogPo logPo);
}	
