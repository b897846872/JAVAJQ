package com.blog.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.common.Common;
import com.blog.common.UUIDGenerator;
import com.blog.mapper.TabArticleMapper;
import com.blog.model.annotation.OperLog;
import com.blog.model.po.TabArticlePo;
import com.blog.model.vo.TabArticleVo;

@Service
public class TabArticleServiceImpl implements TabArticleService {
	@Autowired
	TabArticleMapper tabArticleMapper;
	
	@Override
	public List<TabArticleVo> findTabArticle(Map<String, String> param) {
		return tabArticleMapper.findTabArticle(param);
	}

	@Override
	@OperLog(operateModule="保存文章")
	public void saveTabArticle(TabArticlePo tabArticlePo) {
		tabArticlePo.setId(UUIDGenerator.getUUID());
		tabArticlePo.setCreateTime(new Date());
		tabArticlePo.setUserId(Common.getCurrentUserId());
		tabArticleMapper.saveTabArticle(tabArticlePo);
	}

	@Override
	@OperLog(operateModule="删除文章")
	public void deleteTabArticle(String id) {
		tabArticleMapper.deleteTabArticle(id);
	}

	@Override
	@OperLog(operateModule="修改文章")
	public void updateTabArticle(TabArticlePo tabArticlePo) {
		tabArticlePo.setUpdateTime(new Date());
		tabArticleMapper.updateTabArticle(tabArticlePo);
	}

}
