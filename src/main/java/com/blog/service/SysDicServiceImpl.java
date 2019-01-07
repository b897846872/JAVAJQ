package com.blog.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.common.Common;
import com.blog.common.UUIDGenerator;
import com.blog.mapper.SysDicMapper;
import com.blog.model.annotation.OperLog;
import com.blog.model.po.SysDicPo;

@Service
public class SysDicServiceImpl implements SysDicService {
	
	@Autowired
	SysDicMapper sysDicMapper;
	
	
	@Override
	public List<SysDicPo> findSysDicAll(String searchValue) {
		return sysDicMapper.findSysDicAll(searchValue);
	}

	@Override
	@OperLog(operateModule="保存数据字典")
	public void saveSysDic(SysDicPo sysDicPo) {
		sysDicPo.setId(UUIDGenerator.getUUID());
		sysDicPo.setCreateTime(new Date());
		sysDicPo.setUserId(Common.getCurrentUserId());
		sysDicMapper.saveSysDic(sysDicPo);
	}

	@Override
	@OperLog(operateModule="删除数据字典")
	public void deleteSysDic(String id) {
		sysDicMapper.deleteSysDic(id);
	}

	@Override
	public List<SysDicPo> getDicType(String sysDicPo) {
		return sysDicMapper.getDicType(sysDicPo);
	}

	@Override
	@OperLog(operateModule="修改数据字典")
	public void updateSysDic(SysDicPo sysDicPo) {
		sysDicPo.setUpdateTime(new Date());
		sysDicMapper.updateSysDic(sysDicPo);
	}

}
