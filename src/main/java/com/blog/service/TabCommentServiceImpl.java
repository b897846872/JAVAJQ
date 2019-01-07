package com.blog.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.common.UUIDGenerator;
import com.blog.mapper.TabCommentMapper;
import com.blog.model.annotation.OperLog;
import com.blog.model.po.TabCommentPo;

@Service
public class TabCommentServiceImpl implements TabCommentService {
	
	@Autowired
	TabCommentMapper tabCommentMapper;
	
	@Override
	public List<TabCommentPo> findTabCommentAll(Map<String, String> param) {
		return tabCommentMapper.findTabCommentAll(param);
	}

	@Override
	@OperLog(operateModule="保存评论")
	public void saveTabComment(TabCommentPo tabCommentPo) {
		tabCommentPo.setId(UUIDGenerator.getUUID());
		tabCommentPo.setCreateTime(new Date());
		tabCommentMapper.saveTabComment(tabCommentPo);
	}

	@Override
	@OperLog(operateModule="删除评论")
	public void deleteTabComment(String id) {
		tabCommentMapper.deleteTabComment(id);
	}

}
