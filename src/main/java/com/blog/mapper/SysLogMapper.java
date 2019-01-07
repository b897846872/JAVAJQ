package com.blog.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.blog.model.po.SysLogPo;

import tk.mybatis.mapper.common.BaseMapper;

@Mapper
public interface SysLogMapper extends BaseMapper<SysLogPo>{
	List<SysLogPo> findSysLogAll(String searchValue);
	void saveSysLog(SysLogPo logPo);
}
