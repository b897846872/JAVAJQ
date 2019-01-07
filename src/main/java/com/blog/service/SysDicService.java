package com.blog.service;

import java.util.List;
import java.util.Map;

import com.blog.model.po.SysConfigPo;
import com.blog.model.po.SysDicPo;

public interface SysDicService {
	List<SysDicPo> findSysDicAll(String searchValue);
	void saveSysDic(SysDicPo sysDicPo);
	void deleteSysDic(String id);
	List<SysDicPo> getDicType(String dicType);
	void updateSysDic(SysDicPo sysDicPo);
}	
