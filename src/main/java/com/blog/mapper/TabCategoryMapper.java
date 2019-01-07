package com.blog.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

import com.blog.model.po.TabCategoryPo;
import com.blog.model.vo.TabCategoryVo;

import tk.mybatis.mapper.common.BaseMapper;

@Mapper
public interface TabCategoryMapper extends BaseMapper<TabCategoryPo>{
	List<TabCategoryVo> findTabCategoryAll(String searchValue);
	List<TabCategoryVo> findTabCategoryByType(String typeCode);
	void saveTabCategory(TabCategoryPo tabCategoryPo);
	void deleteTabCategory(String id);
	void updateTabCategory(TabCategoryPo tabCategoryPo);
}
