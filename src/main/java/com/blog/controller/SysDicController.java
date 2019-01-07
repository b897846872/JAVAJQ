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
import com.blog.model.po.SysDicPo;
import com.blog.service.SysDicService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@RequestMapping("sysDic")
@RestController
public class SysDicController {
	private static Logger log = LoggerFactory.getLogger(SysDicController.class);
	@Autowired
	private SysDicService sysDicService;
	
	@GetMapping("list")
	@SuppressWarnings("rawtypes")
	public ResponseResult list(@RequestParam(required = true) String pageNum, 
									@RequestParam(required = true) String pageSize,
									@RequestParam(required = false) String searchValue) {
        PageHelper.startPage(Integer.parseInt(pageNum), Integer.parseInt(pageSize));
        PageInfo<SysDicPo> sysDicPageInfo = new PageInfo<>(sysDicService.findSysDicAll(searchValue));
        log.info("系统字典列表", sysDicPageInfo);
		return ResponseResultUtil.success(sysDicPageInfo);
	}
	
	@PutMapping("save")
	@SuppressWarnings("rawtypes")
	public ResponseResult save(@RequestBody SysDicPo sysDicPo){
		sysDicService.saveSysDic(sysDicPo);
		return ResponseResultUtil.success();
	}
	
	@DeleteMapping("delete")
	@SuppressWarnings("rawtypes")
	public ResponseResult delete(@RequestParam String id){
		sysDicService.deleteSysDic(id);
		return ResponseResultUtil.success();
	}
	
	@GetMapping("getDicType")
	@SuppressWarnings("rawtypes")
	public ResponseResult getDicType(@RequestParam(required = true) String dicType){
		return ResponseResultUtil.success(sysDicService.getDicType(dicType));
	}
	
	@PutMapping("updateSysDic")
	@SuppressWarnings("rawtypes")
	public ResponseResult updateSysDic(@RequestBody SysDicPo sysDicPo){
		sysDicService.updateSysDic(sysDicPo);
		return ResponseResultUtil.success();
	}
}
