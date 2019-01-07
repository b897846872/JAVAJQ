package com.blog.service;

import org.springframework.stereotype.Service;

import com.blog.model.vo.SysPermissionVo;

@Service
public class RedisServiceImpl extends RedisService<String> {
    private static final String REDIS_KEY = "TEST_REDIS_KEY";

    @SuppressWarnings("static-access")
	@Override
    protected String getRedisKey() {
        return this.REDIS_KEY;
    }
}
