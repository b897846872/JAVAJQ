package com.blog.service;

import java.util.List;

import com.blog.model.po.TabCategoryPo;
import com.blog.model.vo.TabCategoryVo;

public interface TabCategoryService {
	List<TabCategoryVo> findTabCategoryAll(String searchValue);
	void saveTabCategory(TabCategoryPo tabCategoryPo);
	void deleteTabCategory(String id);
	void updateTabCategory(TabCategoryPo tabCategoryPo);
	List<TabCategoryVo> findTabCategoryByType(String typeCode);
}
