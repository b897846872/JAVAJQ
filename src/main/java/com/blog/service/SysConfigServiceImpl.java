package com.blog.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.common.Common;
import com.blog.common.UUIDGenerator;
import com.blog.mapper.SysConfigMapper;
import com.blog.model.annotation.OperLog;
import com.blog.model.po.SysConfigPo;
@Service
public class SysConfigServiceImpl implements SysConfigService {
	@Autowired
	SysConfigMapper sysConfigMapper;
	
	@Override
	public List<SysConfigPo> findSysConfigAll(String searchValue) {
		return sysConfigMapper.findSysConfigAll(searchValue);
	}

	@Override
	@OperLog(operateModule="保存系统配置")
	public void saveSysConfig(SysConfigPo sysconfigPo) {
		sysconfigPo.setId(UUIDGenerator.getUUID());
		sysconfigPo.setCreateTime(new Date());
		sysconfigPo.setUserId(Common.getCurrentUserId());
		sysConfigMapper.saveSysConfig(sysconfigPo);
	}

	@Override
	@OperLog(operateModule="删除系统配置")
	public void deleteSysConfig(String id) {
		sysConfigMapper.deleteSysConfig(id);
	}

	@Override
	@OperLog(operateModule="修改系统配置")
	public void updateSysConfig(SysConfigPo sysconfigPo) {
		sysconfigPo.setUpdateTime(new Date());
		sysConfigMapper.updateSysConfig(sysconfigPo);
	}

	@Override
	public SysConfigPo findSysConfigByName(String name) {
		List<SysConfigPo> list = sysConfigMapper.findSysConfigByName(name);
		SysConfigPo sysConfigPo = new SysConfigPo();
		if (list.size() > 0){
			sysConfigPo = list.get(0);
		}
		return sysConfigPo;
	}

}
