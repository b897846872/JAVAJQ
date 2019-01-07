package com.blog.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import com.blog.model.po.TabCommentPo;
import tk.mybatis.mapper.common.BaseMapper;

@Mapper
public interface TabCommentMapper extends BaseMapper<TabCommentPo>{
	List<TabCommentPo> findTabCommentAll(Map<String, String> param);
	void saveTabComment(TabCommentPo tabCommentPo);
	void deleteTabComment(String id);
}
