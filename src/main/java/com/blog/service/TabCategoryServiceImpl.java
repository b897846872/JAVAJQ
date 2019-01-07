package com.blog.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.common.Common;
import com.blog.common.UUIDGenerator;
import com.blog.mapper.TabCategoryMapper;
import com.blog.model.annotation.OperLog;
import com.blog.model.po.TabCategoryPo;
import com.blog.model.vo.TabCategoryVo;

@Service
public class TabCategoryServiceImpl implements TabCategoryService {
	
	@Autowired
	TabCategoryMapper tabCategoryMapper;
	
	@Override
	public List<TabCategoryVo> findTabCategoryAll(String searchValue) {
		return tabCategoryMapper.findTabCategoryAll(searchValue);
	}

	@Override
	@OperLog(operateModule="保存分类")
	public void saveTabCategory(TabCategoryPo tabCategoryPo) {
		tabCategoryPo.setId(UUIDGenerator.getUUID());
		tabCategoryPo.setCreateTime(new Date());
		tabCategoryPo.setUserId(Common.getCurrentUserId());
		tabCategoryMapper.saveTabCategory(tabCategoryPo);
	}

	@Override
	@OperLog(operateModule="删除分类")
	public void deleteTabCategory(String id) {
		tabCategoryMapper.deleteTabCategory(id);
	}

	@Override
	@OperLog(operateModule="修改分类")
	public void updateTabCategory(TabCategoryPo tabCategoryPo) {
		tabCategoryPo.setUpdateTime(new Date());
		tabCategoryMapper.updateTabCategory(tabCategoryPo);
	}

	@Override
	public List<TabCategoryVo> findTabCategoryByType(String typeCode) {
		return tabCategoryMapper.findTabCategoryByType(typeCode);
	}

}
