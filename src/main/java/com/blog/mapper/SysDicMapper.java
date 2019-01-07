package com.blog.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.blog.model.po.SysConfigPo;
import com.blog.model.po.SysDicPo;

import tk.mybatis.mapper.common.BaseMapper;

@Mapper
public interface SysDicMapper extends BaseMapper<SysConfigPo>{
	List<SysDicPo> findSysDicAll(String searchValue);
	List<SysDicPo> getDicType(String dicType);
	void saveSysDic(SysDicPo sysDicPo);
	void deleteSysDic(String id);
	void updateSysDic(SysDicPo sysDicPo);
}
