package com.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.blog.common.ResponseResultUtil;
import com.blog.model.ResponseResult;
import com.blog.model.po.SysConfigPo;
import com.blog.model.po.TabCategoryPo;
import com.blog.model.vo.TabCategoryVo;
import com.blog.service.SysConfigService;
import com.blog.service.TabCategoryService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@RequestMapping("tabCategory")
@RestController
public class TabCategoryController {
	private static Logger log = LoggerFactory.getLogger(TabCategoryController.class);
	@Autowired
	private TabCategoryService tabCategoryService;
	
	@GetMapping("list")
	@SuppressWarnings("rawtypes")
	public ResponseResult list(@RequestParam(required = true) String pageNum, 
									@RequestParam(required = true) String pageSize,
									@RequestParam(required = false) String searchValue) {
        PageHelper.startPage(Integer.parseInt(pageNum), Integer.parseInt(pageSize));
        PageInfo<TabCategoryVo> tabCategoryPageInfo = new PageInfo<>(tabCategoryService.findTabCategoryAll(searchValue));
		return ResponseResultUtil.success(tabCategoryPageInfo);
	}
	
	@GetMapping("categoryList")
	@SuppressWarnings("rawtypes")
	public ResponseResult findTabCategoryByType(@RequestParam(required = true) String typeCode) {
		return ResponseResultUtil.success(tabCategoryService.findTabCategoryByType(typeCode));
	}
	
	@PutMapping("save")
	@SuppressWarnings("rawtypes")
	public ResponseResult save(@RequestBody TabCategoryPo tabCategoryPo){
		tabCategoryService.saveTabCategory(tabCategoryPo);
		return ResponseResultUtil.success();
	}
	
	@DeleteMapping("delete")
	@SuppressWarnings("rawtypes")
	public ResponseResult delete(@RequestParam String id){
		tabCategoryService.deleteTabCategory(id);
		return ResponseResultUtil.success();
	}
	
	@PutMapping("update")
	@SuppressWarnings("rawtypes")
	public ResponseResult update(@RequestBody TabCategoryPo tabCategoryPo){
		tabCategoryService.updateTabCategory(tabCategoryPo);
		return ResponseResultUtil.success();
	}
}
