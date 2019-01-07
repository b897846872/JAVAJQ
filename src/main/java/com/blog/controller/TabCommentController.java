package com.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.blog.common.ResponseResultUtil;
import com.blog.model.ResponseResult;
import com.blog.model.po.SysConfigPo;
import com.blog.model.po.TabCommentPo;
import com.blog.service.SysConfigService;
import com.blog.service.TabCommentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@RequestMapping("tabComment")
@RestController
public class TabCommentController {
	private static Logger log = LoggerFactory.getLogger(TabCommentController.class);
	@Autowired
	private TabCommentService tabCommentService;
	
	@GetMapping("list")
	@SuppressWarnings("rawtypes")
	public ResponseResult list(@RequestParam(required = true) String pageNum, 
									@RequestParam(required = true) String pageSize,
									@RequestParam(required = false) String articleId,
									@RequestParam(required = false) String content) {
		Map<String, String> param = new HashMap<>();
		param.put("articleId", articleId);
		param.put("content", content);
        PageHelper.startPage(Integer.parseInt(pageNum), Integer.parseInt(pageSize));
        PageInfo<TabCommentPo> tabCommentPageInfo = new PageInfo<>(tabCommentService.findTabCommentAll(param));
		return ResponseResultUtil.success(tabCommentPageInfo);
	}
	
	@PutMapping("save")
	@SuppressWarnings("rawtypes")
	public ResponseResult save(@RequestBody TabCommentPo tabCommentPo){
		tabCommentService.saveTabComment(tabCommentPo);
		return ResponseResultUtil.success();
	}
	
	@DeleteMapping("delete")
	@SuppressWarnings("rawtypes")
	public ResponseResult delete(@RequestParam String id){
		tabCommentService.deleteTabComment(id);
		return ResponseResultUtil.success();
	}
}
