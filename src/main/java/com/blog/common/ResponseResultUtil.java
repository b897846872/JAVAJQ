package com.blog.common;

import com.blog.model.ResponseResult;

/**
 * 封装返回结果
 * @author qi
 */
public class ResponseResultUtil {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static ResponseResult success(Object obj){
		ResponseResult result = new ResponseResult<>(0, "");
		result.setData(obj);
		return result;
	}
	
	@SuppressWarnings("rawtypes")
	public static ResponseResult error(String message){
		ResponseResult result = new ResponseResult<>(-1, message);
		return result;
	}

	public static ResponseResult success() {
		ResponseResult result = new ResponseResult<>(0, "");
		return result;
	}
}
