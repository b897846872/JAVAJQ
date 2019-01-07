package com.blog.service;

import java.util.List;
import java.util.Map;

import com.blog.model.po.TabCommentPo;

public interface TabCommentService {
	List<TabCommentPo> findTabCommentAll(Map<String, String> param);
	void saveTabComment(TabCommentPo tabCommentPo);
	void deleteTabComment(String id);
}
