package com.blog.service;

import java.util.List;
import java.util.Map;

import com.blog.model.po.TabArticlePo;
import com.blog.model.vo.TabArticleVo;

public interface TabArticleService {
	List<TabArticleVo> findTabArticle(Map<String, String> param);
	void saveTabArticle(TabArticlePo tabArticlePo);
	void deleteTabArticle(String id);
	void updateTabArticle(TabArticlePo tabArticlePo);
}
