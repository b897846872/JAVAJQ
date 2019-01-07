package com.blog.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

import com.blog.model.po.SysConfigPo;

import tk.mybatis.mapper.common.BaseMapper;

@Mapper
public interface SysConfigMapper extends BaseMapper<SysConfigPo>{
	List<SysConfigPo> findSysConfigAll(String searchValue);
	List<SysConfigPo> findSysConfigByName(String name);
	void saveSysConfig(SysConfigPo sysconfigPo);
	void deleteSysConfig(String id);
	void updateSysConfig(SysConfigPo sysconfigPo);
}
